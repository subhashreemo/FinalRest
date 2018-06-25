package com.split.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.ReadOnly;

@Entity
@ReadOnly
@Table(schema = "\"_SYS_BIC\"", name ="\"tgbl.data.transaction.views/CV_TGBL_BUYING_CENTER_SPLIT\"")
//@NamedQuery(name = BuyingCenterEntity.FIND_ALL, query = "select s from BuyingCenterEntity s")
@NamedQueries({
@NamedQuery(name= BuyingCenterEntity.findByBoid,query="SELECT s FROM BuyingCenterEntity s WHERE s.BO_ID =:BO_ID and s.REGION =:REGION and s.CLUSTER =:CLUSTER"),
@NamedQuery(name= BuyingCenterEntity.findByidregion,query="SELECT s FROM BuyingCenterEntity s WHERE s.BO_ID =:BO_ID and s.REGION =:REGION")
})
public class BuyingCenterEntity{
	public static final String FIND_ALL = "BuyingCenterEntity.findAll";
	public static final String findByBoid = "BuyingCenterEntity.findByBoid";
	public static final String findByidregion = "BuyingCenterEntity.findByidregion";
	
	@Column(name = "BO_ID")
    private Integer BO_ID;
	
	@Column(name = "WEEK_YEAR")
	private String WEEK_YEAR;//
	@Id
	@Column(name = "REGION")
	private String REGION;//REGION
	@Id
	@Column(name = "BUYING_CENTER")
	private String BUYING_CENTER;//Center
	
	@Id
	@Column(name = "CLUSTER")
    private String CLUSTER;
	
	@Id
	@Column(name = "COMPONENT")
	private String COMPONENT;//COMPONENT
	
	@Column(name = "W1_PERCENT")
	private Double W1_PERCENT;//W1_PERCENT
	
	@Column(name = "W1_QUANTITY")
	private Double W1_QUANTITY;//W1_Quantity
	
	@Column(name = "W2_QUANTITY")
	private Double W2_QUANTITY;//W2_Quantity
	
	@Column(name = "W2_PERCENT")
	private Double W2_PERCENT;//W2_PERCENT
	
	@Column(name = "W3_QUANTITY")
	private Double W3_QUANTITY;//W3_Quantity
	
	@Column(name = "W3_PERCENT")
	private Double W3_PERCENT;//W3_PERCENT	
	
	
	@Column(name = "W4_PERCENT")
	private Double W4_PERCENT;//W4_PERCENT
	
	@Column(name = "W4_QUANTITY")
	private Double W4_QUANTITY;//W4_Quantity
	
	
	@Column(name = "TOTAL")
	private Integer TOTAL;//Total

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

	

	public Double getW2_PERCENT() {
		return W2_PERCENT;
	}

	public void setW2_PERCENT(Double w2_PERCENT) {
		W2_PERCENT = w2_PERCENT;
	}

	

	public Double getW3_PERCENT() {
		return W3_PERCENT;
	}

	public void setW3_PERCENT(Double w3_PERCENT) {
		W3_PERCENT = w3_PERCENT;
	}

	public Double getW4_PERCENT() {
		return W4_PERCENT;
	}

	public void setW4_PERCENT(Double w4_PERCENT) {
		W4_PERCENT = w4_PERCENT;
	}

	

	public Double getW1_QUANTITY() {
		return W1_QUANTITY;
	}

	public void setW1_QUANTITY(Double w1_QUANTITY) {
		W1_QUANTITY = w1_QUANTITY;
	}

	public Double getW2_QUANTITY() {
		return W2_QUANTITY;
	}

	public void setW2_QUANTITY(Double w2_QUANTITY) {
		W2_QUANTITY = w2_QUANTITY;
	}

	public Double getW3_QUANTITY() {
		return W3_QUANTITY;
	}

	public void setW3_QUANTITY(Double w3_QUANTITY) {
		W3_QUANTITY = w3_QUANTITY;
	}

	public Double getW4_QUANTITY() {
		return W4_QUANTITY;
	}

	public void setW4_QUANTITY(Double w4_QUANTITY) {
		W4_QUANTITY = w4_QUANTITY;
	}

	public void setW1_PERCENT(Double w1_PERCENT) {
		W1_PERCENT = w1_PERCENT;
	}
	

	public String getBUYING_CENTER() {
		return BUYING_CENTER;
	}

	public void setBUYING_CENTER(String bUYING_CENTER) {
		BUYING_CENTER = bUYING_CENTER;
	}

	public Integer getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(Integer tOTAL) {
		TOTAL = tOTAL;
	}

	@Override
	public String toString() {
		return "BuyingOrderSplit [BO_ID=" + BO_ID + ", CLUSTER=" + CLUSTER + ", COMPONENT=" + COMPONENT + ", REGION="
				+ REGION + ", W1_PERCENT=" + W1_PERCENT + ", W1_Quantity=" + W1_QUANTITY + ", W2_PERCENT=" + W2_PERCENT
				+ ", W2_Quantity=" + W2_QUANTITY + ", W3_PERCENT=" + W3_PERCENT + ", W3_Quantity=" + W3_QUANTITY
				+ ", W4_PERCENT=" + W4_PERCENT + ", W4_Quantity=" + W4_QUANTITY + "]";
	}
	
	

}
