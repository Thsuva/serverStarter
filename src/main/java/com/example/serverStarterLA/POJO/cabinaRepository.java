package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe cabina
 *
 * @author Jacopo Favaro
 */
@Repository
public interface cabinaRepository extends CrudRepository<Cabina,Long>{
	
		List <Cabina>findAll();
		List<Cabina>findByImpiantoId(long id);
}