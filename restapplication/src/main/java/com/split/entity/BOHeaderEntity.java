package com.split.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.eclipse.persistence.annotations.ReadOnly;

@Entity

@Table(schema = "\"RB_SCH_TGBL\"", name = "\"tgbl.data.application::TGBL_DDL_APPLICATION.T_TG_BO_HEADER\"")
@NamedQueries({
@NamedQuery(name = BOHeaderEntity.FIND_ALL, query = "select s from BOHeaderEntity s"),
@NamedQuery(name= BOHeaderEntity.findByBoid,query="SELECT s FROM BOHeaderEntity s WHERE s.BO_ID =:BO_ID")
})
public class BOHeaderEntity{
	public static final String FIND_ALL = "BOHeaderEntity.findAll";
	public static final String findByBoid = "BOHeaderEntity.findByBoid";
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "BO_ID", insertable=true, updatable=true, unique=true, nullable=false)
    private Integer BO_ID;
	@Column(name = "BO_FROM")
	private Date BO_FROM;//validFrom
	public Date getBO_FROM() {
		return BO_FROM;
	}
	public void setBO_FROM(Date bO_FROM) {
		BO_FROM = bO_FROM;
	}
	@Column(name = "BO_TO")
	private Date BO_TO;//validTo
	
	@OneToMany(mappedBy = "BOHeaderEntity")
    @JoinColumn(name = "BO_ID", referencedColumnName = "BO_ID")
    private List<BOItemEntity> BOItemEntity;   

    public List<BOItemEntity> getBOItemEntity() {
           return BOItemEntity;

    }
	
	/*@OneToMany(mappedBy = "boHeaderEntity")
	@JoinColumn(name = "BO_ID", referencedColumnName = "BO_ID")*/
	/*private List<BOItemEntity> boItem;
	
	public List<BOItemEntity> getBoItem() {
		return boItem;
	}
	public void setBoItem(List<BOItemEntity> boItem) {
		this.boItem = boItem;
	}*/
	public Integer getBO_ID() {
		return BO_ID;
	}
	public void setBO_ID(Integer bO_ID) {
		BO_ID = bO_ID;
	}
	
	public Date getBO_TO() {
		return BO_TO;
	}
	public void setBO_TO(Date bO_TO) {
		BO_TO = bO_TO;
	}
}