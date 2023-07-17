package br.com.groupfive.jobby.controller.interfaces;

import br.com.groupfive.jobby.dto.profissao.CreateProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.ProfissaoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProfissaoController<T> {
    ResponseEntity<ProfissaoDTO> findById(T id);
    ResponseEntity<List<ProfissaoDTO>> findAll();
    ResponseEntity<ProfissaoDTO> create(CreateProfissaoDTO createProfissaoDTO);
    ResponseEntity deleteById(T id);
}
