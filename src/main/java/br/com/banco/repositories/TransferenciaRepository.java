package br.com.banco.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.models.TransferenciaModel;

public interface TransferenciaRepository extends CrudRepository<TransferenciaModel, Long>{
        List<TransferenciaModel> findByNome(String nomeOperador);

        Iterable<TransferenciaModel> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
        
        List<TransferenciaModel> findByNomeAndDataBetween(String nomeOperador, LocalDate dataInicial, LocalDate dataFinal);

}
