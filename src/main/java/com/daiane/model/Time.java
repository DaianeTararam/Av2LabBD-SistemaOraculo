/**
 * Utilização do Princípio de Responsabilidade Única 
 * A classe Candidato tem a responsabilidade única de representar
 * a entidade "Time" e mapear seus dados para a tabela correspondente no banco de dados. 
 *
*/ 
package com.daiane.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time")

public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nome", length = 30, unique = true, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "time", fetch = FetchType.LAZY)
    private List<Curiosidade> curiosidades;
}

