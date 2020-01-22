package com.desafio.desafio.Persistence;

import com.desafio.desafio.model.Detalhe;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DetalheDAO extends CrudRepository<Detalhe, Long> {
	
	Detalhe findById(long id);
	
	@Query(value = "from Detalhe umDetalhe where umDetalhe.dataInicial BETWEEN :dataInicial AND :dataFinal")
    List<Detalhe> findByDate(@Param("dataInicial") Date dataInicial, @Param("dataFinal")Date dataFinal);

	@Query(value = "from Detalhe umDetalhe where umDetalhe.dataInicial BETWEEN :dataInicial AND :dataFinal AND umDetalhe.estabelecimento = :estabelecimento" )
    List<Detalhe> findByDateAndEstabelecimento(@Param("dataInicial") Date dataInicial, @Param("dataFinal")Date dataFinal, @Param("estabelecimento") int estabelecimento);
	
	List<Detalhe> findByEstabelecimento(int estabelecimento);
	

}
