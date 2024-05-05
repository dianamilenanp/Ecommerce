package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "metodopago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo", nullable = true)
    private String tipo;

}
