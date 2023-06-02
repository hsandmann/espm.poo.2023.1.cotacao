package br.espm.cotacao.moeda;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MoedaRepository extends CrudRepository<MoedaModel, String> {

    @Query("SELECT m from MoedaModel m where m.sigla = :s")
    Optional<MoedaModel> findBySigla(@Param("s") String sigla);
    
}
