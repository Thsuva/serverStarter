package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe biennale
 *
 * @author Jacopo Favaro
 */
@Repository
public interface biennaleRepository extends CrudRepository<Biennale,Long>{
	
		List <Biennale>findAll();
		List<Biennale>findByInterventoId(long id);
}