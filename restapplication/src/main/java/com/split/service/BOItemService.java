package com.split.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.beans.BOItemBean;
import com.split.entity.BOItemEntity;
import com.split.repositories.BOItemRepository;
@Service
@Transactional(value="transactionManager")
public class BOItemService {

	@Autowired
	BOItemRepository boitemRepository;
	//BOItemBean boitemBean;
	
	//get All BO Items
	
			public List<BOItemEntity> getAllBOItem(Integer id){
				/*BOItemBean boitemBean=new BOItemBean();
				boitemBean.setBO_ID(id);*/
				//Iterable<BOItemEntity> boItemEntities = boitemRepository.findAll();//
				System.out.println("******BOItemService bo id is "+id);
				Iterable<BOItemEntity> boItemEntities = boitemRepository.findByBoid(id);
				List<BOItemEntity> entities = new ArrayList<>();
				boItemEntities.forEach(entities::add);
				return entities;
			}
			
}
