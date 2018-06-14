package com.split.beans;

import com.split.entity.ClusterEntity;

public class ClusterBean {
	private String CLUSTER;
	private String COMPONENT;
	
	public ClusterBean(ClusterEntity entity){
		this.CLUSTER = entity.getCLUSTER();
		this.COMPONENT = entity.getCOMPONENT();
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
	@Override
	public String toString() {
		return "ClusterBean [CLUSTER=" + CLUSTER + ", COMPONENT=" + COMPONENT + "]";
	}

}
