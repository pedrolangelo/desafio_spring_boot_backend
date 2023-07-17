package br.com.banco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.TransferenciaModel;
import br.com.banco.service.TransferenciaService;

@RestController
public class TranferenciaController {
    
    @Autowired
    private TransferenciaService ts;

    @GetMapping("/transferencias")
    public Iterable<TransferenciaModel> listarTransferencia(){
        return ts.listarTransferencia();
    }

    @GetMapping("/transferencia/{id}")
    public ResponseEntity<TransferenciaModel> listarTransferenciaId(@PathVariable Long id) {
        TransferenciaModel transferencia = ts.listarTransferenciaId(id);
        if (transferencia != null) {
            return ResponseEntity.ok(transferencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
