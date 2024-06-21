package br.com.tech4me.tech4japa.model;

import org.springframework.data.annotation.Id;

import br.com.tech4me.tech4japa.shared.ProdutoCompletoDTO;

public class Produto {
    @Id
    private String id;
    private String nome;
    private String restaurante;
    private String imagem;
    private String produto;
    private String descricao;

    public Produto(){}

    public Produto(String id, String nome, String restaurante, String imagem, String produto, String descricao) {
        this.id = id;
        this.nome = nome;
        this.restaurante = restaurante;
        this.imagem = imagem;
        this.produto = produto;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Produto from(ProdutoCompletoDTO dto){
        return new Produto(dto.id(), dto.nome(), dto.restaurante(), dto.imagem(), dto.produto(), dto.descricao());
    }
    
}