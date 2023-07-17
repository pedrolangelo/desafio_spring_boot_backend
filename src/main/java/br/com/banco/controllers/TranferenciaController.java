package br.com.banco.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.ContaModel;
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

    @GetMapping("/transferencia/nome")
    public ResponseEntity<List<TransferenciaModel>> listarPorNome(@RequestParam("nome") String nomeConta) {
        return new ResponseEntity<List<TransferenciaModel>>(ts.findByNome(nomeConta), HttpStatus.OK);
    }

    @GetMapping("/transferencias/data")
    public ResponseEntity<Iterable<TransferenciaModel>> buscarTransferenciasPorData(
        @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
        @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        Iterable<TransferenciaModel> transferencias = ts.listarTransferenciasPorData(dataInicial, dataFinal);
        return ResponseEntity.ok(transferencias);
    }
}
