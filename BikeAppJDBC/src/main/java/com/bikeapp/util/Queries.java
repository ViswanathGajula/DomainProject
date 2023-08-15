package com.bikeapp.util;

public class Queries {

	public static final String CREATEQUERY = "create table bike (modelname varchar(20), modelId integer primary key auto_increment,  modelprice double, brandname varchar(10), brandId int)";
	public static final String INSERTQUERY = "insert into bike(modelname, modelprice,brandname,brandId) values(?,?,?,?)";
	public static final String UPDATEQUERY = "update bike set modelprice=? where modelId=?";
	public static final String QUERYBYID = "select * from bike where modelId=?";
	public static final String GETALLQUERY = "select * from bike";
	public static final String DELETEBYID = "delete from bike where modelId=?";
	public static final String QUERYBYBrandname = "select * from bike where brandname=?";
	public static final String QUERYBYBrandnameModelname = "select * from bike where brandname=? and modelname=?";
	public static final String QUERYBYBrandnameModelprice = "select * from bike where brandname=? and modelprice<=?";

}
