package com.pqrs.demo.service;
import org.springframework.stereotype.Service;
import com.pqrs.demo.entity.PagoLinea;
import com.pqrs.demo.repository.PagoLineaRepository;
import java.util.List;

@Service
public class PagoLineaService implements IPagoLineaService {
    private PagoLineaRepository pagoLineaRepository;

    public PagoLineaService(PagoLineaRepository pagoLineaRepository) {
        this.pagoLineaRepository = pagoLineaRepository;
    }

    @Override
    public List<PagoLinea> getAllPagoLineas() {
        return pagoLineaRepository.findAll();
    }

    @Override
    public PagoLinea savePagoLinea(PagoLinea pagoLinea) {
        return pagoLineaRepository.save(pagoLinea);
    };
}
