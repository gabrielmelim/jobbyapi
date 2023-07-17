package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.profissao.CreateProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.ProfissaoDTO;
import br.com.groupfive.jobby.model.Cidade;
import br.com.groupfive.jobby.model.Profissao;
import br.com.groupfive.jobby.repository.ProfissaoRepository;
import br.com.groupfive.jobby.service.interfaces.IProfissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissaoService implements IProfissaoService<Integer> {
    @Autowired
    ProfissaoRepository profissaoRepository;

    @Override
    public ProfissaoDTO findById(Integer id) {
        if(profissaoRepository.existsById(id)){
            Profissao profissaoModel = profissaoRepository.findById(id).get();
            return ProfissaoDTO.fromModel(profissaoModel);
        }else{
            return null;
        }
    }

    @Override
    public ProfissaoDTO create(CreateProfissaoDTO createProfissaoDTO) {
        Profissao profissaoModel = new Profissao();
        BeanUtils.copyProperties(createProfissaoDTO, profissaoModel);
        profissaoRepository.save(profissaoModel);
        return ProfissaoDTO.fromModel(profissaoModel);
    }


    @Override
    public boolean deleteById(Integer id) {
        if(profissaoRepository.existsById(id)){
            profissaoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<ProfissaoDTO> findAll() {
        List<Profissao> profissoes = profissaoRepository.findAll();
        return profissoes.isEmpty() ? null : profissoes.stream().map(p -> ProfissaoDTO.fromModel(p)).collect(Collectors.toList());
    }
}
