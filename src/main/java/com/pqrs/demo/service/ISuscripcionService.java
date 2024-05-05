package com.pqrs.demo.service;
import com.pqrs.demo.entity.Suscripcion;

public interface ISuscripcionService {

    Suscripcion saveSuscripcion(Suscripcion suscripcion);

    Suscripcion getSuscripcion(int id);
}


  