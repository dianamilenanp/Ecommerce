package com.pqrs.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pqrs.demo.entity.Consignacion;
import com.pqrs.demo.repository.ConsignacionRepository;

@Service
public class ConsignacionService implements IConsignacionService{
    private ConsignacionRepository consignacionRepository;
 
    public  ConsignacionService (ConsignacionRepository consignacionRepository){
        this.consignacionRepository=consignacionRepository;
    }

    @Override
    public List<Consignacion> getAllConsignacions() {
         return consignacionRepository.findAll();
    }

    @Override
    public Consignacion saveConsignacion(Consignacion consignacion) {
        return consignacionRepository.save(consignacion);
    }
    
}