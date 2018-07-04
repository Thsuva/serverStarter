package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe manutentore
 *
 * @author Jacopo Favaro
 */
@Repository
public interface manutentoreRepository extends CrudRepository<Manutentore,Long>{
	
		List <Manutentore>findAll();
		List<Manutentore>findById(long id);
		List<Manutentore>findByMatricola(String matricola);
		List<Manutentore>findByCognome(String cognome);
		List<Manutentore>findByNome(String nome);
}