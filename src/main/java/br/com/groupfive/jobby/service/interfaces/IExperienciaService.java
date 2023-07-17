package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.experiencia.CreateExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.ExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.UpdateExperienciaDTO;

public interface IExperienciaService<T> {
    ExperienciaDTO findById(T id);
    ExperienciaDTO create(CreateExperienciaDTO createExperienciaDTO);
    boolean update(UpdateExperienciaDTO updateExperienciaDTO, T id);
    boolean deleteById(T id);
}
