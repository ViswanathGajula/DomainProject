package com.bikeapp.service;

import java.util.List;

import com.bikeapp.dao.BikeDaoImpl;
import com.bikeapp.dao.IBikeDao;
import com.bikeapp.exceptions.BikeNotFoundException;
import com.bikeapp.model.Bike;

public class BikeServiceImlp implements IBikeService {

	IBikeDao bikeService =new BikeDaoImpl();
	
	@Override
	public void addBike(Bike bike) {
		bikeService.addBike(bike);
	}

	@Override
	public void updateBike(int modelId, double modelprice) {
		bikeService.updateBike(modelId, modelprice);
	}

	@Override
	public Bike getById(int modelId) {
		return bikeService.getById(modelId);
	}

	@Override
	public void deleteBike(int modelId) {
		bikeService.deleteBike(modelId);
	}

	@Override
	public List<Bike> getAllBikes() {
	
		return bikeService.getAllBikes();
	}

	@Override
	public List<Bike> getByBrandname(String brandname) throws BikeNotFoundException {
		return bikeService.getByBrandname(brandname);
	}

	@Override
	public List<Bike> getByBrandnameAndModelname(String brandname, String modelname) throws BikeNotFoundException {
		return bikeService.getByBrandnameAndModelname(brandname, modelname);
	}

	@Override
	public List<Bike> getByBrandnameAndModelprice(String brandname, double modelprice) throws BikeNotFoundException {
		return bikeService.getByBrandnameAndModelprice(brandname, modelprice);
	}

}
