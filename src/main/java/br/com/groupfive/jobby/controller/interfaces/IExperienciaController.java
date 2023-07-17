package br.com.groupfive.jobby.controller.interfaces;

import br.com.groupfive.jobby.dto.experiencia.CreateExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.ExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.UpdateExperienciaDTO;
import org.springframework.http.ResponseEntity;

public interface IExperienciaController<T> {
    ResponseEntity<ExperienciaDTO> findById(T id);
    ResponseEntity<ExperienciaDTO> create(CreateExperienciaDTO createExperienciaDTO);
    ResponseEntity update(UpdateExperienciaDTO updateExperienciaDTO, T id);
    ResponseEntity deleteById(T id);
}
