package br.espm.cotacao.cotacao;

import java.util.Date;

import br.espm.cotacao.moeda.MoedaTO;

public record CotacaoTO(

    String id,
    MoedaTO moeda,
    Date data,
    Double valor

) {}
