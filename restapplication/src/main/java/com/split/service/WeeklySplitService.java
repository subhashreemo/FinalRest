package com.split.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.beans.CreateWeeklySplitBean;
import com.split.beans.WeeklySplitCreateBean;
import com.split.entity.WeeklySplitCreateEntity;
import com.split.entity.WeeklySplitEntity;
import com.split.repositories.CreateWeeklySplitRepository;
import com.split.repositories.WeeklySplitRepository;
@Service
@Transactional(value="transactionManager")
public class WeeklySplitService {
	@Autowired
	WeeklySplitRepository weeklysplitrepository;
	// Get Week Split
	public List<WeeklySplitEntity> getWeekSplit(Integer id,String region,String cluster){
		System.out.println("getWeeklySplit bo id is "+id);
		System.out.println("region is "+region);
		System.out.println("cluster is "+cluster);
		//Iterable<WeeklySplitEntity> boWeekSplit = weeklysplitrepository.findAll();
		Iterable<WeeklySplitEntity> boWeekSplit = weeklysplitrepository.findByBoid(id,region,cluster);
		List<WeeklySplitEntity> entities = new ArrayList<>();
		boWeekSplit.forEach(entities::add);
		return entities;
	}

	@Autowired
	
	CreateWeeklySplitRepository createwsplitrepo;
	//public void saveBean(WeeklySplitCreateBean bean) {
	public void saveBean(CreateWeeklySplitBean cbean) {
		
		List<WeeklySplitCreateEntity> lw1entity = new ArrayList<WeeklySplitCreateEntity>();
		List<WeeklySplitCreateEntity> lw2entity = new ArrayList<WeeklySplitCreateEntity>();
		List<WeeklySplitCreateEntity> lw3entity = new ArrayList<WeeklySplitCreateEntity>();
		List<WeeklySplitCreateEntity> lw4entity = new ArrayList<WeeklySplitCreateEntity>();
		
		
		System.out.println("WeeklySplit SERVICE");//getCreateBeans
		cbean.getCreateBeans().forEach(b -> {
			WeeklySplitCreateEntity wentity=new WeeklySplitCreateEntity();
			System.out.println("INSIDE FOR loop---");
			//WeeklySplitCreateBean bean= new WeeklySplitCreateBean();
			System.out.println("from BO Id "+b.getBO_ID());
			System.out.println("from create week "+b.getWeek1_Percent());
		if(b.getWeek1_Percent()!=0){
			System.out.println("week1");
			wentity.setBO_ID(b.getBO_ID());
			wentity.setCluster(b.getCLUSTER());
			wentity.setComponent(b.getCOMPONENT());
			wentity.setRegion(b.getREGION());
			wentity.setWEEK("W1");
			wentity.setPERCENT(b.getWeek1_Percent());
			wentity.setQunatity(b.getWeek1_Quantity());
			
			/*------*/
			wentity.setWEEK("W2");
			wentity.setPERCENT(b.getWeek2_Percent());
			wentity.setQunatity(b.getWeek2_Quantity());
			
			wentity.setWEEK("W3");
			wentity.setPERCENT(b.getWeek3_Percent());
			wentity.setQunatity(b.getWeek3_Quantity());
			//lw3entity.add(wentity);
			
			wentity.setWEEK("W4");
			wentity.setPERCENT(b.getWeek4_Percent());
			wentity.setQunatity(b.getWeek4_Quantity());
			/*------*/
			
			
		
			lw1entity.add(wentity);
			createwsplitrepo.save(lw1entity);
			System.out.println("SAVE W1");
		}
	/*	if(b.getWeek2_Percent()!=0){
			System.out.println("week2");
			wentity.setBO_ID(b.getBO_ID());
			wentity.setCluster(b.getCLUSTER());
			wentity.setComponent(b.getCOMPONENT());
			wentity.setRegion(b.getREGION());
			wentity.setWEEK("W2");
			wentity.setPERCENT(b.getWeek2_Percent());
			wentity.setQunatity(b.getWeek2_Quantity());
			lw2entity.add(wentity);
			createwsplitrepo.save(lw2entity);
			System.out.println("SAVE W2");
		}
		if(b.getWeek3_Percent()!=0){
			System.out.println("week3");
			wentity.setBO_ID(b.getBO_ID());
			wentity.setCluster(b.getCLUSTER());
			wentity.setComponent(b.getCOMPONENT());
			wentity.setRegion(b.getREGION());
			wentity.setWEEK("W3");
			wentity.setPERCENT(b.getWeek3_Percent());
			wentity.setQunatity(b.getWeek3_Quantity());
			lw3entity.add(wentity);
			createwsplitrepo.save(lw3entity);
			System.out.println("SAVE W3");
		}
		if(b.getWeek4_Percent()!=0){
			System.out.println("week4");
			wentity.setBO_ID(b.getBO_ID());
			wentity.setCluster(b.getCLUSTER());
			wentity.setComponent(b.getCOMPONENT());
			wentity.setRegion(b.getREGION());
			wentity.setWEEK("W4");
			wentity.setPERCENT(b.getWeek4_Percent());
			wentity.setQunatity(b.getWeek4_Quantity());
			lw4entity.add(wentity);
			createwsplitrepo.save(lw4entity);
			System.out.println("SAVE W4");
		}*/
		System.out.println("Before Adding "+b.getBO_ID());
		//lwentity.add(wentity);
		//createwsplitrepo.save(lwentity);
		//createwsplitrepo.save(lwentity);
		System.out.println("Update Sucessfully for "+b.getBO_ID());
		});
	/*	if(bean.getWeek2_Percent()!=0){
			wentity.setBO_ID(bean.getBO_ID());
			wentity.setCluster(bean.getCLUSTER());
			wentity.setComponent(bean.getCOMPONENT());
			wentity.setRegion(bean.getREGION());
			wentity.setWEEK("W2");
			wentity.setPERCENT(bean.getWeek2_Percent());
			wentity.setQunatity(bean.getWeek2_Quantity());
		}*/
		
		
		System.out.println("***************Update Sucessfully for all list************");
	}
	
}
