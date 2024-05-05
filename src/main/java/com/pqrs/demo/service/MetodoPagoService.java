package com.pqrs.demo.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.pqrs.demo.entity.MetodoPago;
import com.pqrs.demo.repository.MetodoPagoRepository;


@Service
public class MetodoPagoService implements IMetodoPagoService{
    private MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public List<MetodoPago> getAllMetodoPagos() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public MetodoPago getMetodoPago(int id) {
        return metodoPagoRepository.findById(id).get();
    };
}
