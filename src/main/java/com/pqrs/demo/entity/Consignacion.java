package com.pqrs.demo.entity;
import java.util.Date;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "consignacion")
public class Consignacion extends MetodoPago{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ruta", nullable = true)
    private String ruta;

    @Column(name = "fecha_consignacion", nullable = true)
    private Date fecha_consignacion;

    @Column(name = "fecha_creacion", nullable = true)
    private Date fecha_creacion;

    @Column(name = "nombre_archivo", nullable = true)
    private String nombre_archivo;
}
