package com.ctacolombia.CTACOLOMBIA.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "arl")
public class Arl implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arlId;

    @Column(nullable = false)
    private String arlNombre;
}
