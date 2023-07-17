package br.com.groupfive.jobby.controller.interfaces;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICadastroController<T> {
    ResponseEntity<CadastroDTO> findById(T id);
    ResponseEntity<CadastroDTO> create(CreateCadastroDTO createCadastroDTO);
    ResponseEntity update(UpdateCadastroDTO updateCadastroDTO, T id);
    ResponseEntity deleteById(T id);
}
