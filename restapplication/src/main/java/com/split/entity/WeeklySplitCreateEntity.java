package com.split.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(schema = "\"RB_SCH_TGBL\"", name = "\"tgbl.data.application::TGBL_DDL_APPLICATION.T_TG_WEEK_SPLIT\"")
@NamedQuery(name= WeeklySplitCreateEntity.FIND_ALL,query="select s from WeeklySplitCreateEntity s")


public class WeeklySplitCreateEntity {
	public static final String FIND_ALL = "WeeklySplitCreateEntity.findAll";
	@Column(name = "BO_ID" , insertable=true, updatable=true, unique=true, nullable=false)
	private Integer BO_ID;
	@Id
	@Column(name = "REGION")
	private String region;
	@Id
	@Column(name = "CLUSTER")
	private String cluster;//cluster
	@Id
	@Column(name = "COMPONENT")
	private String component;
	
	@Column(name = "WEEK")
	public String WEEK;
	
	@Column(name = "PERCENT")
	public double PERCENT;
	
	@Column(name = "QUANTITY")
	public double Qunatity;
	
	public Integer getBO_ID() {
		return BO_ID;
	}
	public void setBO_ID(Integer bO_ID) {
		BO_ID = bO_ID;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCluster() {
		return cluster;
	}
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
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
	
	
}
