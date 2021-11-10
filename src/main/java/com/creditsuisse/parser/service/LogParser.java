package com.creditsuisse.parser.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.creditsuisse.parser.builder.EventBuilder;
import com.creditsuisse.parser.dao.ServerLogsDao;
import com.creditsuisse.parser.model.Event;
import com.creditsuisse.parser.model.ServerLog;
import com.google.gson.Gson;

public class LogParser {

	public void parseLogs(BufferedReader reader, ServerLogsDao serverLogsDao) throws IOException, SQLException {
		Map<String, ServerLog> eventMap = new HashMap<>();
		Gson gson = new Gson();
		String line;
		while ((line = reader.readLine()) != null) {
			ServerLog log = gson.fromJson(line, ServerLog.class);
			String eventId = log.getId();
			if (!eventMap.containsKey(eventId)) {
				eventMap.put(eventId, log);
				continue;
			}

			ServerLog previousLog = eventMap.remove(eventId);
			long duration = Math.abs(log.getTimeStamp() - previousLog.getTimeStamp());
			boolean alert = false;
			if (duration > 4) {
				alert = true;
			}

			Event event = new EventBuilder(eventId, duration, alert).withHost(log.getHost()).withType(log.getType())
					.build();
			serverLogsDao.writeEvent(event);
		}
	}
}
