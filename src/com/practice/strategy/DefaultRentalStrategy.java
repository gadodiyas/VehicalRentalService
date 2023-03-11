package com.practice.strategy;

import com.practice.model.Booking;
import com.practice.model.Branch;
import com.practice.model.Rental;
import com.practice.model.Vehicle;
import com.practice.model.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class DefaultRentalStrategy implements RentalStrategy {

	@Override
	public Vehicle bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime, int userId, Rental rental) {
		Vehicle minPriceVehicle = null;
		Branch minbranch = null;
		double min = Double.MAX_VALUE;
		for (Branch branch : rental.getBranches().values()) {
			Vehicle vehicle = branch.isVehicleAvailableForTypeAndTime(vehicleType, startTime, endTime);

			if(vehicle != null) {
				if(min > branch.getPriceMap().get(vehicleType)) {
					min = branch.getPriceMap().get(vehicleType);
					minPriceVehicle = vehicle;
					minbranch = branch;
				}

			}
		}
		minPriceVehicle.setBooked(true);
		Booking booking = new Booking(userId, startTime, endTime, min);
		if(minbranch.getBookedVehicles().containsKey(minPriceVehicle.getVehicleId())){
			minbranch.getBookedVehicles().get(minPriceVehicle.getVehicleId()).add(booking);
		}
		else {
			TreeSet<Booking> bookings = new TreeSet<>(Comparator.comparing(Booking::getStartTime));
			bookings.add(booking);
			minbranch.getBookedVehicles().put(minPriceVehicle.getVehicleId(), bookings);
		}
		System.out.println("Vehical id: " + minPriceVehicle.getVehicleId() + " branch: " + minbranch.getBranchName() + " fair:" + min);
		return minPriceVehicle;
	}
}
