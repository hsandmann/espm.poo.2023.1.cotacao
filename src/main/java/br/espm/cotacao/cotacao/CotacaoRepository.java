package br.espm.cotacao.cotacao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {

    @Query("SELECT c from CotacaoModel c WHERE (c.idMoeda = :idMoeda AND c.data >= :start AND c.data <= :end)")
    List<CotacaoModel> findByMoedaAndStart(@Param("idMoeda") String idMoeda, @Param("start") Date start, @Param("end") Date end);
    
}
