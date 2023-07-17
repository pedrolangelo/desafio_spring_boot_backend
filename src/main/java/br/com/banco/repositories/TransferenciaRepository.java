package br.com.banco.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.models.TransferenciaModel;

public interface TransferenciaRepository extends CrudRepository<TransferenciaModel, Long>{
    
}
