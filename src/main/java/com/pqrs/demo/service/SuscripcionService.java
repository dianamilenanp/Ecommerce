package com.pqrs.demo.service;
import com.pqrs.demo.repository.SuscripcionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.pqrs.demo.entity.Suscripcion;
import com.pqrs.demo.service.*;

@Service
public class SuscripcionService implements ISuscripcionService{
    private SuscripcionRepository suscripcionRepository;

    public SuscripcionService(SuscripcionRepository suscripcionRepository){
        this.suscripcionRepository=suscripcionRepository;
    }

    @Override
    public Suscripcion saveSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public Suscripcion getSuscripcion(int id) {
        return suscripcionRepository.findById(id).get();
    }
}

