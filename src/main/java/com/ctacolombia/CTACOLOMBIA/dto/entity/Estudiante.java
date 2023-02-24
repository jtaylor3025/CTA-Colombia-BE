package com.ctacolombia.CTACOLOMBIA.dto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @NotEmpty(message = "El capo de documento no puede estar vacio")
    private String estudianteDocumento;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "estudiante_tipodocu")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento;

    private String estudiantePrimernombre;

    private String estudianteSegundonombre;

    private String estudiantePrimerapellido;

    private String estudianteSegundoapellido;

    private String estudianteGenero;

    @JoinColumn(name = "estudiante_pais")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pais pais;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date estudianteNacimiento;

    private String estudianteNiveleducativo;

    private String estudianteAreatrabajo;

    private String estudianteCargo;

    private String estudianteSector;

    @JoinColumn(name = "estudiante_arl")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Arl estudianteArl;

    @JsonIgnoreProperties({"certificadoEstudiante","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certificadoEstudiante",cascade = CascadeType.ALL)
    private List<Certificado> certificados;

    public Estudiante(){
        certificados = new ArrayList<>();
    }
}
