package br.espm.cotacao.moeda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    public List<MoedaTO> list() {
        List<MoedaTO> moedas = new ArrayList<>();
        moedaRepository.findAll().forEach(m -> 
            moedas.add(new MoedaTO(m.getId(), m.getNome(), m.getSimbolo(), m.getSigla())));
        return moedas;
    }

    public MoedaTO find(String id) {
        return moedaRepository.findById(id)
            .map(m -> new MoedaTO(m.getId(), m.getNome(), m.getSimbolo(), m.getSigla()))
            .orElse(null);
    }

    public MoedaTO create(MoedaTO moeda) {
        return moedaRepository.save(new MoedaModel(moeda)).to();
    }

    public void delete(String id) {
        moedaRepository.deleteById(id);
    }

    public MoedaTO findBySigla(String sigla) {
        return moedaRepository.findBySigla(sigla)
            .map(m -> new MoedaTO(m.getId(), m.getNome(), m.getSimbolo(), m.getSigla()))
            .orElse(null);
    }
    
}
