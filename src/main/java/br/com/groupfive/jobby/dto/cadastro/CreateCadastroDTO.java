package br.com.groupfive.jobby.dto.cadastro;

import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;

import java.time.LocalDate;
import java.util.List;

public record CreateCadastroDTO(
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
    List habilidades,
    Integer idProfissao,
    CreateEnderecoDTO endereco
) {}
