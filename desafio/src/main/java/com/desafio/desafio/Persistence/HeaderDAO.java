package com.desafio.desafio.Persistence;
import com.desafio.desafio.model.Header;

import org.springframework.data.repository.CrudRepository;

public interface HeaderDAO extends CrudRepository<Header, Long> {
	Header findById(long id);
}
