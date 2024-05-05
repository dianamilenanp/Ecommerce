package com.pqrs.demo.service;

import com.pqrs.demo.entity.Consignacion;
import com.pqrs.demo.entity.MetodoPago;
import com.pqrs.demo.entity.Pago;
import com.pqrs.demo.entity.PagoLinea;
import com.pqrs.demo.entity.Suscripcion;
import com.pqrs.demo.entity.TarjetaCredito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagoFactory implements IMetodoPagoFactoy{

    private TarjetaCredito tarjetaCredito;
    private PagoLinea pagoLinea; 
    private Consignacion consignacion;
   
  
	@Override
	public MetodoPago crearMetodoPago(int idMetodoPago) {
		if(idMetodoPago==1) {
			pagoLinea= new PagoLinea();
			
            return pagoLinea;
		}else if(idMetodoPago==2) {
			System.out.println("guardando");
			tarjetaCredito= new TarjetaCredito();
			return tarjetaCredito;
		}else {
			consignacion= new Consignacion();
            return consignacion;
		}
	}

	@Override
	public void crearMetodo(int idMetodoPago) {
		if(idMetodoPago==1) {
			pagoLinea= new PagoLinea();

		}else if(idMetodoPago==2) {
			System.out.println("guardando");
			tarjetaCredito= new TarjetaCredito();

		}else {
			consignacion= new Consignacion();

		}
	}
}
