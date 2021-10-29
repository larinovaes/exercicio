package br.com.zup.exercicio2.controller;

import br.com.zup.exercicio2.controller.dtos.LeadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sistema {

    private List<LeadDTO> leadsDTOS = new ArrayList<>();


    public List<LeadDTO> mostrarLead() {
        return leadsDTOS;
    }

    public void cadastrarLead(LeadDTO leadDTO) {
        for (LeadDTO referencia : leadsDTOS) {
            if (referencia.getEmailDoLead().equalsIgnoreCase(leadDTO.getEmailDoLead())) {
               throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
        leadsDTOS.add(leadDTO);
    }
}

