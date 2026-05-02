/**
 * Princípio da responsabilidade única: Esse controller serve para carregar os times dos arquivos TXT 
 * para o banco de dados e para abrir a página inicial do site.
 * Princípio da inversão de dependência: Eu uso os repositórios para salvar as coisas 
 * sem precisar saber os detalhes de como o SQL funciona.
 */
package com.daiane.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daiane.model.Curiosidade;
import com.daiane.model.Time;
import com.daiane.repository.ICuriosidadeRepository;
import com.daiane.repository.ITimeRepository;

import jakarta.annotation.PostConstruct;

@Controller
public class TimeController {
	
	@Autowired
	private ITimeRepository tRepo;
	
	@Autowired
	private ICuriosidadeRepository cRepo;
	
	// Assim que o projeto liga, ele vê se o banco tá vazio e já coloca os times e as curiosidades
	@PostConstruct
    public void iniciar() {
        try {
            if(tRepo.count() == 0) {
            	popularBanco();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	// Abre a página inicial (o index)
	@GetMapping("/")
	public String irParaHome() {
	    return "index";
	}
    
	// Esse aqui busca a lista de times e manda para a tela onde a pessoa escolhe o time dela
	@GetMapping("/escolha")
	public ModelAndView abrirCadastro(ModelMap model) {
	    List<Time> times = tRepo.findAll();
	    model.addAttribute("times", times);
	    return new ModelAndView("escolha", model); 
	}

    // Pega os nomes dos times que estão lá na pastinha de arquivos TXT
    private void popularBanco() throws IOException {
        File fileTimes = ResourceUtils.getFile("classpath:txts/times.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(fileTimes))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Time t = new Time();
                t.setNome(linha.trim());
                tRepo.save(t);
                lerCuriosidadesTXT(t);
            }
        }
    }
    
    // Pega as curiosidades de cada time que estão nos arquivos TXT individuais
    private void lerCuriosidadesTXT(Time time) throws IOException {
        File fileCur = ResourceUtils.getFile("classpath:txts/" + time.getNome().toLowerCase().replace(" ", "") + ".txt");
        try (BufferedReader br = new BufferedReader(new FileReader(fileCur))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    Curiosidade c = new Curiosidade();
                    c.setMensagem(linha); 
                    c.setTime(time);
                    cRepo.save(c);
                }
            }
        }
    }
    
    // Faz o sorteio da curiosidade chamando aquela Procedure que a gente criou no banco
    @GetMapping("/sortear")
    public ModelAndView sortear(@RequestParam("idTime") int idTime, ModelMap model) {
        try {
            // Chama a procedure do SQL e recebe o ID da curiosidade sorteada
            Integer idSorteado = cRepo.chamarProcedureSorteio(idTime);
            
            if (idSorteado != null) {
                // Busca a curiosidade completa para mostrar na tela
                Curiosidade c = cRepo.buscarPorIdNativo(idSorteado);
                
                if (c != null) {
                    model.addAttribute("curiosidade", c);
                    return new ModelAndView("curiosidade", model);
                }
            }
            
            throw new Exception("Erro no sorteio");

        } catch (Exception e) {
            e.printStackTrace();
            // Mensagem de erro
            Curiosidade erroCur = new Curiosidade();
            erroCur.setMensagem("O Oráculo está em silêncio... Tente novamente.");
            model.addAttribute("curiosidade", erroCur);
            return new ModelAndView("curiosidade", model);
        }
    }
}