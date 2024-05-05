package com.pqrs.demo.entity;
import java.util.Date;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suscripcion")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = true) 
    private Date fecha_inicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_final", nullable = true)
    private Date fecha_final;

    @Column(name = "duracion", nullable = true)
    private String duracion;

    @Column(name = "monto", nullable = true)
    private Float monto;

    @Column(name = "estado", nullable = true)
    private String estado;
    

    @Column(name = "id_medio", nullable = true)
    private int  id_medio;
    
}

