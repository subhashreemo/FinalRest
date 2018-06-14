package com.split.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.swing.plaf.synth.Region;

import org.eclipse.persistence.annotations.ReadOnly;


@Entity
@ReadOnly
@Table(schema = "\"RB_SCH_TGBL\"", name = "\"tgbl.data.application::TGBL_DDL_APPLICATION.T_TG_BO_REGION\"")
@NamedQuery(name = RegionEntity.FIND_ALL, query = "select s from RegionEntity s")
public class RegionEntity {
	public static final String FIND_ALL = "RegionEntity.findAll";
	@Id
	@Column(name = "REGION")
	private String REGION;
	@Id
	@Column(name = "BUYING_CENTER")
	private String BUYING_CENTER;// COMPONENT
	public String getREGION() {
		return REGION;
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
