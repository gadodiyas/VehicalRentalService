package com.practice.strategy;

import com.practice.model.Booking;
import com.practice.model.Rental;
import com.practice.model.Vehicle;
import com.practice.model.VehicleType;

import java.time.LocalDateTime;

public interface RentalStrategy {
	Vehicle bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime, int userId, Rental rental);
}
