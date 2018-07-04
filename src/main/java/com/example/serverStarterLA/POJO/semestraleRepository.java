package com.example.serverStarterLA.POJO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe semestrale
 *
 * @author Jacopo Favaro
 */
@Repository
public interface semestraleRepository extends CrudRepository<Semestrale,Long>{
	
		List <Semestrale>findAll();
		List<Semestrale>findByInterventoId(long id);

}