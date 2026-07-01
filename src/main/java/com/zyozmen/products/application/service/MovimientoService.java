package com.zyozmen.products.application.service;

import com.zyozmen.products.domain.exception.ResourceNotFoundException;
import com.zyozmen.products.domain.model.Movimiento;
import com.zyozmen.products.domain.port.in.MovimientoUseCase;
import com.zyozmen.products.domain.port.out.MovimientoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoService implements MovimientoUseCase {

    private final MovimientoRepositoryPort repositoryPort;

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> listarTodos() {
        return repositoryPort.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento obtenerPorId(Long movimientoId) {
        return repositoryPort.findById(movimientoId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Movimiento no encontrado con ID: " + movimientoId));
    }

    @Override
    @Transactional
    public Movimiento crear(Movimiento movimiento) {
        return repositoryPort.save(movimiento);
    }

    @Override
    @Transactional
    public Movimiento actualizar(Long movimientoId, Movimiento movimiento) {
        Movimiento existente = repositoryPort.findById(movimientoId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Movimiento no encontrado con ID: " + movimientoId));

        existente.setProductoId(movimiento.getProductoId());
        existente.setFechaHora(movimiento.getFechaHora());
        existente.setCantidad(movimiento.getCantidad());
        existente.setPesoEmpaqueKg(movimiento.getPesoEmpaqueKg());
        existente.setMargenGanancia(movimiento.getMargenGanancia());
        existente.setImagenEvidencia(movimiento.getImagenEvidencia());

        return repositoryPort.save(existente);
    }

    @Override
    @Transactional
    public void eliminar(Long movimientoId) {
        if (!repositoryPort.existsById(movimientoId)) {
            throw new ResourceNotFoundException("Movimiento no encontrado con ID: " + movimientoId);
        }
        repositoryPort.deleteById(movimientoId);
    }
}
