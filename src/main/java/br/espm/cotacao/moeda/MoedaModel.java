package br.espm.cotacao.moeda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "moeda")
@NoArgsConstructor
@Getter
@Setter
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

    public MoedaModel(MoedaTO to) {
        this.id = to.id();
        this.nome = to.nome();
        this.simbolo = to.simbolo();
        this.sigla = to.sigla();
    }

    public MoedaTO to() {
        return new MoedaTO(
            id,
            nome,
            simbolo,
            sigla
        );
    }
    
}
