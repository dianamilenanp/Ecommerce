package com.pqrs.demo.service;

import com.pqrs.demo.entity.MetodoPago;
import com.pqrs.demo.entity.Pago;
import com.pqrs.demo.entity.Suscripcion;

public interface IMetodoPagoFactoy {

    public MetodoPago crearMetodoPago(int idMetodoPago);
    public void crearMetodo(int idMetodoPago);
}
