package br.com.groupfive.jobby.controller.interfaces;

import br.com.groupfive.jobby.dto.recrutamento.AggroupDTO;
import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.recrutamento.CandidatoProfissaoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IRecrutamentoController {

//    Selecionar os candidatos que são do sexo FEMININO e que moram nas cidades do estado sigla SP informando o
//    nome, cpf, dados de endereço e nome da cidade
//    List<> findByCadastroForSexoAndState(String sexo, String siglaEstado);

//   Endryo Agrupar por profissão e contar quantos profissionais que moram na cidade de nome SÃO PAULO
    List<AggroupDTO> aggroupProfissao(String nameProfissao);

//    Fernando Selecionar candidatos que registram experiências com data de contratação entre 01/01/2022 a 31/12/2023
    List<CadastroDTO> findCadastroBetweenTwoDates(LocalDate initialDate, LocalDate finalDate);

//    Fernando Selecionar candidatos que trabalharam na empresa MICROSOFT
    List<CadastroDTO> findCadastrosForCompany(String nameCompany);

//    Selecionar candidatos que AINDA trabalham na empresa MICROSOFT
    List<CadastroDTO> findCadastrosForCurrentCompany(String nameCompany, Boolean isCurrentCompany);

//    Selecionar candidatos que estão trabalhando atualmente
    List<CadastroDTO> findCadastrosForCurrentlyWorking(Boolean isCurrentlyWorking);


//    Criar uma consulta que conte a quantidade de profissionais por profissão
//    ProfissionaisForProfissaoDTO findProfissionaisForProfissao(String nameProfissao);

//    Criar uma consulta que retorne os candidatos ordenados por profissão e salário máximo de forma decrescente

//    * buscar por habilidade
}
