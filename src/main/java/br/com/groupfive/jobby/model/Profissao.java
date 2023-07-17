package br.com.groupfive.jobby.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_profissao")
@Data
public class Profissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_profissao")
    private Integer idProfissao;
    @Column(length = 60, nullable = false)
    private String nome;

}
