package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.profissao.CreateProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.ProfissaoDTO;

public interface IProfissaoService<T> {
    ProfissaoDTO findById(T id);
    ProfissaoDTO create(CreateProfissaoDTO createProfissaoDTO);
    boolean deleteById(T id);
}
