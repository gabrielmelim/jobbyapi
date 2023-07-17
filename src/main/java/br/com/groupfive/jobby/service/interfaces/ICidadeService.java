package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.cidade.CreateCidadeDTO;
import br.com.groupfive.jobby.dto.cidade.UpdateCidadeDTO;

public interface ICidadeService<T> {
    CidadeDTO findById(T id);
    CidadeDTO create(CreateCidadeDTO createCidadeDTO);
    boolean update(UpdateCidadeDTO updateCidadeDTO, T id);
    boolean deleteById(T id);
}
