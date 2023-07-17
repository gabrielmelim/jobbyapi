package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.repository.CadastroRepository;
import br.com.groupfive.jobby.repository.ExperienciaRepository;
import br.com.groupfive.jobby.repository.ProfissaoRepository;
import br.com.groupfive.jobby.repository.RecrutamentoRepository;
import br.com.groupfive.jobby.service.interfaces.IRecrutamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecrutamentoService implements IRecrutamentoService<Integer> {

    @Autowired
    RecrutamentoRepository recrutamentoRepository;
    @Autowired
    ProfissaoRepository profissaoRepository;
    @Autowired
    ExperienciaRepository experienciaRepository;
    @Autowired
    private CadastroRepository cadastroRepository;

    @Override
    public List<CadastroDTO> findByProfissao(String profissao) {
        var cadastrosEncontrados = recrutamentoRepository.findByProfissao(profissaoRepository.findByNome(profissao.toUpperCase()));
        return cadastrosEncontrados.isEmpty() ? null : cadastrosEncontrados.stream().map(c -> CadastroDTO.fromModel(c)).collect(Collectors.toList());
    }

    @Override
    public List<CadastroDTO> findByHabilidade(String habilidade) {
        List<Cadastro> cadastros = recrutamentoRepository.findByHabilidades(habilidade.toUpperCase());
        return cadastros.isEmpty() ? null : cadastros.stream().map(c -> CadastroDTO.fromModel(c)).collect(Collectors.toList());
    }

    @Override
    public List<CadastroDTO> findByHabilidadeNot(String habilidade) {
        List<Cadastro> cadastros = recrutamentoRepository.findByHabilidadesNotIgnoreCase(habilidade.toUpperCase());
        return cadastros.isEmpty() ? null : cadastros.stream().map(c -> CadastroDTO.fromModel(c)).collect(Collectors.toList());
    }

    @Override
    public List<CadastroDTO> findAll() {
        List<Cadastro> cadastros = recrutamentoRepository.findAll();
        return cadastros.isEmpty() ? null : cadastros.stream().map(c -> CadastroDTO.fromModel(c)).collect(Collectors.toList());
    }

    @Override
    public Long countCadastroForHabilidade(String habilidade) {
        return recrutamentoRepository.countByHabilidadesLikeIgnoreCase(habilidade);
    }

    @Override
    public Long countCadastroHaveNotHabilidade(String habilidade) {
        return recrutamentoRepository.countByHabilidadesNotLikeIgnoreCase(habilidade);
    }

    @Override
    public List<CadastroDTO> findByDataContratacaoBetween(LocalDate intialDate, LocalDate finalDate) {
        List<Cadastro> cadastros = recrutamentoRepository.findByDataContratacaoBetween(intialDate, finalDate);
        return cadastros.isEmpty() ? null : cadastros.stream().map(CadastroDTO::fromModel).collect(Collectors.toList());
    }
}
