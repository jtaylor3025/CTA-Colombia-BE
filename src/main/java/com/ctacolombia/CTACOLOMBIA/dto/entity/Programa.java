package com.ctacolombia.CTACOLOMBIA.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "programa")
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programaId;

    private String programaNombre;

    private Integer programaIntensidad;

    private String programaModalidad;
}
