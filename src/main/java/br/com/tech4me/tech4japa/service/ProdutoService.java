package br.com.tech4me.tech4japa.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4japa.shared.ProdutoCompletoDTO;
import br.com.tech4me.tech4japa.shared.ProdutoDTO;

public interface ProdutoService {
    List<ProdutoDTO> obterTodosProdutos();
    Optional<ProdutoCompletoDTO> obterProdutoPorId(String id);
    ProdutoCompletoDTO cadastrarProduto(ProdutoCompletoDTO dto);
    Optional<ProdutoCompletoDTO> atualizarProdutoPorId(ProdutoCompletoDTO dto, String id);
    void deletarPorId(String id);  
}
