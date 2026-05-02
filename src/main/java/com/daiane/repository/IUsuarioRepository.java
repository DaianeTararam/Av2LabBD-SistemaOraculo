/**
 * Utilização do princípio de responsabilidade única, a interface
 * é responsável pela gestão do usuário.
 * 
 */
package com.daiane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daiane.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "EXEC sp_validar_login :usuario, :senha", nativeQuery = true)
    int validarLoginProcedure(@Param("usuario") String usuario, @Param("senha") String senha);
}