package br.com.groupfive.jobby.repository;

import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecrutamentoRepository extends JpaRepository<Cadastro, Integer> {
    long countByHabilidadesNotLikeIgnoreCase(String habilidades);
    long countByHabilidadesLikeIgnoreCase(String habilidades);
    List<Cadastro> findByHabilidadesNot(String habilidade);
    List<Cadastro> findByHabilidades(String habilidade);
    List<Cadastro> findByProfissao(Profissao profissao);

    @Query(value = "SELECT * FROM jobby.tb_cadastro c\n" +
            "WHERE c.id_cadastro IN (\n" +
            "\tSELECT ce.id_cadastro FROM jobby.tb_cadastro_experiencia AS ce\n" +
            "\t\tWHERE ce.data_contratacao between :initialDate AND :finalDate\n" +
            ")", nativeQuery = true)
    List<Cadastro> findByDataContratacaoBetween(
        @Param("initialDate") LocalDate intialDate,
        @Param("finalDate") LocalDate finalDate
    );
}
