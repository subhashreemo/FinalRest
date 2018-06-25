package com.split.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//import org.eclipse.persistence.annotations.ReadOnly;

@Entity

@Table(schema = "\"RB_SCH_TGBL\"", name = "\"tgbl.data.application::TGBL_DDL_APPLICATION.T_TG_BO_ITEM\"")
//@NamedQueries({
//@NamedQuery(name = BOItemEntity.FIND_ALL, query = "select s from BOItemEntity s "),
@NamedQuery(name= BOItemEntity.findByBoid,query="SELECT s FROM BOItemEntity s WHERE s.BO_ID =:BO_ID")

//})

public class BOItemEntity {
	//public static final String FIND_ALL = "BOItemEntity.findAll";
	public static final String findByBoid = "BOItemEntity.findByBoid";
	
	
	//@Column(name = "BO_ID" , insertable=true, updatable=true, unique=true, nullable=false)
	@Column(name = "BO_ID")
	private Integer BO_ID;
	@Id
	@Column(name = "REGION")
	private String region;
	@Id
	@Column(name = "CLUSTER")
	private String cluster;//cluster
	@Id
	@Column(name = "COMPONENT")
	private String component;//component
	@Column(name = "QUANTITY")
	private Integer quantity;//quantity
	
	@ManyToOne()
    @JoinColumn(name="BO_ID", updatable = false, insertable = false)
    private BOHeaderEntity BOHeaderEntity;
    public BOHeaderEntity getBOHeaderEntity() {
           return BOHeaderEntity;

    }
	/*@ManyToOne()
	//@PrimaryKeyJoinColumn(name="BO_ID")
	@JoinColumn(name="BO_ID")
	private BOHeaderEntity boHeaderEntity;*/
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BOItemEntity() {
		
	}
	/*public BOHeaderEntity getBOHeaderEntity() {
		return boHeaderEntity;
	}*/
	

}
