package com.pqrs.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pqrs.demo.entity.TarjetaCredito;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Integer> {
    
}

