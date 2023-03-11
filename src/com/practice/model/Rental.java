package com.practice.model;

import com.practice.strategy.RentalStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rental {
	static int cnt = 0;



	Map<String, Branch> branches = new HashMap<>();
	Map<VehicleType,  lis>
	RentalStrategy rentalStrategy;

	public Rental(RentalStrategy strategy) {
		this.rentalStrategy = strategy;
	}

	public Map<String, Branch> getBranches() {
		return branches;
	}
	public Branch addBranch(String name) {
		cnt++;
		Branch branch = new Branch(cnt, name);
		if(branches.containsKey(name))
			throw new RuntimeException("Branch already exist with given name, try new name");
		branches.put(name, branch);
		System.out.println("A new branch is added with id:" + branch.getId() + " name:" + branch.getBranchName() );
		return branch;
	}

	public void allocatePrice(String branchName, VehicleType vehicleType, double price) {
		Branch branch = branches.get(branchName);
		if(branch == null) {
			throw  new RuntimeException("Branch Not Found");
		}
		branch.addPrice(vehicleType, price);
	}

	public void addVehicle(String vehicleId, VehicleType vehicleType, String branchName) {
		Branch branch = branches.get(branchName);
		if(branch == null) {
			throw  new RuntimeException("Branch Not Found");
		}
		branch.addVehicle(vehicleId, vehicleType);
	}

	public void bookVehicle(VehicleType vehicleType, LocalDateTime start, LocalDateTime end, int userId) {
		Vehicle vehicle = rentalStrategy.bookVehicle(vehicleType, start, end, userId, this);
	}

	public List<Vehicle> viewVehicleInventory(LocalDateTime start, LocalDateTime end) {

	}
}
