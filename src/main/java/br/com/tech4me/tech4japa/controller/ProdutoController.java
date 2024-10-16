package br.com.tech4me.tech4japa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4japa.service.ProdutoService;
import br.com.tech4me.tech4japa.shared.ProdutoCompletoDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService servico;
    
    @GetMapping()
    public ResponseEntity<List<ProdutoCompletoDTO>> obterTodosProdutos() {
        return new ResponseEntity<>(servico.obterTodosProdutos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://tech4japa.fly.dev")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoCompletoDTO> obterProdutoPorId(@PathVariable String id) {
        Optional<ProdutoCompletoDTO> produto = servico.obterProdutoPorId(id);

        return produto.isPresent() ? new ResponseEntity<>(produto.get(), HttpStatus.ACCEPTED) 
                                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<ProdutoCompletoDTO> cadastrarProduto(@RequestBody ProdutoCompletoDTO dto) {
        return new ResponseEntity<>(servico.cadastrarProduto(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoCompletoDTO> atualizarProdutoPorId(@PathVariable String id, @RequestBody ProdutoCompletoDTO dto) {
        Optional<ProdutoCompletoDTO> produto = servico.atualizarProdutoPorId(dto, id);

        return produto.isPresent() ? new ResponseEntity<>(produto.get(), HttpStatus.ACCEPTED) 
                                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id){
        servico.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    
    
}
