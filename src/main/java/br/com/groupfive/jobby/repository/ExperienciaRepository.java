package br.com.groupfive.jobby.repository;

import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {

//    @Query("select c from Experiencia e where e.cadastro.idCadastro in ?1 and e.dataContratacao in ?2")

}
