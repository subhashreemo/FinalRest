package com.split.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.entity.BuyingCenterEntity;
import com.split.repositories.BuyingOrderSplitRepository;
import com.split.repositories.WeeklySplitRepository;

@Service
@Transactional(value="transactionManager")
public class BuyingOrderSplitService {
	@Autowired
	BuyingOrderSplitRepository buyingordersplitrepository;
	// Get BO Split    
	public List<BuyingCenterEntity> getBOSplit(Integer id,String region,String cluster){
		//Iterable<BuyingCenterEntity> boSplit = buyingordersplitrepository.findAll();
		Iterable<BuyingCenterEntity> boSplit = buyingordersplitrepository.findByBoid(id,region,cluster);
		List<BuyingCenterEntity> entities = new ArrayList<>();
		boSplit.forEach(entities::add);
		return entities;
	}
}
