package br.espm.cotacao.moeda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MoedaResource {

    @Autowired
    public MoedaService moedaService;

    @GetMapping("/moedas")
    public List<MoedaTO> getMoedas(@RequestParam(name = "nome", defaultValue = "") String nome) {
        return (nome.length() > 0)
            ? moedaService.list().stream().filter(moeda -> moeda.nome().toLowerCase().contains(nome.toLowerCase())).toList()
            : moedaService.list();
    }

    @GetMapping("/moedas/{id}")
    public MoedaTO getMoeda(@PathVariable("id") String id) {
        return moedaService.find(id);
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
