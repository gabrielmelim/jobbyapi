package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;

public interface IEnderecoService<T> {
    EnderecoDTO findById(T id);
    boolean update(UpdateEnderecoDTO updateEnderecoDTO, Integer id);
}
