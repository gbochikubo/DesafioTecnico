package com.desafio.desafio.Persistence;

import org.springframework.data.repository.CrudRepository;

import com.desafio.desafio.model.Trailer;


public interface TrailerDAO extends CrudRepository<Trailer, Long>{
	Trailer findById(long id);
}
