package com.dhana.sprinboot.dao;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.dhana.sprinboot.model.model;

@Repository
public interface Contactdao extends CrudRepository<model,Integer> {
}

