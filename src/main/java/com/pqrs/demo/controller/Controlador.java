package com.pqrs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.pqrs.demo.entity.*;
import com.pqrs.demo.service.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class Controlador {
    @Autowired
    private SuscripcionService suscripcionService;
    private MetodoPagoService metodoPagoService;
    private MetodoPagoFactory metodoPagoFactory;
    private TarjetaCreditoService tarjetaCreditoService;
    private PagoLineaService pagoLineaService;
    private PagoService pagoService;
    private ConsignacionService consignacionService;
    MetodoPago instancia;
    Pago pago;

    public Controlador(
            SuscripcionService suscripcionService, TarjetaCreditoService tarjetaCreditoService,
            MetodoPagoService metodoPagoService, PagoLineaService pagoLineaService,
            PagoService pagoService, ConsignacionService consignacionService) {
        this.suscripcionService = suscripcionService;
        this.tarjetaCreditoService = tarjetaCreditoService;
        this.metodoPagoService = metodoPagoService;
        this.pagoLineaService = pagoLineaService;
        this.pagoService = pagoService;
        this.consignacionService = consignacionService;
    }

    @GetMapping("/")
    public String mostrarInicio(Model modelo) {
        return "inicio";
    }

    @GetMapping("/iniciarSesion")
    public String mostrarLogin(Model modelo) {
        return "iniciarSesion";
    }

    @GetMapping("/suscripcion")
    public String mostrarSuscripciones(Model modelo) {
        //modelo.addAttribute("exitoso", 0);
        return "suscripcion";
    }

    @PostMapping("/datos")
    public String enviarDatos(@RequestParam("metodoSeleccionado") int idMedio,
            @RequestParam("suscripcionSeleccionada") int idSubs, Model modelo) {
        System.out.println("metodo " + idMedio);
        System.out.println("subs " + idSubs);

        IMetodoPagoFactoy fabrica = new MetodoPagoFactory();
        MetodoPago instancia = fabrica.crearMetodoPago(idMedio);
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setId_medio(idMedio);
        Date fechaHoy = java.sql.Date.valueOf(LocalDate.now());
        Date fechaMensual = java.sql.Date.valueOf(LocalDate.now().plusMonths(1));
        Date fechaSemestral = java.sql.Date.valueOf(LocalDate.now().plusMonths(6));
        Date fechaAnual = java.sql.Date.valueOf(LocalDate.now().plusYears(1));

        suscripcion.setFecha_inicio(fechaHoy);
        switch (idSubs) {
            case 1:
                suscripcion.setDuracion("mensual");
                suscripcion.setMonto((float) 60000);
                suscripcion.setFecha_final(fechaMensual);
                break;
            case 2:
                suscripcion.setDuracion("semestral");
                suscripcion.setMonto((float) 300000);
                suscripcion.setFecha_final(fechaSemestral);
                break;
            case 3:
                suscripcion.setDuracion("anual");
                suscripcion.setMonto((float) 600000);
                suscripcion.setFecha_final(fechaAnual);
                break;
            default:
                break;
        }
        suscripcion.setEstado("activa");
        suscripcionService.saveSuscripcion(suscripcion);
        modelo.addAttribute("formMedio", idMedio);
        modelo.addAttribute("tarjeta", instancia);
        modelo.addAttribute("pagoLinea", instancia);
        modelo.addAttribute("consignacion", instancia);
        return "crearPago";
    }

    @PostMapping("/enviartarjeta")
    public String recibirDatos(Model modelo, @ModelAttribute("tarjeta") TarjetaCredito tarjeta)  {
        System.out.println("metodo " + tarjeta);
        tarjetaCreditoService.saveCredito(tarjeta);
        pago = new Pago();
        pago.setId_usuario(1);
       
        //pago.setId_suscripcion(8);
        //pagoService.savePago(pago);
        modelo.addAttribute("exitoso", 1);
     
    
        return "suscripcion";
    }


    @PostMapping("/enviarpagolinea")
    public String recibirDatos(
            Model modelo, @ModelAttribute("pagoLinea") PagoLinea pagoLinea,
            @RequestParam("bancoSeleccionado") int idBanco) {
        System.out.println("metodo " + pagoLinea);
        Random rand = new Random();
        int randomNumber = rand.nextInt(90000) + 10000;
        pagoLinea.setId_banco(idBanco);
        pagoLinea.setNum_aprobacion(randomNumber);
        pagoLineaService.savePagoLinea(pagoLinea);
        modelo.addAttribute("exitoso", 1);
        return "suscripcion";
    }

    @PostMapping("/enviarconsignacion")
    public String recibirDatos(Model modelo, @ModelAttribute("consignacion") Consignacion consignacion) {
        System.out.println("metodo consignacion");
        LocalDate fecha = LocalDate.now();
        Date fechaHoy = java.sql.Date.valueOf(LocalDate.now());
        consignacion.setFecha_creacion(fechaHoy);
        consignacion.setFecha_consignacion(fechaHoy);
        consignacion.setNombre_archivo("consignaciones"+fechaHoy);
        consignacion.setRuta("resources/consignaciones/"+fechaHoy);
        consignacionService.saveConsignacion(consignacion);
        modelo.addAttribute("descarga", 1);
        return "suscripcion";
    }

}