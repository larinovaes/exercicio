package br.com.zup.exercicio2.controller.dtos;

import java.util.List;

public class LeadDTO {

    private String nomeDoLead;
    private String emailDoLead;
    private int telefone;
    private List<ProdutoDTO> produtoDTO;

    public LeadDTO() {

    }

    public LeadDTO(String nomeDoLead, String emailDoLead, int telefone, List<ProdutoDTO> produtoDTO) {
        this.nomeDoLead = nomeDoLead;
        this.emailDoLead = emailDoLead;
        this.telefone = telefone;
        this.produtoDTO = produtoDTO;
    }

    public String getNomeDoLead() {
        return nomeDoLead;
    }

    public void setNomeDoLead(String nomeDoLead) {
        this.nomeDoLead = nomeDoLead;
    }

    public String getEmailDoLead() {
        return emailDoLead;
    }

    public void setEmailDoLead(String emailDoLead) {
        this.emailDoLead = emailDoLead;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public List<ProdutoDTO> getProdutoDTO() {
        return produtoDTO;
    }

    public void setProdutoDTO(List<ProdutoDTO> produtoDTO) {
        this.produtoDTO = produtoDTO;
    }
}
