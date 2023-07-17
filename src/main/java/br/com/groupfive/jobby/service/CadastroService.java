package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;
import br.com.groupfive.jobby.mapper.CadastroMapper;
import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.repository.CadastroRepository;
import br.com.groupfive.jobby.repository.CidadeRepository;
import br.com.groupfive.jobby.repository.ProfissaoRepository;
import br.com.groupfive.jobby.service.interfaces.ICadastroService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroService implements ICadastroService<Integer> {

    @Autowired
    CadastroRepository cadastroRepository;
    @Autowired
    ProfissaoRepository profissaoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public CadastroDTO findById(Integer id) {
        if(cadastroRepository.existsById(id)){
            Cadastro cadastroModel = cadastroRepository.findById(id).get();
            return CadastroDTO.fromModel(cadastroModel);
        }else{
            return null;
        }
    }

    @Override
    public CadastroDTO create(CreateCadastroDTO createCadastroDTO) {
        Cadastro cadastroModel =
            CadastroMapper
                .fromCreateCadastroDTOToEntity(
                createCadastroDTO,
                profissaoRepository.findById(createCadastroDTO.idProfissao()).get(),
                cidadeRepository.findById(createCadastroDTO.endereco().idCidade()).get()
            );

        cadastroRepository.save(cadastroModel);

        return CadastroDTO.fromModel(cadastroModel);
    }

    @Override
    public boolean update(UpdateCadastroDTO updateCadastroDTO, Integer id) {
        if(cadastroRepository.existsById(id)){
            Cadastro cadastro = cadastroRepository.findById(id).get();
            CadastroMapper.fromUpdateCadastroDTOToEntity(
                cadastro,
                updateCadastroDTO,
                profissaoRepository.findById(updateCadastroDTO.idProfissao()).get()
            );
            cadastroRepository.save(cadastro);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        if(cadastroRepository.existsById(id)){
            cadastroRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
