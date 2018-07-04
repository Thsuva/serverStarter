package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe ordinario
 *
 * @author Jacopo Favaro
 */
@Repository
public interface ordinarioRepository extends CrudRepository<Ordinario,Long>{
	
		List <Ordinario>findAll();
		List<Ordinario>findByInterventoId(long id);

}