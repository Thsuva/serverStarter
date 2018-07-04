package com.example.serverStarterLA.POJO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe note
 *
 * @author Jacopo Favaro
 */
@Repository
public interface noteRepository extends CrudRepository<Note,Long>{
	
		List <Note>findAll();
		List<Note>findByInterventoId(long id);

}