package br.com.banco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.models.ContaModel;

@Repository
public interface ContaRepository extends CrudRepository<ContaModel, Long>{
    
}
