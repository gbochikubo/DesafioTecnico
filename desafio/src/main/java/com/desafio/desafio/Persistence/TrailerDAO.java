package com.desafio.desafio.Persistence;

import org.springframework.data.repository.CrudRepository;

import com.desafio.desafio.model.Trailer;

/** Classe TrailerDAO responsável pelo acesso das informações dos Trailers no banco de dados **/

public interface TrailerDAO extends CrudRepository<Trailer, Long>{
	
	Trailer findById(long id);
	
}
