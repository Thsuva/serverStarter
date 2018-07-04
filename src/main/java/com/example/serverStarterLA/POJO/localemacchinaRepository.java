package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe localemacchina
 *
 * @author Jacopo Favaro
 */
@Repository
public interface localemacchinaRepository extends CrudRepository<LocaleMacchina,Long>{
	
		List <LocaleMacchina>findAll();
		List<LocaleMacchina>findByImpiantoId(long id);
}