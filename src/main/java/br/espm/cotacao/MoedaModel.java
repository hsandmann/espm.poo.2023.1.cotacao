package br.espm.cotacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moeda")
public class MoedaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_moeda")
    private String id;

    @Column(name = "tx_nome")
    private String nome;

    @Column(name = "tx_sigla")
    private String sigla;

    @Column(name = "tx_simbolo")
    private String simbolo;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public MoedaModel() {

    }

    public MoedaModel(MoedaTO to) {
        this.id = to.id();
        this.nome = to.nome();
        this.simbolo = to.simbolo();
        this.sigla = to.sigla();
    }
    
}
