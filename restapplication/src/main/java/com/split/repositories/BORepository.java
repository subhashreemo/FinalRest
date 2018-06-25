package com.split.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.split.entity.BOHeaderEntity;


@Repository
public interface BORepository extends CrudRepository<BOHeaderEntity, Long>{
	
	List<BOHeaderEntity> findByBoid(@Param("BO_ID") Integer bo_id);
}
