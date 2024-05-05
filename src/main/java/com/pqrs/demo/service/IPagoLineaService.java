package com.pqrs.demo.service;
import java.util.List;
import com.pqrs.demo.entity.PagoLinea;
import com.pqrs.demo.entity.TarjetaCredito;

public interface IPagoLineaService {
    List<PagoLinea> getAllPagoLineas();

    
    PagoLinea savePagoLinea(PagoLinea pagoLinea);
}
