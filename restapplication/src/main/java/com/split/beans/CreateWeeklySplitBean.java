package com.split.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateWeeklySplitBean {
	
	@JsonProperty("split")
	private List<WeeklySplitCreateBean> createBeans ;
	
	public CreateWeeklySplitBean() {

	}

	public List<WeeklySplitCreateBean> getCreateBeans() {
		return createBeans;
	}

	public void setCreateBeans(List<WeeklySplitCreateBean> createBeans) {
		this.createBeans = createBeans;
	}
	

}
