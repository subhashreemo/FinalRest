package com.split.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.entity.BuyingCenterEntity;
import com.split.repositories.BuyingOrderSplitRepository;


@Service
@Transactional(value="transactionManager")
public class BuyingOrderSplitService {
	@Autowired
	BuyingOrderSplitRepository buyingordersplitrepository;
	// Get BO Split    
	public List<BuyingCenterEntity> getBOSplit(Integer id,String region,String cluster){
		//Iterable<BuyingCenterEntity> boSplit = buyingordersplitrepository.findAll();
		System.out.println("CLUSTER "+cluster);
		List<BuyingCenterEntity> entities = new ArrayList<>();
		if(cluster.equalsIgnoreCase("cluster")||cluster.equalsIgnoreCase(null)){
			System.out.println("******BuyingOrderSplitService else condition******" );
			Iterable<BuyingCenterEntity> boSplit = buyingordersplitrepository.findByidregion(id,region);
			boSplit.forEach(entities::add);
			
		}
		else{
			System.out.println("******IF condition******" );
			Iterable<BuyingCenterEntity> boSplit = buyingordersplitrepository.findByBoid(id,region,cluster);
			//List<BuyingCenterEntity> entities = new ArrayList<>();
			boSplit.forEach(entities::add);
		}
		return entities;
		
	}
}
