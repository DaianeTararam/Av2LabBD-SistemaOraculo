/**
 * Utilização do Princípio de Responsabilidade Única 
 * A classe Candidato tem a responsabilidade única de representar
 * a entidade "USUÁRIO" e mapear seus dados para a tabela correspondente no banco de dados. 
 *
*/ 
package com.daiane.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "login", length = 15, unique = true, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 15, nullable = false)
	private String senha;
}
