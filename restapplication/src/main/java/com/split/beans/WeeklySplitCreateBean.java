package com.split.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.split.entity.WeeklySplitCreateEntity;;

public class WeeklySplitCreateBean {
	@JsonProperty("id")
	private Integer BO_ID;

	@JsonProperty("region")
	private String REGION;

	@JsonProperty("cluster")
	private String CLUSTER;// cluster

	@JsonProperty("component")
	private String COMPONENT;

	@JsonProperty("week")
	private String WEEK;

	@JsonProperty("percent")
	private double PERCENT;

	@JsonProperty("quantity")
	private double Qunatity;

	@JsonProperty("Week1_Percent")
	private Double Week1_Percent;

	@JsonProperty("Week1_Quantity")
	private Double Week1_Quantity;

	@JsonProperty("Week2_Percent")
	private Double Week2_Percent;

	@JsonProperty("Week2_Quantity")
	private Double Week2_Quantity;

	@JsonProperty("Week3_Percent")
	private Double Week3_Percent;

	@JsonProperty("Week3_Quantity")
	private Double Week3_Quantity;

	@JsonProperty("Week4_Percent")
	private Double Week4_Percent;

	@JsonProperty("Week4_Quantity")
	private Double Week4_Quantity;

	public WeeklySplitCreateBean() {

	}

	public Integer getBO_ID() {
		return BO_ID;

	}

	public void setBO_ID(Integer bO_ID) {
		BO_ID = bO_ID;

	}

	public String getREGION() {

		return REGION;

	}

	public void setREGION(String rEGION) {

		REGION = rEGION;

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

	public String getWEEK() {

		return WEEK;

	}

	public void setWEEK(String wEEK) {

		WEEK = wEEK;

	}

	public double getPERCENT() {

		return PERCENT;

	}

	public void setPERCENT(double pERCENT) {

		PERCENT = pERCENT;

	}

	public double getQunatity() {

		return Qunatity;

	}

	public void setQunatity(double qunatity) {

		Qunatity = qunatity;

	}

	public Double getWeek1_Percent() {

		return Week1_Percent;

	}

	public void setWeek1_Percent(Double week1_Percent) {

		Week1_Percent = week1_Percent;

	}

	public Double getWeek1_Quantity() {

		return Week1_Quantity;

	}

	public void setWeek1_Quantity(Double week1_Quantity) {

		Week1_Quantity = week1_Quantity;

	}

	public Double getWeek2_Percent() {

		return Week2_Percent;

	}

	public void setWeek2_Percent(Double week2_Percent) {

		Week2_Percent = week2_Percent;

	}

	public Double getWeek2_Quantity() {

		return Week2_Quantity;

	}

	public void setWeek2_Quantity(Double week2_Quantity) {

		Week2_Quantity = week2_Quantity;

	}

	public Double getWeek3_Percent() {

		return Week3_Percent;

	}

	public void setWeek3_Percent(Double week3_Percent) {

		Week3_Percent = week3_Percent;

	}

	public Double getWeek3_Quantity() {

		return Week3_Quantity;

	}

	public void setWeek3_Quantity(Double week3_Quantity) {

		Week3_Quantity = week3_Quantity;

	}

	public Double getWeek4_Percent() {

		return Week4_Percent;

	}

	public void setWeek4_Percent(Double week4_Percent) {

		Week4_Percent = week4_Percent;

	}

	public Double getWeek4_Quantity() {

		return Week4_Quantity;

	}

	public void setWeek4_Quantity(Double week4_Quantity) {

		Week4_Quantity = week4_Quantity;

	}

}
