package com.split.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.split.entity.BuyingCenterEntity;


@Repository
public interface BuyingOrderSplitRepository extends CrudRepository<BuyingCenterEntity, Long>{
	List<BuyingCenterEntity> findByBoid(@Param("BO_ID") Integer bo_id,@Param("REGION") String region,@Param("CLUSTER") String cluster);
	//findByidregion
	List<BuyingCenterEntity> findByidregion(@Param("BO_ID") Integer bo_id,@Param("REGION") String region);
	}

	
