package com.creditsuisse.parser.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditsuisse.parser.dao.ServerLogsDao;
import com.creditsuisse.parser.service.LogParser;

public class ServerLogsHandlerApplication {
	private static final Logger logger = LoggerFactory.getLogger(ServerLogsHandlerApplication.class);

	public static void main(String[] args) {

		String file = args[0];

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			ServerLogsDao serverLogsDao = new ServerLogsDao();
			serverLogsDao.createEventsTable();

			logger.debug("Parsing file <" + file + "> for events.");
			LogParser parser = new LogParser();
			parser.parseLogs(reader, serverLogsDao);

			serverLogsDao.selectAll();
			serverLogsDao.deleteAll();
			serverLogsDao.closeDatabase();
		} catch (IOException exception) {
			logger.error("Error parsing file < " + file + " >");
			exception.printStackTrace();
		} catch (SQLException sql) {
			logger.error("Error encountered with DB");
			sql.printStackTrace();
		}

	}

}
