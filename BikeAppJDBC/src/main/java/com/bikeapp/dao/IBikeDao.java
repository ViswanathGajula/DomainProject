package com.bikeapp.dao;

import java.util.List;

import com.bikeapp.exceptions.BikeNotFoundException;
import com.bikeapp.model.Bike;

public interface IBikeDao {

		void addBike(Bike bike);

		void updateBike(int modelId, double modelprice);

		Bike getById(int modelId);

		void deleteBike(int modelId);

		List<Bike> getAllBikes();

		List<Bike> getByBrandname(String brandname) throws BikeNotFoundException;

		List<Bike> getByBrandnameAndModelname(String brandname, String modelname) throws BikeNotFoundException;

		List<Bike> getByBrandnameAndModelprice(String brandname, double modelprice) throws BikeNotFoundException;

	}


