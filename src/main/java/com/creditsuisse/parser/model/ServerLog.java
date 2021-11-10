package com.creditsuisse.parser.model;

public class ServerLog {
	private long timestamp;
	private String id;
	private String state;
	private String host;
	private String type;

	public long getTimeStamp() {
		return this.timestamp;
	}

	public String getId() {
		return this.id;
	}

	public String getHost() {
		return this.host;
	}

	public String getType() {
		return this.type;
	}

	public String getState() {
		return this.state;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setType(String type) {
		this.type = type;
	}

}
