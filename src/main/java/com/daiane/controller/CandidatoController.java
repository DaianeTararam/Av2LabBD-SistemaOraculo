/**
 * Princípio da responsabilidade única: Essa classe cuida apenas da navegação do candidato.
 * Princípio da inversão de dependência: O controle aqui usa as interfaces dos repositórios 
 * para mexer no banco, em vez de criar tudo do zero.
 */
package com.daiane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daiane.model.Candidato;
import com.daiane.model.Curiosidade;
import com.daiane.repository.ICandidatoRepository;
import com.daiane.repository.ICuriosidadeRepository;

@Controller
public class CandidatoController {

    @Autowired
    private ICandidatoRepository canRepo;

    @Autowired
    private ICuriosidadeRepository curRepo;

    //O sistema mostra a curiosidade do time que a pessoa escolheu
    @GetMapping("/exibirCuriosidade") 
    public ModelAndView mostrarCuriosidade(@RequestParam("timeId") int timeId, ModelMap model) {
        
        // chama a procedure lá do SQL para sortear uma curiosidade
        Integer idSorteado = curRepo.chamarProcedureSorteio(timeId);
        
        // pega essa curiosidade sorteada e prepara para mostrar na tela
        Curiosidade curiosidade = curRepo.buscarPorIdNativo(idSorteado);
        
        model.addAttribute("curiosidade", curiosidade);
        return new ModelAndView("curiosidade", model);
    }

    // tela de cadastro
    @GetMapping("/cadastro")
    public ModelAndView telaCadastro(ModelMap model) {
        // Cria um candidato vazio só para preencher o formulário
        model.addAttribute("candidato", new Candidato());
        return new ModelAndView("cadastro", model);
    }

    // salvamento
    @PostMapping("/salvarCandidato")
    public ModelAndView salvarCandidato(@ModelAttribute("candidato") Candidato candidato) {
        // Salvar as informações do candidato no banco
        canRepo.save(candidato);

        return new ModelAndView("sucesso");
    }
}