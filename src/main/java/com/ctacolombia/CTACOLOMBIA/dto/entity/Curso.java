package com.ctacolombia.CTACOLOMBIA.dto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "curso")
@Data
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cursoId;

    @JoinColumn(name = "curso_programa")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Programa cursoPrograma;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cursoFechacreacion;

    private String cursoEstado;

}
