package com.bikeapp.model;

public class Bike {
	private String modelname;
	private int modelId;
	private double modelprice;
	private String brandname;
	private int brandId;
	public Bike() {
		super();
	}
	public Bike(String modelname, int modelId, double modelprice, String brandname, int brandId) {
		super();
		this.modelname = modelname;
		this.modelId = modelId;
		this.modelprice = modelprice;
		this.brandname = brandname;
		this.brandId = brandId;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public double getModelprice() {
		return modelprice;
	}
	public void setModelprice(double modelprice) {
		this.modelprice = modelprice;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	@Override
	public String toString() {
		return "Bike [modelname=" + modelname + ", modelId=" + modelId + ", modelprice=" + modelprice + ", brandname="
				+ brandname + ", brandId=" + brandId + "]";
	}
	

}
