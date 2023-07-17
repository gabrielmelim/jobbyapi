package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.cidade.CreateCidadeDTO;
import br.com.groupfive.jobby.dto.cidade.UpdateCidadeDTO;
import br.com.groupfive.jobby.model.Cidade;
import br.com.groupfive.jobby.repository.CidadeRepository;
import br.com.groupfive.jobby.service.interfaces.ICidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService implements ICidadeService<Integer> {
    @Autowired
    CidadeRepository cidadeRepository;

    @Override
    public CidadeDTO findById(Integer id) {
        if(cidadeRepository.existsById(id)){
            Cidade cidadeModel = cidadeRepository.findById(id).get();
            return CidadeDTO.fromModel(cidadeModel);
        }else{
            return null;
        }
    }

    @Override
    public CidadeDTO create(CreateCidadeDTO createCidadeDTO) {
        Cidade cidadeModel = new Cidade();
        BeanUtils.copyProperties(createCidadeDTO, cidadeModel);
        cidadeRepository.save(cidadeModel);

        return CidadeDTO.fromModel(cidadeModel);
    }

    @Override
    public boolean update(UpdateCidadeDTO updateCidadeDTO, Integer id) {
        if(cidadeRepository.existsById(id)){
            Cidade cidadeModel = cidadeRepository.findById(id).get();
            BeanUtils.copyProperties(updateCidadeDTO, cidadeModel);
            cidadeRepository.save(cidadeModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        if(cidadeRepository.existsById(id)){
            cidadeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CidadeDTO> findAll() {
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades.isEmpty() ? null : cidades.stream().map(c -> CidadeDTO.fromModel(c)).collect(Collectors.toList());
    }
}
