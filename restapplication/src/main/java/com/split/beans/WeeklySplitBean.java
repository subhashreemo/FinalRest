package com.split.beans;

import java.util.Optional;

import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.split.entity.WeeklySplitEntity;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeeklySplitBean {
	
	@JsonProperty("maximumWeek")
	private Integer MWEEK;
	//private String WEEK_YEAR;
	@JsonProperty("region")
	private String REGION;
	
	
	@JsonProperty("cluster")
	private String CLUSTER;
	//Optional<String> CLUSTER;
	
	/*@JsonProperty("quantity")
	private double TQUANTITY;*/
	
	/*@JsonProperty("centers")
	private List<CentersBean> center;*/
	
	@JsonProperty("component")
	private String COMPONENT;
	
	@JsonProperty("id")
	private Integer BO_ID;
		
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
	
	@JsonProperty("Total")
	private Integer TOTAL;
	
	public WeeklySplitBean() {
	}
	
	// constructor for setting bean- WeeklySplitBean	
	public WeeklySplitBean(WeeklySplitEntity entity){
		this.BO_ID = entity.getBO_ID();
		this.MWEEK=4;//hardcoded for temporarly as no column in database
		/*this.MWEEK = entity.getMWEEK();
		System.out.println("entity.getMWEEK() is "+entity.getMWEEK());*/
		//this.WEEK_YEAR = entity.getWEEK_YEAR();
		this.CLUSTER= entity.getCLUSTER();//cluster.isPresent()?cluster.get():"cluster"
		//this.CLUSTER=entity.getCLUSTER().isPresent()?CLUSTER.toString():"cluster";
		System.out.println("CLUSTER" +entity.getCLUSTER());
		this.COMPONENT = entity.getCOMPONENT();
		this.REGION = entity.getREGION();
		this.TOTAL=entity.getTOTAL();
		this.W1_PERCENT = entity.getW1_PERCENT();
		this.W1_QUANTITY = entity.getW1_QUANTITY();
		this.W2_PERCENT = entity.getW2_PERCENT();
		this.W2_QUANTITY = entity.getW2_QUANTITY();
		this.W3_PERCENT = entity.getW3_PERCENT();
		this.W3_QUANTITY = entity.getW3_QUANTITY();
		System.out.println("W3 Quantity " +entity.getW3_QUANTITY());
		
		if(entity.getW4_QUANTITY()!=null)
			{
			this.W4_QUANTITY = entity.getW4_QUANTITY();
			System.out.println("IF W4 Quantity " +entity.getW4_QUANTITY());
			}
		else
		{
			this.W4_QUANTITY=0.0;
			System.out.println("ELSE*********W4 Quantity " +entity.getW4_QUANTITY());
		}
		//this.W4_PERCENT = entity.getW4_PERCENT();
		if(entity.getW4_PERCENT()!=null)
		{
			this.W4_PERCENT = entity.getW4_PERCENT();
			System.out.println("IF W4 % is " +entity.getW4_PERCENT());
			}
		else
		{
			this.W4_PERCENT=0.0;
			System.out.println("ELSE*********W4 % is  " +entity.getW4_PERCENT());
		}
	}
	
	

	public Integer getMWEEK() {
		return MWEEK;
	}

	public void setMWEEK(Integer mWEEK) {
		MWEEK = mWEEK;
	}

	public Integer getBO_ID() {
		return BO_ID;
	}
	public void setBO_ID(Integer bO_ID) {
		BO_ID = bO_ID;
	}
	
	public String getCLUSTER() {
		return CLUSTER;
	}
	public void setCLUSTER(String cLUSTER) {
		CLUSTER = cLUSTER;
	}
	/*public Optional<String> getCLUSTER() {
		return CLUSTER;
	}

	public void setCLUSTER(Optional<String> cLUSTER) {
		CLUSTER = cLUSTER;
	}*/
	
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

	public double getW1_QUANTITY() {
		return W1_QUANTITY;
	}

	public void setW1_QUANTITY(double w1_QUANTITY) {
		W1_QUANTITY = w1_QUANTITY;
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

/*	public double getTQUANTITY() {
		return TQUANTITY;
	}

	public void setTQUANTITY(double tQUANTITY) {
		TQUANTITY = tQUANTITY;
	}*/

	public Integer getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(Integer tOTAL) {
		TOTAL = tOTAL;
	}
	

	
	
}