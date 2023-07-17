package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;

public interface ICadastroService<T> {
    CadastroDTO findById(T id);
    CadastroDTO create(CreateCadastroDTO createCadastroDTO);
    boolean update(UpdateCadastroDTO updateCadastroDTO, Integer id);
    boolean deleteById(T id);
}
