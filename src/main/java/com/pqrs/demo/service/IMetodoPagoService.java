package com.pqrs.demo.service;
import java.util.List;

import com.pqrs.demo.entity.MetodoPago;


public interface IMetodoPagoService {
    List<MetodoPago> getAllMetodoPagos();
    MetodoPago getMetodoPago(int id);
}
