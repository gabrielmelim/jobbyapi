package br.com.groupfive.jobby.repository;

import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

}
