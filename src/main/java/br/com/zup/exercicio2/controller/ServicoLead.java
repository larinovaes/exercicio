package br.com.zup.exercicio2.controller;

import br.com.zup.exercicio2.dtos.LeadDTO;
import br.com.zup.exercicio2.dtos.ProdutoDTO;
import br.com.zup.exercicio2.exception.LeadEProdutoJaCadastradoException;
import br.com.zup.exercicio2.exception.LeadNãoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoLead {

    private List<LeadDTO> leadsDTOS = new ArrayList<>();


    public List<LeadDTO> mostrarLead() {
        return leadsDTOS;
    }

    public void cadastrarLead(LeadDTO leadDTO) {
        try {
            verificarLeadEProduto(leadDTO);
            LeadDTO leadDTODaLista = buscarLead(leadDTO.getEmailDoLead());
            atualizarListaDeProduto(leadDTO.getProdutoDTO(),leadDTODaLista);

        } catch (LeadEProdutoJaCadastradoException exception) {
            throw new RuntimeException(exception.getMessage());

        } catch (LeadNãoEncontradoException exception) {
            leadsDTOS.add(leadDTO);
        }
    }

    public void verificarLeadEProduto( LeadDTO leadDTO) {

            LeadDTO objetoDaLista = buscarLead(leadDTO.getEmailDoLead());
            for (ProdutoDTO produtoDTO: leadDTO.getProdutoDTO()){
                if (produtoEstaPresente(objetoDaLista.getProdutoDTO(), produtoDTO.getNomeDoProduto())) {
                    throw new LeadEProdutoJaCadastradoException("Lead e Produto já está cadastrado");
                }
            }
    }

    public boolean produtoEstaPresente(List<ProdutoDTO> listaDeInteresse, String nomeProduto) {
        for (ProdutoDTO produtoDTO : listaDeInteresse) {
            if (produtoDTO.getNomeDoProduto().equalsIgnoreCase(nomeProduto)) {
                return true;
            }
        }
        return false;
    }

    public LeadDTO buscarLead(String email) {
        for (LeadDTO referencia : leadsDTOS) {
            if (referencia.getEmailDoLead().equalsIgnoreCase(email)) {
                return referencia;
            }
        }
        throw new LeadNãoEncontradoException("Lead não encontrado");
    }


    public void atualizarListaDeProduto(List<ProdutoDTO> novosProdutos, LeadDTO leadDTO) {
        for (ProdutoDTO produtoDTO: novosProdutos) {
            leadDTO.getProdutoDTO().add(produtoDTO);
        }
    }

    public LeadDTO verSomenteOleadEscolhido(String nomeDoLead) {
        for (LeadDTO referencia : leadsDTOS) {
            if (referencia.getNomeDoLead().equalsIgnoreCase(nomeDoLead)) {
                return referencia;
            }
        }
        throw new LeadNãoEncontradoException("Lead não encontrado");
    }
}



