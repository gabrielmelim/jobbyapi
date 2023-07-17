package br.com.groupfive.jobby.dto.endereco;

import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.model.Cidade;
import br.com.groupfive.jobby.model.Endereco;

public record EnderecoDTO(
    Long cep,
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    CidadeDTO cidade
)
{
    public static EnderecoDTO fromModel(Cadastro cadastro) {
        return new EnderecoDTO(
            cadastro.getEndereco().getCep(),
            cadastro.getEndereco().getLogradouro(),
            cadastro.getEndereco().getNumero(),
            cadastro.getEndereco().getComplemento(),
            cadastro.getEndereco().getBairro(),
            CidadeDTO.fromModel(cadastro.getCidade())
        );
    }
}
