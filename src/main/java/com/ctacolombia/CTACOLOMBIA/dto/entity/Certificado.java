package com.ctacolombia.CTACOLOMBIA.dto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "certificado")
public class Certificado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificadoId;

    @JoinColumn(name = "certificado_estudiante")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estudiante certificadoEstudiante;

    @JoinColumn(name = "certificado_curso")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Curso certificadoCurso;

    @JoinColumn(name = "certificado_empresa")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa certificadoEmpresa;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date certificadoFecha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date certificadoVencimiento;
}
