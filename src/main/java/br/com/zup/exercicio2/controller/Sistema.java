package br.com.zup.exercicio2.controller;

import br.com.zup.exercicio2.controller.dtos.LeadDTO;
import br.com.zup.exercicio2.controller.dtos.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sistema {

    private List<LeadDTO> leadsDTOS = new ArrayList<>();


    public List<LeadDTO> mostrarLead() {
        return  leadsDTOS;
    }
    public void cadastrarLead(LeadDTO leadDTO) {
        leadsDTOS.add(leadDTO);
    }


}
