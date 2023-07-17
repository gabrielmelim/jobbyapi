package br.com.groupfive.jobby.dto.cadastro;

import br.com.groupfive.jobby.dto.profissao.ProfissaoDTO;
import br.com.groupfive.jobby.model.Cadastro;

import java.time.LocalDate;
import java.util.List;

public record CadastroDTO(
        Integer id,
        String nome,
        String cpf,
        String sexo,
        LocalDate dataNascimento,
        Long telefone,
        String email,
        Long numeroCelularProfissional,
        Boolean isWhatsProfissional,
        Long numeroCelularPessoal,
        Boolean isWhatsPessoal,
        Double pretensaoMin,
        Double pretensaoMax,
        List habilidades,
        ProfissaoDTO profissao
) {
    public static CadastroDTO fromModel(Cadastro cadastro) {
        return new CadastroDTO(
            cadastro.getIdCadastro(),
            cadastro.getNome(),
            cadastro.getCpf(),
            cadastro.getSexo().name(),
            cadastro.getDataNascimento(),
            cadastro.getTelefone(),
            cadastro.getEmail(),
            cadastro.getCelularProfissional().getNumero(),
            cadastro.getCelularProfissional().isWhatsapp(),
            cadastro.getCelularPessoal().getNumero(),
            cadastro.getCelularPessoal().isWhatsapp(),
            cadastro.getPretencaoSalarial().getValorMinimo(),
            cadastro.getPretencaoSalarial().getValorMaximo(),
            cadastro.getHabilidades(),
            ProfissaoDTO.fromModel(cadastro.getProfissao())
        );
    }
}
