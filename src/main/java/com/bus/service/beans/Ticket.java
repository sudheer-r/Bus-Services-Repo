package com.bus.service.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Ticket {
	private String source;
	private String destination;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	private String travels;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTravels() {
		return travels;
	}

	public void setTravels(String travels) {
		this.travels = travels;
	}
}
