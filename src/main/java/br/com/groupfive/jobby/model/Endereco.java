package br.com.groupfive.jobby.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.Fetch;

@Data
@Embeddable
public class Endereco {

    private Long cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

}
