package com.creditsuisse.parser.builder;

import com.creditsuisse.parser.model.ServerLog;

public class ServerLogBuilder {
	private final String id;
	private final long timestamp;
	private final String state;
	private String host;
	private String type;

	public ServerLogBuilder(String id, long timestamp, String state) {
		this.id = id;
		this.timestamp = timestamp;
		this.state = state;
	}

	public ServerLogBuilder withType(String type) {
		this.type = type;
		return this;
	}

	public ServerLogBuilder withHost(String host) {
		this.host = host;
		return this;
	}

	public ServerLog build() {
		ServerLog serverLog = new ServerLog();
		serverLog.setHost(host);
		serverLog.setId(id);
		serverLog.setState(state);
		serverLog.setTimestamp(timestamp);
		serverLog.setType(type);
		return serverLog;
	}
}