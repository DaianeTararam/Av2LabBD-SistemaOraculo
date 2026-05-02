/**
 * Princípio da Responsabilidade Única (SRP):
 * Esta classe tem como única responsabilidade gerenciar o fluxo de navegação 
 * relacionado às curiosidades do sistema "Oráculo". 
 */
package com.daiane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daiane.model.Curiosidade;
import com.daiane.model.Time;
import com.daiane.repository.ICuriosidadeRepository;
import com.daiane.repository.ITimeRepository;

@Controller
public class CuriosidadeController {

    @Autowired
    private ICuriosidadeRepository curRepo;
    @Autowired
    private ITimeRepository tRepo;

    @GetMapping("/oraculo")
    public String mostrarCuriosidade(@RequestParam("timeId") int timeId, Model model) {

        Integer idSorteado = curRepo.chamarProcedureSorteio(timeId);
        
        if (idSorteado != null) {
            Curiosidade sorteada = curRepo.buscarPorIdNativo(idSorteado);
            model.addAttribute("curiosidade", sorteada);
        } else {
            Curiosidade erro = new Curiosidade();
            erro.setMensagem("O Oráculo não conseguiu sortear uma curiosidade agora.");
            model.addAttribute("curiosidade", erro);
        }
        
        return "curiosidade"; 
    }
    
    @GetMapping("/admin/cadastraTipo")
    public String telaCadastraCuriosidade(Model model) {
        model.addAttribute("curiosidade", new Curiosidade());
        model.addAttribute("times", tRepo.findAll());
        model.addAttribute("mensagens", curRepo.findAll()); 
        return "cadastraTipo";
    }


    @PostMapping("/admin/salvarMensagem")
    public String salvarCuriosidade(@RequestParam("texto") String texto, @RequestParam("idTime") Integer idTime) {
        Curiosidade c = new Curiosidade();
        c.setMensagem(texto); 
        Time t = tRepo.findById(idTime).orElse(null);
        c.setTime(t);
        curRepo.save(c);
        return "redirect:/admin/cadastraTipo";
    }
}