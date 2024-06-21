package br.com.tech4me.tech4japa.shared;

import br.com.tech4me.tech4japa.model.Produto;

public record ProdutoDTO(String id,
                        String nome,
                        String restaurante,
                        String produto) {

    public static ProdutoDTO from(Produto produto){
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getRestaurante(), produto.getProduto());
    }
    
}
