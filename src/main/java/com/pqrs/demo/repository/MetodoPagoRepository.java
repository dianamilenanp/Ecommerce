package com.pqrs.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pqrs.demo.entity.MetodoPago;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer>{
    
}

