package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe supervisore
 *
 * @author Jacopo Favaro
 */
@Repository
public interface supervisoreRepository extends CrudRepository<Supervisore,Long>{
	
		List <Supervisore>findAll();
		
		List<Supervisore>findByMatricola(String matricola);

}