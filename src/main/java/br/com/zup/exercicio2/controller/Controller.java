package br.com.zup.exercicio2.controller;

import br.com.zup.exercicio2.controller.dtos.LeadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class Controller {

    @Autowired
    private Sistema servico;

    @GetMapping
    public List<LeadDTO> mostrarLeads(){
        return servico.mostrarLead();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarLead(@RequestBody LeadDTO leadDTO){
        servico.cadastrarLead(leadDTO);
    }

}
