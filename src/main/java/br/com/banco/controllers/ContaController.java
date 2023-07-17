package br.com.banco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

       @GetMapping("/contas/{id}")
    public ResponseEntity<ContaModel> listarContaPorId(@PathVariable Long id) {
        ContaModel conta = cs.listarId(id);
        if (conta != null) {
            return ResponseEntity.ok(conta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
