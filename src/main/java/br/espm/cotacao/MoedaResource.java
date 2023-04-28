package br.espm.cotacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoedaResource {

    @Autowired
    public MoedaService moedaService;

    @GetMapping("/moedas")
    public List<MoedaTO> getMoedas() {
        return moedaService.list();
    }

    @PostMapping("/moedas")
    public void postMoeda(@RequestBody MoedaTO in) {
        moedaService.create(in);
    }

    @DeleteMapping("/moedas/{id}")
    public void deleteMoeda(@PathVariable("id") String id) {
        moedaService.delete(id);
    }
    
}
