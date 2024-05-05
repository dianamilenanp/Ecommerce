package com.pqrs.demo.service;
import java.util.List;
import com.pqrs.demo.entity.Consignacion;

public interface IConsignacionService {
    List<Consignacion> getAllConsignacions();

    Consignacion saveConsignacion(Consignacion consignacion);
}
