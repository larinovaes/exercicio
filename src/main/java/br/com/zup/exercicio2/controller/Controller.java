package br.com.zup.exercicio2.controller;

import br.com.zup.exercicio2.dtos.LeadDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/leads")
public class Controller {
    @Autowired
    private ServicoLead servico;

    @GetMapping
    public List<LeadDTO> mostrarLeads(){
        return servico.mostrarLead();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarLead(@RequestBody @Valid LeadDTO leadDTO){
        try {
            servico.cadastrarLead(leadDTO);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{nomeDoLead}")
    public LeadDTO buscarLead(@PathVariable String nomeDoLead) {
        return servico.verSomenteOleadEscolhido(nomeDoLead);
    }
}
