package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe vanocorsa
 *
 * @author Jacopo Favaro
 */
@Repository
public interface vanocorsaRepository extends CrudRepository<VanoCorsa,Long>{
	
		List <VanoCorsa>findAll();
		List<VanoCorsa>findByImpiantoId(long id);
}