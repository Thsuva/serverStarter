package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe dpi
 *
 * @author Jacopo Favaro
 */
@Repository
public interface dpiRepository extends CrudRepository<DPI,Long>{
	
		List <DPI>findAll();
		List<DPI>findByImpiantoId(long id);
}