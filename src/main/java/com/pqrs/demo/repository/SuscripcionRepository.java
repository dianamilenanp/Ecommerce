package com.pqrs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pqrs.demo.entity.Suscripcion;

public interface SuscripcionRepository  extends JpaRepository<Suscripcion, Integer>{
    
}
