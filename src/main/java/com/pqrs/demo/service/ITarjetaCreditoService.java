package com.pqrs.demo.service;
import java.util.List;
import com.pqrs.demo.entity.TarjetaCredito;

public interface ITarjetaCreditoService {
     List<TarjetaCredito> getAllTarjetaCreditos();

     TarjetaCredito saveCredito(TarjetaCredito tarjetaCredito);
}
