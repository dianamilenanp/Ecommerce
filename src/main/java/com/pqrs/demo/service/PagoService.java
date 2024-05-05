package com.pqrs.demo.service;
import org.springframework.stereotype.Service;
import com.pqrs.demo.entity.Pago;
import com.pqrs.demo.repository.PagoRepository;

@Service
public class PagoService implements IPagoService{
    private PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago savePago(Pago pago) {
        return pagoRepository.save(pago);
    }

}


