package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;

import java.time.LocalDate;
import java.util.List;

public interface IRecrutamentoService<T> {
    List<CadastroDTO> findByProfissao(String profissao);

    List<CadastroDTO> findByHabilidade(String habilidade);

    List<CadastroDTO> findByHabilidadeNot(String habilidade);

    List<CadastroDTO> findAll();

    Long countCadastroForHabilidade(String habilidade);

    Long countCadastroHaveNotHabilidade(String habilidade);

    List<CadastroDTO> findByDataContratacaoBetween(LocalDate intialDate, LocalDate finalDate);
}
