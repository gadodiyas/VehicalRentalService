package com.practice.model;

public class Vehicle {
	private String vehicleId;
	private VehicleType vehicleType;
	private String branchName;

	public void setBooked(boolean booked) {
		isBooked = booked;
	}

	public boolean isBooked() {
		return isBooked;
	}

	private boolean isBooked;


	public String getVehicleId() {
		return vehicleId;
	}

	public Vehicle(String vehicleId, VehicleType vehicleType, String branchName) {
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.branchName = branchName;
	}
}
