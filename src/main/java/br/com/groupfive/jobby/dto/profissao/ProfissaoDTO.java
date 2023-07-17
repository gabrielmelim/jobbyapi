package br.com.groupfive.jobby.dto.profissao;

import br.com.groupfive.jobby.model.Profissao;

public record ProfissaoDTO(
    Integer idProfissao,
    String nome
) {
  public static ProfissaoDTO fromModel(Profissao profissao) {
      return new ProfissaoDTO(
          profissao.getIdProfissao(),
          profissao.getNome()
      );
  }
}
