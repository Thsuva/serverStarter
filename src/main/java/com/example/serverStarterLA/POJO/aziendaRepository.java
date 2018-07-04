package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe azienda
 *
 * @author Jacopo Favaro
 */
@Repository
public interface aziendaRepository extends CrudRepository<Azienda,Long>{
	
		List <Azienda>findAll();
		
		List<Azienda> findByNome(String nome);
}