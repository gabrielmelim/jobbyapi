package br.com.groupfive.jobby.controller.interfaces;

import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.cidade.CreateCidadeDTO;
import br.com.groupfive.jobby.dto.cidade.UpdateCidadeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICidadeController<T> {
    ResponseEntity<CidadeDTO> findById(T id);
    ResponseEntity<List<CidadeDTO>> findAll();
    ResponseEntity<CidadeDTO> create(CreateCidadeDTO createCidadeDTO);
    ResponseEntity update(UpdateCidadeDTO updateCidadeDTO, T id);
    ResponseEntity deleteById(T id);

}
