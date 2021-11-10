package com.creditsuisse.parser.builder;

import com.creditsuisse.parser.model.Event;

public class EventBuilder {
	private final String id;
	private final long duration;
	private final boolean alert;
	private String type;
	private String host;

	public EventBuilder(String id, long duration, boolean alert) {
		this.id = id;
		this.duration = duration;
		this.alert = alert;
	}

	public EventBuilder withType(String type) {
		this.type = type;
		return this;
	}

	public EventBuilder withHost(String host) {
		this.host = host;
		return this;
	}

	public Event build() {
		Event event = new Event();
		event.setAlert(this.alert);
		event.setDuration(this.duration);
		event.setType(this.type);
		event.setHost(this.host);
		event.setId(this.id);
		return event;
	}
}