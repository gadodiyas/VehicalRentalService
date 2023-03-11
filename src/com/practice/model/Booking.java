package com.practice.model;

import java.time.LocalDateTime;

public class Booking {
	int userId;

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	LocalDateTime startTime;
	LocalDateTime endTime;
	double fair;

	public Booking(int userId, LocalDateTime startTime, LocalDateTime endTime, double fair) {
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fair = fair;
	}
}
