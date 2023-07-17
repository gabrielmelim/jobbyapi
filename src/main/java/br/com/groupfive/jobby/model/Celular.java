package br.com.groupfive.jobby.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Celular {
    @Column(name = "cel_numero")
    private Long numero;
    @Column(name = "cel_numero_whats")
    private boolean isWhatsapp;
}
