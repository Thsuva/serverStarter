package com.example.serverStarterLA.POJO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe impianto
 *
 * @author Jacopo Favaro
 */
@Repository
public interface impiantoRepository extends CrudRepository<Impianto,Long>{
	
		List <Impianto>findAll();
		List<Impianto>findById(long id);
		List <Impianto>findByNumeroImpianto(String ni);
		List <Impianto>findByNumeroMatricola(String nm);
		List <Impianto>findByProvincia(String p);
		List <Impianto>findByCap(String cap);
		List <Impianto>findByVia(String via);
		List <Impianto>findByPortone(String portone);
		
		@Query(value="SELECT * FROM impianto WHERE warning >= :warning",nativeQuery=true)
		ArrayList<Impianto> findAllValidByWarning(@Param("warning") int warning);

}