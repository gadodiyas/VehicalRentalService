package com.practice;

import com.practice.controller.VehicleManager;
import com.practice.model.Branch;
import com.practice.model.Rental;
import com.practice.model.VehicleType;
import com.practice.strategy.DefaultRentalStrategy;
import com.practice.strategy.RentalStrategy;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RentalStrategy strategy = new DefaultRentalStrategy();

        Rental rentalService  = new Rental(strategy);
        Branch branch = rentalService.addBranch("ABC");
        rentalService.allocatePrice(branch.getBranchName(), VehicleType.SUV, 300);
        rentalService.addVehicle("MH123", VehicleType.SUV, "ABC");
        rentalService.bookVehicle(VehicleType.SUV, LocalDateTime.now(), LocalDateTime.of(2023, Month.MARCH, 9, 20, 0), 1);
        rentalService.viewVehicleInventory(LocalDateTime.of(2023, Month.MARCH, 9, 20, 0), LocalDateTime.now());

    }
}
