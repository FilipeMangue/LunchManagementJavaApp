/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.atarzan.sgv.model;

/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda
 */
public class ModelProduct {
    protected String nome_Produto;
    protected double preco_Produto;
    private int quantidade;
    private String fornecedor;

    public ModelProduct(String nome_Produto, double preco_Produto, int quantidade, String fornecedor) {
        this.nome_Produto = nome_Produto;
        this.preco_Produto = preco_Produto;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    public double getPreco_Produto() {
        return preco_Produto;
    }

    public void setPreco_Produto(double preco_Produto) {
        this.preco_Produto = preco_Produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
