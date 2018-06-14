package com.split.beans;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.split.entity.BOHeaderEntity;



@JsonInclude(JsonInclude.Include.NON_NULL)

//@JsonPropertyOrder({"BO_ID","vaildFrom","validTo"})
public class BOHeaderBean {
	
	@JsonProperty("id")
	private Integer BO_ID;//BO_ID

	@JsonProperty("validFrom")
	//@JsonDeserialize(using = DateHandler.class)
	//@JsonFormat(pattern="dd-MM-yyyy")
	private Date validFrom;// validFrom
	//@JsonFormat(pattern="dd-MM-yyyy")
	@JsonProperty("validTo")
	private Date validTo;// validTo
	
	@JsonProperty("orders")
	private List<BOItemBean> iteamBeans ;
	
	public Integer getBO_ID() {
		return BO_ID;
	}

	public void setBO_ID(Integer bo_ID) {
		BO_ID = bo_ID;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date bo_FROM) {
		validFrom = bo_FROM;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date bo_TO) {
		validTo = bo_TO;
	}

	

	public List<BOItemBean> getIteamBeans() {
		return iteamBeans;
	}

	public void setIteamBeans(List<BOItemBean> iteamBeans) {
		this.iteamBeans = iteamBeans;
	}

	public BOHeaderBean() {
	}
	
	
	
	public BOHeaderBean(BOHeaderEntity entity) {
		this.BO_ID = entity.getBO_ID();
		this.validFrom = entity.getBO_FROM();
		this.validTo = entity.getBO_TO();
		
	}


	
	/*@Override
	public String toString() {
		return "BOBean [BO_ID=" + BO_ID + ", vaildFrom=" + BO_FROM + ", validTo=" + BO_TO + "]";
	}*/
}
