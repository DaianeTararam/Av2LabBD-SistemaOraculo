/**
 * Utilização do Princípio da Responsabilidade Única
 * A interface é responsável apenas pelas operações de persistência da entidade Time.
 */

package com.daiane.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daiane.model.Time;

@Repository
public interface ITimeRepository extends JpaRepository<Time, Integer>{
	//verifica se o time já existe
	Optional<Time> findByNome(String nome);
}
