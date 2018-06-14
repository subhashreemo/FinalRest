package com.split.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.split.entity.ClusterEntity;
import com.split.repositories.ClusterRepository;
@Service
@Transactional(value="transactionManager")

public class ClusterService {
	@Autowired
	ClusterRepository clusterrepo;
	// Get Cluster
			   public List<ClusterEntity> getCluster(){
				Iterable<ClusterEntity> boCluster = clusterrepo.findAll();
				List<ClusterEntity> entities = new ArrayList<>();
				boCluster.forEach(entities::add);
				return entities;
			}

}
