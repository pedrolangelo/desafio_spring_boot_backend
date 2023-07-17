package br.com.banco.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.TransferenciaModel;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {
    
    @Autowired
    private TransferenciaRepository tr;
    
    public Iterable<TransferenciaModel> listarTransferencia(){
        return tr.findAll();
    }

    public TransferenciaModel listarTransferenciaId(Long id) {
        return tr.findById(id).orElse(null);
    }
    public List<TransferenciaModel> findByNome(String nomeConta) {
        return tr.findByNome(nomeConta);
    }

    public Iterable<TransferenciaModel> listarTransferenciasPorData(LocalDate dataInicial, LocalDate dataFinal) {
        return tr.findByDataBetween(dataInicial, dataFinal);
    }
}
