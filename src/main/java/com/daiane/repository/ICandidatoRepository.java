/**
 * Princípio da Segregação de Interfaces: A interface é específica para Candidatos.
 * Princípio da Inversão de Dependência: O sistema depende desta abstração.
 */
package com.daiane.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.daiane.model.Candidato;

@Repository
public interface ICandidatoRepository extends JpaRepository<Candidato, Integer> {

    //findBy
    List<Candidato> findByBairro(String bairro);

    //JPQL
    @Query("SELECT c FROM Candidato c WHERE c.cursoInteresse = :curso ORDER BY c.nomeCompleto")
    List<Candidato> buscarPorCurso(@Param("curso") String curso);

    //Native Query
    @Query(value = "SELECT TOP 10 * FROM candidato ORDER BY data_hora ASC", nativeQuery = true)
    List<Candidato> buscarTop();

    //Native Query
    @Query(value = "SELECT TOP 10 * FROM candidato ORDER BY data_hora DESC", nativeQuery = true)
    List<Candidato> buscarUnder();    

}