package br.com.tech4me.tech4japa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4japa.model.Produto;
import br.com.tech4me.tech4japa.repository.ProdutoRepository;
import br.com.tech4me.tech4japa.shared.ProdutoCompletoDTO;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repositorio;


    @Override
    public List<ProdutoCompletoDTO> obterTodosProdutos() {
        return repositorio.findAll()
                          .stream()
                          .map(p -> ProdutoCompletoDTO.from(p))
                          .toList();
    }

    @Override
    public Optional<ProdutoCompletoDTO> obterProdutoPorId(String id) {
        Optional<Produto> produto = repositorio.findById(id);
        return produto.isPresent() ? Optional.of(ProdutoCompletoDTO.from(produto.get())) : Optional.empty(); 
    }

    @Override
    public ProdutoCompletoDTO cadastrarProduto(ProdutoCompletoDTO dto) {
        return ProdutoCompletoDTO.from(repositorio.save(Produto.from(dto)));
    }

    @Override
    public Optional<ProdutoCompletoDTO> atualizarProdutoPorId(ProdutoCompletoDTO dto, String id) {
        Optional<Produto> produto = repositorio.findById(id);
        if (produto.isPresent()) {
            Produto produtoAtualizado = Produto.from(dto);
            produtoAtualizado.setId(id);
            repositorio.save(produtoAtualizado);
            return Optional.of(ProdutoCompletoDTO.from(produtoAtualizado));
        }

        return Optional.empty();
    }

    @Override
    public void deletarPorId(String id) {
        repositorio.deleteById(id);
    }
    
}
