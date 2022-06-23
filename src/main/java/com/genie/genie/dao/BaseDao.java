package com.genie.genie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseDao<T> extends CrudRepository<T, Long> {
	
}