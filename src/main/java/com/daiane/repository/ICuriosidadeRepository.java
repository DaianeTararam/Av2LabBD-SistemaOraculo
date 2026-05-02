/**
 * Princípio da Segregação de Interfaces: 
 * Esta interface é especializada apenas na gestão de dados de curiosidades. 
 */
package com.daiane.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.daiane.model.Curiosidade;

@Repository
public interface ICuriosidadeRepository extends JpaRepository<Curiosidade, Integer> {

    //JPQL
    @Query("SELECT c FROM Curiosidade c WHERE c.time.id = :timeId")
    List<Curiosidade> buscarPorTime(@Param("timeId") int timeId);

    // native query 
    @Query(value = "EXEC sp_sortear_curiosidade :id", nativeQuery = true)
    Integer chamarProcedureSorteio(@Param("id") int idTime);
    
    // método para buscar a entidade após o sorteio
    @Query(value = "SELECT * FROM curiosidade WHERE id = :id", nativeQuery = true)
    Curiosidade buscarPorIdNativo(@Param("id") int id);
}