package com.zyozmen.products.adapter.in.web.mapper;

import com.zyozmen.products.adapter.in.web.dto.MovimientoRequestDTO;
import com.zyozmen.products.adapter.in.web.dto.MovimientoResponseDTO;
import com.zyozmen.products.domain.model.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class MovimientoWebMapper {

    public Movimiento toDomain(MovimientoRequestDTO dto) {
        return Movimiento.builder()
                .movimientoId(dto.getMovimientoId())
                .productoId(dto.getProductoId())
                .fechaHora(dto.getFechaHora())
                .cantidad(dto.getCantidad())
                .pesoEmpaqueKg(dto.getPesoEmpaqueKg())
                .margenGanancia(dto.getMargenGanancia())
                .imagenEvidencia(dto.getImagenEvidencia())
                .build();
    }

    public MovimientoResponseDTO toResponseDTO(Movimiento movimiento) {
        return MovimientoResponseDTO.builder()
                .movimientoId(movimiento.getMovimientoId())
                .productoId(movimiento.getProductoId())
                .fechaHora(movimiento.getFechaHora())
                .cantidad(movimiento.getCantidad())
                .pesoEmpaqueKg(movimiento.getPesoEmpaqueKg())
                .margenGanancia(movimiento.getMargenGanancia())
                .imagenEvidencia(movimiento.getImagenEvidencia())
                .build();
    }
}
