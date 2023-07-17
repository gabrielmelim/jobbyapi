package br.com.groupfive.jobby.service;


import br.com.groupfive.jobby.dto.experiencia.CreateExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.ExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.UpdateExperienciaDTO;
import br.com.groupfive.jobby.model.Experiencia;
import br.com.groupfive.jobby.model.RegimeContratacao;
import br.com.groupfive.jobby.repository.CadastroRepository;
import br.com.groupfive.jobby.repository.ExperienciaRepository;
import br.com.groupfive.jobby.repository.ProfissaoRepository;
import br.com.groupfive.jobby.service.interfaces.IExperienciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExperienciaService implements IExperienciaService<Integer> {
    @Autowired
    ExperienciaRepository experienciaRepository;
    @Autowired
    ProfissaoRepository profissaoRepository;
    @Autowired
    CadastroRepository cadastroRepository;
    @Override
    public ExperienciaDTO findById(Integer id) {
        if(experienciaRepository.existsById(id)){
            Experiencia experienciaModel = experienciaRepository.findById(id).get();
            return ExperienciaDTO.fromModel(experienciaModel);
        }else{
            return null;
        }
    }

    @Override
    public ExperienciaDTO create(CreateExperienciaDTO createExperienciaDTO) {
        Experiencia experienciaModel = new Experiencia();

        BeanUtils.copyProperties(createExperienciaDTO, experienciaModel);
        experienciaModel.setSalario(BigDecimal.valueOf(createExperienciaDTO.salario()));
        experienciaModel.setCadastro(cadastroRepository.findById(createExperienciaDTO.idCadastro()).get());
        experienciaModel.setProfissao(profissaoRepository.findById(createExperienciaDTO.idProfissao()).get());
        RegimeContratacao regimeContratacao = RegimeContratacao.valueOf(createExperienciaDTO.regimeContratacao());
        experienciaModel.setRegimeContratacao(regimeContratacao);
        experienciaRepository.save(experienciaModel);

        System.out.println(experienciaModel);
        return ExperienciaDTO.fromModel(experienciaModel);
    }

    @Override
    public boolean update(UpdateExperienciaDTO updateExperienciaDTO, Integer id) {
        if(experienciaRepository.existsById(id)){
            Experiencia experienciaModel = experienciaRepository.findById(id).get();
            BeanUtils.copyProperties(updateExperienciaDTO, experienciaModel);
            experienciaModel.setSalario(BigDecimal.valueOf(updateExperienciaDTO.salario()));
            experienciaModel.setProfissao(profissaoRepository.findById(updateExperienciaDTO.idProfissao()).get());
            RegimeContratacao regimeContratacao = RegimeContratacao.valueOf(updateExperienciaDTO.regimeContratacao());
            experienciaModel.setRegimeContratacao(regimeContratacao);

            experienciaRepository.save(experienciaModel);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        if(experienciaRepository.existsById(id)){
            experienciaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
