package com.bikeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bikeapp.exceptions.BikeNotFoundException;
import com.bikeapp.model.Bike;
import com.bikeapp.util.DbConnection;
import com.bikeapp.util.Queries;

public class BikeDaoImpl implements IBikeDao {

	@Override
	public void addBike(Bike bike) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERTQUERY);) {
			preparedStatement.setString(1, bike.getModelname());
			preparedStatement.setDouble(2, bike.getModelprice());
			preparedStatement.setString(3, bike.getBrandname());
			preparedStatement.setInt(4, bike.getBrandId());
//			preparedStatement.setInt(5, bike.getModelId());
			preparedStatement.execute();
			System.out.println("Bike added sucesfully");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateBike(int modelId, double modelprice) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATEQUERY);) {
			preparedStatement.setDouble(1, modelprice);
			preparedStatement.setInt(2, modelId);
			preparedStatement.execute();
			System.out.println("Bike updated sucesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return 0;
		// return modelId;
	}

	@Override
	public Bike getById(int modelId) {
		Bike bike = new Bike();
		// TODO Auto-generated method stub
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.QUERYBYID);) {
			preparedStatement.setInt(1, modelId);
			try (ResultSet rt = preparedStatement.executeQuery();) {
				while (rt.next()) {

					String name = rt.getString("modelname");
					Double price = rt.getDouble("modelprice");
					String brandname = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					bike.setModelname(name);
					bike.setModelprice(price);
					bike.setBrandname(brandname);
					bike.setBrandId(brandId);
					System.out.println("bike found sucesfully");
					System.out.println(bike.toString());
				}
				return bike;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBike(int modelId) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETEBYID);) {
			preparedStatement.setInt(1, modelId);
			preparedStatement.execute();
			System.out.println("Bike with id: " + modelId + " sucessfully deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Bike> getAllBikes() {

		List<Bike> bikeList = new ArrayList<Bike>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Queries.GETALLQUERY);) {
			System.out.println("Fetching all bikes...");
			try (ResultSet bikeResultSet = preparedStatement.executeQuery();) {
				while (bikeResultSet.next()) {

					String name = bikeResultSet.getString("modelname");
					Double price = bikeResultSet.getDouble("modelprice");
					String brandname = bikeResultSet.getString("brandname");
					int brandId = bikeResultSet.getInt("brandId");
					int modelId = bikeResultSet.getInt("modelId");
					Bike bike = new Bike(name, modelId, price, brandname, brandId);

					bikeList.add(bike);
					System.out.println(bike.toString());
				}
			}
			return bikeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bike> getByBrandname(String brandname) throws BikeNotFoundException {
		List<Bike> bikeList = new ArrayList<Bike>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYBrandname);) {

			ps.setString(1, brandname);
			System.out.println("Getting bikes with brandname: " + brandname);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					String name = rt.getString("modelname");
					String brandName = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					Double price = rt.getDouble("modelprice");
					int modelId = rt.getInt("modelId");
					Bike bike = new Bike(name, modelId, price, brandName, brandId);
					bikeList.add(bike);
					System.out.println(bike.toString());
				}
			}
			return bikeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bike> getByBrandnameAndModelname(String brandname, String modelname) throws BikeNotFoundException {
		List<Bike> bikeList = new ArrayList<Bike>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYBrandnameModelname);) {

			ps.setString(1, brandname);
			ps.setString(2, modelname);
		
			System.out.println("Getting bikes with modelname: " + modelname + " and with brandname of: " + brandname);
			
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					String name = rt.getString("modelname");
					String brandName = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					Double price = rt.getDouble("modelprice");
					int modelId = rt.getInt("modelId");
					Bike bike = new Bike(name, modelId, price, brandName, brandId);
					bikeList.add(bike);
					System.out.println(bike.toString());
				}
			}
			return bikeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bike> getByBrandnameAndModelprice(String brandname, double modelprice) throws BikeNotFoundException {
		List<Bike> bikeList = new ArrayList<Bike>();

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYBrandnameModelprice);) {

			ps.setString(1, brandname);
			ps.setDouble(2, modelprice);
			System.out
					.println("Getting bikes with brandnames: " + brandname + " and with modelprices of: " + modelprice);
			try (ResultSet rt = ps.executeQuery()) {
				while (rt.next()) {
					String name = rt.getString("modelname");
					String brandName = rt.getString("brandname");
					int brandId = rt.getInt("brandId");
					Double price = rt.getDouble("modelprice");
					int modelId = rt.getInt("modelId");
					Bike bike = new Bike(name, modelId, price, brandName, brandId);
					bikeList.add(bike);

					System.out.println(bike.toString());
				}
			}
			return bikeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
