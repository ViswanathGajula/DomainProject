package com.bikeapp.exceptions;

public class BikeNotFoundException extends RuntimeException {

	public BikeNotFoundException() {
		super();
	}

	public BikeNotFoundException(String message) {
		super(message);
	}

}
