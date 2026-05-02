/**
 * Utilização do Princípio de Responsabilidade Única 
 * A classe Candidato tem a responsabilidade única de representar
 * a entidade "Curiosidade" e mapear seus dados para a tabela correspondente no banco de dados. 
 *
*/ 
package com.daiane.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curiosidade")
public class Curiosidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "mensagem", length = 255, nullable = false) // Aumentei o length para caber curiosidades maiores
    private String mensagem;
    
    @ManyToOne
    @JoinColumn(name = "id_time", nullable = false)
    private Time time;
}