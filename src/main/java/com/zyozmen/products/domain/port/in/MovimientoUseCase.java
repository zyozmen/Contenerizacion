package com.zyozmen.products.domain.port.in;

import com.zyozmen.products.domain.model.Movimiento;

import java.util.List;

public interface MovimientoUseCase {

    List<Movimiento> listarTodos();

    Movimiento obtenerPorId(Long movimientoId);

    Movimiento crear(Movimiento movimiento);

    Movimiento actualizar(Long movimientoId, Movimiento movimiento);

    void eliminar(Long movimientoId);
}
