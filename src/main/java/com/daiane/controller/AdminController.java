/**
 * Princípio da Responsabilidade Única: Esta classe gerencia exclusivamente 
 * as funções administrativas e os relatórios de candidatos.
 */
package com.daiane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daiane.repository.ICandidatoRepository;
import com.daiane.repository.IUsuarioRepository;

@Controller
public class AdminController {

    @Autowired
    private ICandidatoRepository cRepo; 

    @Autowired
    private IUsuarioRepository uRepo;

    @GetMapping("/login")
    public String telaLogin() {
        return "login"; //
    }

    // Processa o Login usando a Procedure do SQL Server
    @PostMapping("/validarLogin")
    public String realizarLogin(@RequestParam("usuario") String usuario, 
                                @RequestParam("senha") String senha, Model model) {
        
        // Chamando a procedure sp_validar_login que criei no banco
    	int resultado = uRepo.validarLoginProcedure(usuario, senha);

    	if (resultado == 1) { // 1 significa que a procedure retornou TRUE
    	    return "redirect:/admin/painel"; 
    	} else {
    	    model.addAttribute("erro", "Usuário ou senha inválidos!");
    	    return "login";
    	}
    }

    // Abre a tela principal do administrador e mostra a lista de todo mundo
    @GetMapping("/admin/painel")
    public String painelAdmin(Model model) {
        model.addAttribute("candidatos", cRepo.findAll());
        return "consultaCandidatos";
    }

    // Filtra os candidatos pelo curso (JPQL)
    @GetMapping("/admin/filtroCurso")
    public String filtrarCurso(@RequestParam("curso") String curso, Model model) {
        model.addAttribute("candidatos", cRepo.buscarPorCurso(curso));
        return "consultaCandidatos";
    }

    // Mostra os 10 primeiros candidatos (Native Query)
    @GetMapping("/admin/primeiros")
    public String verTop10(Model model) {
        model.addAttribute("candidatos", cRepo.buscarTop());
        return "consultaCandidatos";
    }

    // Mostra os 10 últimos (Native Query)
    @GetMapping("/admin/ultimos")
    public String verUltimos10(Model model) {
        model.addAttribute("candidatos", cRepo.buscarUnder());
        return "consultaCandidatos";
    }
    
    // Busca por bairro (findBy - Spring Data)
    @GetMapping("/admin/filtroBairro")
    public String filtrarBairro(@RequestParam("bairro") String bairro, Model model) {
    	String bairroUpper = bairro.toUpperCase();
        model.addAttribute("candidatos", cRepo.findByBairro(bairroUpper));
        return "consultaCandidatos";
    }
}
