package br.com.groupfive.jobby.dto.experiencia;

import java.time.LocalDate;

public record CreateExperienciaDTO(
    Double salario,
    Boolean empregoAtual,
    LocalDate dataContratacao,
    LocalDate dataDesligamento,
    String regimeContratacao,
    String nomeEmpresa,
    Integer idCadastro,
    Integer idProfissao
)
{}
