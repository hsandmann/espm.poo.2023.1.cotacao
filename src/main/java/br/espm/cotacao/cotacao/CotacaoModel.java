package br.espm.cotacao.cotacao;

import java.util.Date;

import br.espm.cotacao.moeda.MoedaTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cotacao")
@NoArgsConstructor
@Getter
@Setter
public class CotacaoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cotacao")
    private String id;

    @Column(name = "id_moeda")
    private String idMoeda;

    @Column(name = "dt_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "nr_valor")
    private Double valor;

    public CotacaoModel(CotacaoTO to) {
        this.id = to.id();
        this.idMoeda = to.moeda().id();
        this.data = to.data();
        this.valor = to.valor();
    }

    public CotacaoTO to() {
        return new CotacaoTO(
            id,
            new MoedaTO(idMoeda, null, null, null),
            data,
            valor
        );
    }

}
