package com.example.fernando.inova.model;

/**
 * Created by fernando on 29/08/18.
 */

public class Cliente {

    private Long codigo;
    private String nome;
    private String situacao;
    private String endereco;

    public void setCodigo(Long codigo){
        this.codigo = codigo;
    }
    public Long getCodigo(){
        return codigo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setSituacao(String situacao){
        this.situacao = situacao;
    }
    public String getSituacao(){
        return situacao;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return endereco;
    }
}
