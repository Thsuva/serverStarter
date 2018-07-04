package com.example.serverStarterLA.POJO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interfaccia relativa alla classe intervento
 *
 * @author Jacopo Favaro
 */
@Repository
public interface interventoRepository extends CrudRepository<Intervento,Long>{
	
		List <Intervento>findAll();
		List<Intervento>findById(long id);
		List<Intervento>findByImpiantoId(long id);
		List <Intervento>findByData(Date data);
		List <Intervento>findByTipo(String tipo);
		
		@Query(value="SELECT * FROM intervento WHERE data = :data AND impianto_id = :imp_id AND tipo = 'A CHIAMATA'",nativeQuery=true)
		ArrayList<Intervento> findAllValidByDataImpTipo(@Param("data") Date date,@Param("imp_id") long id);
		
		@Query(value="SELECT * FROM intervento WHERE data = :data AND impianto_id = :imp_id",nativeQuery=true)
		ArrayList<Intervento> findAllValidByDataImp(@Param("data") Date date,@Param("imp_id") long id);
		
		@Query(value="SELECT * FROM intervento WHERE data < :data AND closed = 0 "
				+ "AND NOT tipo = 'A CHIAMATA' ORDER BY data ASC,FIELD(tipo,'BIENNALE','SEMESTRALE','ORDINARIO')",nativeQuery=true)
		ArrayList<Intervento> findAllValid(@Param("data") Date date);
		
		@Query(value="SELECT * FROM intervento WHERE data < :data AND id = :intId",nativeQuery=true)
		ArrayList<Intervento> findIntInMese(@Param("data") Date date,@Param("intId") long id);
		
		@Query(value="SELECT * FROM intervento WHERE impianto_id = :id AND closed = 0 "
				+ "AND NOT tipo = 'A CHIAMATA' ORDER BY FIELD(tipo,'BIENNALE','SEMESTRALE','ORDINARIO')",nativeQuery=true)
		ArrayList<Intervento> findAllValidById(@Param("id") long id);
		
		@Query(value="SELECT * FROM intervento WHERE impianto_id = :impianto_id AND manutentore_id = :manutentore_id AND "
				+ "data >= :data_doc AND data < :data_doc_end AND tipo = :tipo_doc",nativeQuery=true)
		List<Intervento> findAllValidByParams(@Param("manutentore_id") long id_m,@Param("impianto_id") long id_i,@Param("data_doc") String data,@Param("data_doc_end") String dataEnd,@Param("tipo_doc") String tipo);

		@Query(value="SELECT * FROM intervento WHERE impianto_id = :impianto_id AND "
				+ "data >= :data_doc AND data < :data_doc_end AND tipo = :tipo_doc",nativeQuery=true)
		List<Intervento> findAllValidByParamsManNull(@Param("impianto_id") long id_i,@Param("data_doc") String data,@Param("data_doc_end") String dataEnd,@Param("tipo_doc") String tipo);

		@Query(value="SELECT * FROM intervento WHERE data < :dataEnd AND data >= :dataStart AND tipo = :tipo AND impianto_id = :imp_id",nativeQuery=true)
		ArrayList<Intervento> findTipoIntInMese(@Param("dataEnd") Date dataEnd,@Param("dataStart") Date dataStart,
				@Param("tipo") String tipo,@Param("imp_id") long id);
}