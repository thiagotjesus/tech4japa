package br.com.tech4me.tech4japa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4japa.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{
    
}
