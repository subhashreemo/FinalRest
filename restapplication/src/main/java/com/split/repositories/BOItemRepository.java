package com.split.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.split.entity.BOItemEntity;

public interface BOItemRepository extends CrudRepository<BOItemEntity, Long>{
	
	List<BOItemEntity> findByBoid(@Param("BO_ID") Integer bo_id);
}
