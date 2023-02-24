package com.ctacolombia.CTACOLOMBIA.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pais")
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Long paisId;

    @Column(name = "pais_nombre", nullable = false)
    private String paisNombre;
}
