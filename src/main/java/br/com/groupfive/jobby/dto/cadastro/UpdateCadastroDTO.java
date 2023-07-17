package br.com.groupfive.jobby.dto.cadastro;

import java.time.LocalDate;

public record UpdateCadastroDTO(
    String nome,
    String cpf,
    String sexo,
    LocalDate dataNascimento,
    Long telefone,
    String email,
    Long numeroCelularProfissional,
    Boolean isWhatsProfissional,
    Long numeroCelularPessoal,
    Boolean isWhatsPessoal,
    Double pretensaoMin,
    Double pretensaoMax,
    Integer idProfissao,
    Integer idEndereco
)
{}
