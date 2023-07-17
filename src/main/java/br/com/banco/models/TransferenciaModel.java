package br.com.banco.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class TransferenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data_transferencia;

    @Column(precision = 7, scale = 2)
    private float valor;    

    private String tipo;

    private String nome_operador_transacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContaModel conta;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData_transferencia() {
        return data_transferencia;
    }

    public void setData_transferencia(LocalDate data_transferencia) {
        this.data_transferencia = data_transferencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome_operador_transacao() {
        return nome_operador_transacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.nome_operador_transacao = nome_operador_transacao;
    }

    public ContaModel getConta() {
        return conta;
    }

    public void setConta(ContaModel conta) {
        this.conta = conta;
    }
}
