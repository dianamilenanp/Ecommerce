package com.pqrs.demo.entity;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pagolinea")
public class PagoLinea extends MetodoPago{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_banco", nullable = true)
    private int id_banco;

    @Column(name = "num_aprobacion", nullable = true)
    private int num_aprobacion;




}