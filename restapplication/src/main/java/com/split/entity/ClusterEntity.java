package com.split.entity;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;

@Entity
@ReadOnly
@Table(schema = "\"RB_SCH_TGBL\"", name = "\"tgbl.data.application::TGBL_DDL_APPLICATION.T_TG_BO_CLUSTER\"")
@NamedQuery(name = ClusterEntity.FIND_ALL, query = "select s from ClusterEntity s")
public class ClusterEntity{
	public static final String FIND_ALL = "ClusterEntity.findAll";
	@Id
	@Column(name = "CLUSTER")
    private String CLUSTER;
	@Id
	@Column(name = "COMPONENT")
	private String COMPONENT;//COMPONENT
	
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
	

	
}