package com.split.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.entity.BOHeaderEntity;
import com.split.entity.RegionEntity;
import com.split.repositories.BORepository;
import com.split.repositories.RegionRepository;

@Service
@Transactional(value="transactionManager")

public class RegionService {
		
		
	//To Read Regions
	@Autowired
	RegionRepository regionRepository;
	public List<RegionEntity> getAllRegions(){
		Iterable<RegionEntity> region = regionRepository.findAll();
		List<RegionEntity> entities = new ArrayList<>();
		region.forEach(entities::add);
		return entities;
	}
	

}
