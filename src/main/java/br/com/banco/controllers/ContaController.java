package br.com.banco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.ContaModel;
import br.com.banco.service.ContaService;

@RestController
public class ContaController {

    @Autowired
    private ContaService cs;

    @GetMapping("/listar")
    public Iterable<ContaModel> listar(){
        return cs.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "API FUNCIONANDO";
    }
}
