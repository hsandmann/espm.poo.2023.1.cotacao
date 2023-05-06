package br.espm.cotacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MoedaService {

    private static final Map<String, MoedaTO> moedas = new HashMap<>();

    static {
        String k = UUID.randomUUID().toString();
        moedas.put(k, new MoedaTO(k, "Dolar", "US$", "USD"));
        k = UUID.randomUUID().toString();
        moedas.put(k, new MoedaTO(k, "Euro", "€", "EUR"));
        k = UUID.randomUUID().toString();
        moedas.put(k, new MoedaTO(k, "Real", "R$", "BRL"));
    }

    public List<MoedaTO> list() {
        return new ArrayList<MoedaTO>(moedas.values());
    }

    public MoedaTO find(String id) {
        return moedas.get(id);
    }

    public void create(MoedaTO moeda) {
        moedas.put(moeda.id(), moeda);
    }

    public void delete(String id) {
        if (moedas.containsKey(id)) moedas.remove(id);
    }
    
}
