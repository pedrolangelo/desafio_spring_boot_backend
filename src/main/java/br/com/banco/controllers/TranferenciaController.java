package br.com.banco.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.models.TransferenciaModel;
import br.com.banco.service.TransferenciaService;

@RestController
@CrossOrigin(origins = "*")
public class TranferenciaController {
    
    @Autowired
    private TransferenciaService ts;

    @GetMapping("/transferencias")
    public List<TransferenciaModel> pesquisarTransferencias(
        @RequestParam(value = "nome", required = false) String nomeOperador,
        @RequestParam(value = "dataInicial", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
        @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        if (nomeOperador == null && dataInicial == null && dataFinal == null) {
            return (List<TransferenciaModel>) ts.listarTransferencia(); // Método para retornar todos os TransferenciaModel
        }

        if (nomeOperador != null && dataInicial == null && dataFinal == null) {
            return (List<TransferenciaModel>) ts.findByNome(nomeOperador); // Método para retornar transfeerencias filtradas por nome
        }

        if (nomeOperador == null && dataInicial != null && dataFinal != null) {
            return (List<TransferenciaModel>) ts.listarTransferenciasPorData(dataInicial, dataFinal); // Método para retornar transfeerencias filtradas por nome
        }
        return ts.findByNomeAndDataBetween(nomeOperador, dataInicial, dataFinal);
    }
}
