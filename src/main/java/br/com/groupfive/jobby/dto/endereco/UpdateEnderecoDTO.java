package br.com.groupfive.jobby.dto.endereco;

public record UpdateEnderecoDTO(
    Long cep,
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    Integer idCidade
) {}
