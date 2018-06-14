package com.split.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.split.entity.BuyingCenterEntity;

public class BuyingOrderSplitBean {
	
	@JsonProperty("id")
	private Integer BO_ID;
	
	private String CLUSTER;
	private String COMPONENT;
	private String REGION;
	
	@JsonProperty("Week1_Percent")
	private double W1_PERCENT;
	
	@JsonProperty("Week1_Quantity")
	private double W1_QUANTITY;
	
	@JsonProperty("Week2_Percent")
	private double W2_PERCENT;
	
	@JsonProperty("Week2_Quantity")
	private double W2_QUANTITY;
	
	@JsonProperty("Week3_Percent")
	private double W3_PERCENT;
	
	@JsonProperty("Week3_Quantity")
	private double W3_QUANTITY;
	
	@JsonProperty("Week4_Percent")
	private double W4_PERCENT;
	
	@JsonProperty("Week4_Quantity")
	private double W4_QUANTITY;
	
	@JsonProperty("buying_center")
	private String BUYING_CENTER;
	
	@JsonProperty("total")
	private Integer total;
	
	
	public BuyingOrderSplitBean(){
		
	}
	
	

	// constructor for setting bean BuyingOrderSplitBean
	public BuyingOrderSplitBean(BuyingCenterEntity entity){
		System.out.println("Quantity 1 "+entity.getW1_QUANTITY());
		System.out.println("Quantity 2 "+entity.getW2_QUANTITY());
		System.out.println("Quantity 3 "+entity.getW3_QUANTITY());
		System.out.println("Quantity 4 "+entity.getW4_QUANTITY());
		this.BO_ID = entity.getBO_ID();
		this.CLUSTER= entity.getCLUSTER();
		this.COMPONENT = entity.getCOMPONENT();
		this.REGION = entity.getREGION();
		this.W1_PERCENT = entity.getW1_PERCENT();
		this.W2_PERCENT = entity.getW2_PERCENT();
		this.W3_PERCENT = entity.getW3_PERCENT();
		this.W4_PERCENT = entity.getW4_PERCENT();
		this.W1_QUANTITY =entity.getW1_QUANTITY();
		this.W2_QUANTITY =entity.getW2_QUANTITY();
		this.W3_QUANTITY =entity.getW3_QUANTITY();
		this.W4_QUANTITY =entity.getW4_QUANTITY();
		this.BUYING_CENTER=entity.getBUYING_CENTER();
		this.total=entity.getTOTAL();
		
	}

	public Integer getBO_ID() {
		return BO_ID;
	}

	public void setBO_ID(Integer bO_ID) {
		BO_ID = bO_ID;
	}

	public double getW1_QUANTITY() {
		return W1_QUANTITY;
	}

	public void setW1_QUANTITY(double w1_QUANTITY) {
		W1_QUANTITY = w1_QUANTITY;
	}

	public String getCLUSTER() {
		return CLUSTER;
	}

	public void setCLUSTER(String cLUSTER) {
		CLUSTER = cLUSTER;
	}

	public String getCOMPONENT() {
		return COMPONENT;
	}

	public void setCOMPONENT(String cOMPONENT) {
		COMPONENT = cOMPONENT;
	}

	public String getREGION() {
		return REGION;
	}

	public void setREGION(String rEGION) {
		REGION = rEGION;
	}

	public double getW1_PERCENT() {
		return W1_PERCENT;
	}

	public void setW1_PERCENT(double w1_PERCENT) {
		W1_PERCENT = w1_PERCENT;
	}

	
	public double getW2_PERCENT() {
		return W2_PERCENT;
	}

	public void setW2_PERCENT(double w2_PERCENT) {
		W2_PERCENT = w2_PERCENT;
	}

	

	public double getW3_PERCENT() {
		return W3_PERCENT;
	}

	public void setW3_PERCENT(double w3_PERCENT) {
		W3_PERCENT = w3_PERCENT;
	}

	

	public double getW4_PERCENT() {
		return W4_PERCENT;
	}

	public void setW4_PERCENT(double w4_PERCENT) {
		W4_PERCENT = w4_PERCENT;
	}

	public double getW2_QUANTITY() {
		return W2_QUANTITY;
	}

	public void setW2_QUANTITY(double w2_QUANTITY) {
		W2_QUANTITY = w2_QUANTITY;
	}

	public double getW3_QUANTITY() {
		return W3_QUANTITY;
	}

	public void setW3_QUANTITY(double w3_QUANTITY) {
		W3_QUANTITY = w3_QUANTITY;
	}

	public double getW4_QUANTITY() {
		return W4_QUANTITY;
	}

	public void setW4_QUANTITY(double w4_QUANTITY) {
		W4_QUANTITY = w4_QUANTITY;
	}

	public String getBUYING_CENTER() {
		return BUYING_CENTER;
	}



	public void setBUYING_CENTER(String bUYING_CENTER) {
		BUYING_CENTER = bUYING_CENTER;
	}



	public Integer getTotal() {
		return total;
	}



	public void setTotal(Integer total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "BuyingOrderSplitBean [BO_ID=" + BO_ID + ", CLUSTER=" + CLUSTER + ", COMPONENT=" + COMPONENT
				+ ", REGION=" + REGION + ", W1_PERCENT=" + W1_PERCENT + ", W1_Quantity=" + W1_QUANTITY + ", W2_PERCENT="
				+ W2_PERCENT + ", W2_Quantity=" + W2_QUANTITY + ", W3_PERCENT=" + W3_PERCENT + ", W3_Quantity="
				+ W3_QUANTITY + ", W4_PERCENT=" + W4_PERCENT + ", W4_Quantity=" + W4_QUANTITY + "]";
	}

	
}
