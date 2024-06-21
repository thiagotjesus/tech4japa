package br.com.tech4me.tech4japa.shared;

import br.com.tech4me.tech4japa.model.Produto;

public record ProdutoCompletoDTO(String id,
                                 String nome,
                                 String restaurante,
                                 String imagem,
                                 String produto,
                                 String descricao){

    public static ProdutoCompletoDTO from(Produto produto) {
        return new ProdutoCompletoDTO(produto.getId(), produto.getNome(), produto.getRestaurante(), produto.getImagem(), produto.getProduto(), produto.getDescricao());
    }
    
}
