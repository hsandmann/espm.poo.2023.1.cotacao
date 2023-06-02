package br.espm.cotacao.cotacao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.espm.cotacao.moeda.MoedaTO;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    public CotacaoTO create(CotacaoTO cotacao) {
        return cotacaoRepository.save(new CotacaoModel(cotacao)).to();
    }

    public void delete(String id) {
        cotacaoRepository.deleteById(id);
    }

    public List<CotacaoTO> listByMoeda(MoedaTO moeda, Date ini, Date end) {
        return cotacaoRepository.findByMoedaAndStart(moeda.id(), ini, end)
            .stream()
            .map(CotacaoModel::to)
            .collect(Collectors.toList());
    }

}
