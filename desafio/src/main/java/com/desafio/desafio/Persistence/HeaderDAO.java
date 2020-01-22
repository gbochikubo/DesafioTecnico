package com.desafio.desafio.Persistence;
import com.desafio.desafio.model.Header;

import org.springframework.data.repository.CrudRepository;

/** Classe HeaderDAO responsável pelo acesso das informações dos Headers no banco de dados **/

public interface HeaderDAO extends CrudRepository<Header, Long> {
	
	Header findById(long id);
	
}
