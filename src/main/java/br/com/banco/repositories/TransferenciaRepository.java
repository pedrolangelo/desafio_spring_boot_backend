package br.com.banco.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.models.TransferenciaModel;

public interface TransferenciaRepository extends CrudRepository<TransferenciaModel, Long>{
        List<TransferenciaModel> findByNome(String nomeResponsavel);

}
