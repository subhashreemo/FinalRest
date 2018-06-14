package com.split.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.split.entity.BOHeaderEntity;

@Repository
public interface BORepository extends CrudRepository<BOHeaderEntity, Long>{
	

}
