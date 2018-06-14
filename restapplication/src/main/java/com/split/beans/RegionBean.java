package com.split.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.split.entity.RegionEntity;

public class RegionBean {
	@JsonProperty("region")
	private String REGION;
	@JsonProperty("buying_center")
	private String BUYING_CENTER;// 
	public String getREGION() {
		return REGION;
	}
	public RegionBean(RegionEntity entity) {
		this.REGION = entity.getREGION();
		this.BUYING_CENTER = entity.getBUYING_CENTER();

	}
	public void setREGION(String rEGION) {
		REGION = rEGION;
	}
	public String getBUYING_CENTER() {
		return BUYING_CENTER;
	}
	public void setBUYING_CENTER(String bUYING_CENTER) {
		BUYING_CENTER = bUYING_CENTER;
	}
	
}
