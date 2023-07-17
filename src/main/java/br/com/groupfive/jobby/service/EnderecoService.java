package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;
import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.repository.CadastroRepository;
import br.com.groupfive.jobby.repository.CidadeRepository;
import br.com.groupfive.jobby.service.interfaces.IEnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService<Integer> {

    @Autowired
    CadastroRepository cadastroRepository;

    @Autowired
    CidadeRepository cidadeRepository;
    @Override
    public EnderecoDTO findById(Integer id) {
        if(cadastroRepository.existsById(id)){
            return EnderecoDTO.fromModel(cadastroRepository.findById(id).get());
        }else{
            return null;
        }
    }

    @Override
    public boolean update(UpdateEnderecoDTO updateEnderecoDTO, Integer id) {
        if(cadastroRepository.existsById(id)){
            Cadastro cadastro = cadastroRepository.findById(id).get();
            BeanUtils.copyProperties(updateEnderecoDTO, cadastro.getEndereco());
            cadastroRepository.save(cadastro);
            return true;
        }else{
            return false;
        }
    }
}
