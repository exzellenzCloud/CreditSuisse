package com.creditsuisse.parser.model;

public class Event {
    private String id;
    private long duration;
    private boolean alert;
    private String type;
    private String host;


    public String getId() {
        return this.id;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getType() {
        return this.type;
    }

    public String getHost() {
        return this.host;
    }

    public boolean isAlert() {
        return this.alert;
    }

	public void setId(String id) {
		this.id = id;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setHost(String host) {
		this.host = host;
	}

    
}
