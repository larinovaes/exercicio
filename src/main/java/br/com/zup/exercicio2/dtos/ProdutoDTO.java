package br.com.zup.exercicio2.dtos;

import javax.validation.constraints.NotBlank;

public class ProdutoDTO {

    @NotBlank
    private String nomeDoProduto;
    private  double valor;

    public ProdutoDTO() {

    }

    public ProdutoDTO(String nomeDoProduto, double valor) {
        this.nomeDoProduto = nomeDoProduto;
        this.valor = valor;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
