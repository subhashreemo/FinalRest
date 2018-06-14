package com.split.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.split.entity.WeeklySplitCreateEntity;


@Repository
public interface CreateWeeklySplitRepository extends CrudRepository<WeeklySplitCreateEntity, Long>{

}
