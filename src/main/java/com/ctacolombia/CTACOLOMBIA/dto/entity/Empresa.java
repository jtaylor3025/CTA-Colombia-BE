package com.ctacolombia.CTACOLOMBIA.dto.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "empresa_nit")
    @NotEmpty(message = "no puede estar vacio")
    private String empresaNit;

    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "empresa_nombre", nullable = false)
    private String empresaNombre;

    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "empresa_representante", nullable = false)
    private String empresaRepresentante;
}
