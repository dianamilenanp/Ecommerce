package com.pqrs.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pqrs.demo.entity.Consignacion;

public interface ConsignacionRepository  extends JpaRepository<Consignacion, Integer> {
    
}
