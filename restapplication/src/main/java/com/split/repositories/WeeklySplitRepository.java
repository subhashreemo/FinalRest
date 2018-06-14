package com.split.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.split.entity.WeeklySplitEntity;

@Repository
public interface WeeklySplitRepository extends CrudRepository<WeeklySplitEntity, Long>{
	
	List<WeeklySplitEntity> findByBoid(@Param("BO_ID") Integer bo_id,@Param("REGION") String region,@Param("CLUSTER") String cluster);
}
