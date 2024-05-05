package com.pqrs.demo.service;
import org.springframework.stereotype.Service;
import com.pqrs.demo.entity.TarjetaCredito;
import com.pqrs.demo.repository.TarjetaCreditoRepository;

import java.util.List;

@Service
public class TarjetaCreditoService implements ITarjetaCreditoService {
    private TarjetaCreditoRepository tarjetaCreditoRepository;

    public TarjetaCreditoService(TarjetaCreditoRepository tarjetaCreditoRepository) {
        this.tarjetaCreditoRepository = tarjetaCreditoRepository;
    }

    @Override
    public List<TarjetaCredito> getAllTarjetaCreditos() {
        return tarjetaCreditoRepository.findAll();
    }

    @Override
    public TarjetaCredito saveCredito(TarjetaCredito tarjetaCredito) {
        return tarjetaCreditoRepository.save(tarjetaCredito);
    };
}