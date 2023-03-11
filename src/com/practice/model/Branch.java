package com.practice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Branch {
	public int getId() {
		return id;
	}

	public String getBranchName() {
		return branchName;
	}

	private int id;
	private String branchName;

	public Map<VehicleType, Double> getPriceMap() {
		return priceMap;
	}

	public Map<VehicleType, List<Vehicle>> getVehiclemap() {
		return vehiclemap;
	}

	public Map<String, TreeSet<Booking>> getBookedVehicles() {
		return bookedVehicles;
	}

	private Map<VehicleType, List<Vehicle>> vehiclemap = new HashMap<>();
	private Map<VehicleType, Double> priceMap = new HashMap<>();
	Map<String, TreeSet<Booking>> bookedVehicles = new HashMap<>();

	public Branch(int id, String name) {
		this.id = id;
		this.branchName = name;
		for(VehicleType vehicleType : VehicleType.values()) {
			vehiclemap.put(vehicleType, new ArrayList<>());
			priceMap.put(vehicleType, 0d);
		}
	}


	public void addPrice(VehicleType vehicleType, double price) {
		priceMap.put(vehicleType, price);
		System.out.println("Price updated for branch:" + branchName+" and vehicle:" + vehicleType+ " to:" + price);
	}

	public void addVehicle(String vehicleId, VehicleType vehicleType) {
		vehiclemap.get(vehicleType).add(new Vehicle(vehicleId, vehicleType, branchName));
		displayVehicles();

	}

	public void displayVehicles(){
		System.out.println("Current List of Vehicles");
		for (VehicleType vehicleType : vehiclemap.keySet()){
			for (Vehicle vehicle : vehiclemap.get(vehicleType)){
				System.out.println("VehicleType:" + vehicleType + "    id: " + vehicle.getVehicleId());
			}
		}
	}

	public Vehicle isVehicleAvailableForTypeAndTime(VehicleType vehicleType, LocalDateTime start, LocalDateTime end){
		for(Vehicle v : vehiclemap.get(vehicleType)) {
			if(v.isBooked()){
				for(Booking booking : bookedVehicles.get(v.getVehicleId())){
					if(start.isBefore(booking.startTime) && end.isBefore(booking.endTime))
						return v;
					if(start.isBefore(booking.startTime))
						break;
				}
			}
			else
				return v;
		}
		return null;

	}


}
