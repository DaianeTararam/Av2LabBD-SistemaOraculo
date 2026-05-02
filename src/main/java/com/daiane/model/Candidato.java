/**
 * Utilização do Princípio de Responsabilidade Única 
 * A classe Candidato tem a responsabilidade única de representar
 * a entidade "CANDIDATO" e mapear seus dados para a tabela correspondente no banco de dados. 
 *
*/ 
package com.daiane.model;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome_completo", length = 50, nullable = false)
    private String nomeCompleto;
    
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    
    @Column(name = "telefone_celular", length = 11, nullable = false)
    private String telefoneCelular;
    
    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "curso_interesse", length = 50, nullable = false)
    private String cursoInteresse;
    
    // updatable e insertable como false porque a Trigger do SQL cuida disso
    @Column(name = "data_hora", updatable = false, insertable = false)
    private LocalDateTime dataHora;
    
    //código com @Formula 
    //@Formula("CONVERT(CHAR(10), data_hora, 103)")
    //private String dtHoraFormatada;
    
    @Transient
    private String dtHoraFormatada;

    // O Getter faz o trabalho de formatação para o JSP
    public String getDtHoraFormatada() {
        if (this.dataHora != null) {
            return this.dataHora.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        }
        return "";
    }
}