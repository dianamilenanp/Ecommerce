package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tarjetacredito")
public class TarjetaCredito  extends MetodoPago{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_tarjeta", nullable = true)
    private int numero_tarjeta;

    @Column(name = "cvv", nullable = true)
    private int cvv;
}
