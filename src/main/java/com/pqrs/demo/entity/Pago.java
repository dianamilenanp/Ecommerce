package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_suscripcion", nullable = true)
    private int id_suscripcion;

    @Column(name = "id_medio", nullable = true)
    private int id_medio;

    @Column(name = "id_usuario", nullable = true)
    private int id_usuario;
    
}

