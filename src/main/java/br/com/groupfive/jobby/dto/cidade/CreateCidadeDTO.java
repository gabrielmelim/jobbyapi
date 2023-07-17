package br.com.groupfive.jobby.dto.cidade;

public record CreateCidadeDTO(
    String nome,
    String estado,
    String sigla
) {}
