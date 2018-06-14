package com.split.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.split.entity.ClusterEntity;

@Repository
public interface ClusterRepository extends CrudRepository<ClusterEntity, Long>{
	

}
