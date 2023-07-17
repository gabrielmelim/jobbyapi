package br.com.groupfive.jobby.dto.cidade;

import br.com.groupfive.jobby.model.Cidade;

public record CidadeDTO(
    Integer idCidade,
    String nome,
    String estado,
    String sigla
) {
    public static CidadeDTO fromModel(Cidade cidade) {
        return new CidadeDTO(
            cidade.getIdCidade(),
            cidade.getNome(),
            cidade.getEstado(),
            cidade.getSigla()
        );
    }
}
