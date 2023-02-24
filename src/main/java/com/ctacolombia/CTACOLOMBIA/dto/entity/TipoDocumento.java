package com.ctacolombia.CTACOLOMBIA.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipodocu_id")
    private Long tipodocuId;

    @Column(name = "tipodocu_nombre", nullable = false)
    private String tipodocuNombre;
}
