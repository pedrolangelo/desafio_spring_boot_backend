package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.models.ContaModel;
import br.com.banco.repositories.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository cr;
    
    public Iterable<ContaModel> listar(){
        return cr.findAll();
    }
}
