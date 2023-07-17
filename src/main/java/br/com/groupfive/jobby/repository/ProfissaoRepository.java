package br.com.groupfive.jobby.repository;

import br.com.groupfive.jobby.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {
    Profissao findByNome(String nome);
}
