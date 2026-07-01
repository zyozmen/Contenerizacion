package com.zyozmen.products.domain.port.out;

import com.zyozmen.products.domain.model.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoRepositoryPort {

    List<Movimiento> findAll();

    Optional<Movimiento> findById(Long movimientoId);

    Movimiento save(Movimiento movimiento);

    boolean existsById(Long movimientoId);

    void deleteById(Long movimientoId);
}
