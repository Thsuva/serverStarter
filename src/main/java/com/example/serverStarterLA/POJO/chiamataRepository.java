package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe chiamata
 *
 * @author Jacopo Favaro
 */
@Repository
public interface chiamataRepository extends CrudRepository<Chiamata,Long>{
	
		List <Chiamata>findAll();
		List<Chiamata>findByInterventoId(long id);
}