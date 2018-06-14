package com.split.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.beans.BOHeaderBean;
import com.split.entity.BOHeaderEntity;
import com.split.entity.BOItemEntity;
import com.split.entity.BuyingCenterEntity;
import com.split.entity.ClusterEntity;
import com.split.entity.WeeklySplitEntity;
import com.split.repositories.BOItemRepository;
import com.split.repositories.BORepository;
import com.split.repositories.BuyingOrderSplitRepository;
import com.split.repositories.ClusterRepository;
import com.split.repositories.WeeklySplitRepository;

@Service
@Transactional(value="transactionManager")
public class BOService {
	
	@Autowired
	BORepository boRepository;
	ClusterRepository clusterrepo;
	//BOHeaderEntity heardentity;
	//List<BOItemEntity> itemList;
	//BOItemRepository boitemRepo;
	// Create new entity
	// Create new repository 
	// Create new resource/ bean
	// Add this as attribue - List<bean> in existing BOBean
	// Create new method in controller for create
	// Controller --> Service --> Save via repository
	
	public List<BOHeaderEntity> getAllBO(){
		Iterable<BOHeaderEntity> boEntities = boRepository.findAll();
		List<BOHeaderEntity> entities = new ArrayList<>();
		boEntities.forEach(entities::add);
		return entities;
	}



	@Autowired
	BOItemRepository boitemRepo;
	public void saveBean(BOHeaderBean bean) {
		
		BOHeaderEntity heardentity = new BOHeaderEntity ();
		List<BOItemEntity> itemList = new ArrayList<BOItemEntity>();
		
		System.out.println("in BOService");
		System.out.println("in BOService" +bean.getBO_ID()+"-----------"+bean.getValidFrom()+"!!!!!!!!!!!!!" +bean.getValidTo());
		
		try{
			heardentity.setBO_ID(bean.getBO_ID());
			heardentity.setBO_FROM(bean.getValidFrom());
			//heardentity.setBO_FROM(convertDate(bean.getValidFrom()));
			heardentity.setBO_TO(bean.getValidTo());
			System.out.println("Bean date "+bean.getValidFrom() +"--To date --" +bean.getValidTo());
			System.out.println("BOID entity is" +heardentity.getBO_ID()+"--------------"+heardentity.getBO_FROM()+">>>>>>>>>>>>>>>"+heardentity.getBO_TO().toGMTString());
			bean.getIteamBeans().forEach(b -> {
			BOItemEntity itemEntity = new BOItemEntity();
			itemEntity.setCluster(b.getCluster());
			itemEntity.setQuantity(b.getQuantity());
			itemEntity.setComponent(b.getComponent());
			itemEntity.setRegion(b.getRegion());
			itemEntity.setBO_ID(bean.getBO_ID());
			
			System.out.println("ITEM details" +b.getCluster()+ "------" +b.getComponent());
			//heardentity.getBoItem().add(itemEntity);
			itemList.add(itemEntity);
			//heardentity.setBoItem(itemList);
			
			//System.out.println("heardentity size" +heardentity.getBoItem().size() +"first Item entity BOID is " +heardentity.getBoItem().get(0).getBO_ID());
			
		});
				boRepository.save(heardentity);
				boitemRepo.save(itemList);
				System.out.println("Bo Header and Item Table Created successfully");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Date convertDate(Date d)throws ParseException{
		//convertDate();
		Date convertDate=new Date();
		try{
			System.out.println("calling convertDate " +d);
			
			/*Date toDate=new Date();*/
			DateFormat formater = new SimpleDateFormat("dd.mm.yyyy");
		
			convertDate = formater.parse(formater.format(d));
			//toDate = format.parse(format.format(bean.getValidTo()));
			System.out.println("After convert -----" +convertDate);
			
		
		}
		catch(ParseException pe)
		{
			pe.printStackTrace();
		}
		return convertDate;
	}
}
