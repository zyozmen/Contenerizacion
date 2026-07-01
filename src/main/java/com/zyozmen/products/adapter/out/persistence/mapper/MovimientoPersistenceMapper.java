package com.zyozmen.products.adapter.out.persistence.mapper;

import com.zyozmen.products.adapter.out.persistence.entity.MovimientoJpaEntity;
import com.zyozmen.products.domain.model.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class MovimientoPersistenceMapper {

    public Movimiento toDomain(MovimientoJpaEntity entity) {
        return Movimiento.builder()
                .movimientoId(entity.getMovimientoId())
                .productoId(entity.getProductoId())
                .fechaHora(entity.getFechaHora())
                .cantidad(entity.getCantidad())
                .pesoEmpaqueKg(entity.getPesoEmpaqueKg())
                .margenGanancia(entity.getMargenGanancia())
                .imagenEvidencia(entity.getImagenEvidencia())
                .build();
    }

    public MovimientoJpaEntity toEntity(Movimiento domain) {
        return MovimientoJpaEntity.builder()
                .movimientoId(domain.getMovimientoId())
                .productoId(domain.getProductoId())
                .fechaHora(domain.getFechaHora())
                .cantidad(domain.getCantidad())
                .pesoEmpaqueKg(domain.getPesoEmpaqueKg())
                .margenGanancia(domain.getMargenGanancia())
                .imagenEvidencia(domain.getImagenEvidencia())
                .build();
    }
}
