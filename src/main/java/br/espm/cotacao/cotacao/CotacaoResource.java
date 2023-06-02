package br.espm.cotacao.cotacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.espm.cotacao.moeda.MoedaService;
import br.espm.cotacao.moeda.MoedaTO;

@RestController
@RequestMapping("/cotacao")
public class CotacaoResource {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private MoedaService moedaService;

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping("/{sigla}")
    public List<CotacaoTO> listBySigla(@PathVariable("sigla") String sigla, @RequestParam("ini") String ini, @RequestParam("end") String end) {
        try {
            final Date dtini = ini == null ? new Date() : sdf.parse(ini);
            final Date dtend = end == null ? new Date() : sdf.parse(end);
            MoedaTO moeda = moedaService.findBySigla(sigla);
            if (moeda == null) {
                throw new RuntimeException("Moeda nao existe");
            }
            return cotacaoService.listByMoeda(moeda, dtini, dtend);
        } catch(ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{sigla}")
    public CotacaoTO insertCotacao(@PathVariable("sigla") String sigla, @RequestBody CotacaoTO to) {
        MoedaTO moeda = moedaService.findBySigla(sigla);
        if (moeda == null) {
            throw new RuntimeException("Moeda nao existe");
        }
        return cotacaoService.create(new CotacaoTO(
            null,
            moeda,
            to.data() == null ? new Date() : to.data(),
            to.valor()
        ));
    }

    @DeleteMapping("/{sigla}/{id}")
    public void deleteCotacao(@PathVariable("sigla") String sigla, @PathVariable("id") String id) {
        MoedaTO moeda = moedaService.findBySigla(sigla);
        if (moeda == null) {
            throw new RuntimeException("Moeda nao existe");
        }
        cotacaoService.delete(id);
    }

    
}
