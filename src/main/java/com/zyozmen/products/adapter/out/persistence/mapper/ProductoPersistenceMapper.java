package com.zyozmen.products.adapter.out.persistence.mapper;

import com.zyozmen.products.domain.model.Producto;
import com.zyozmen.products.adapter.out.persistence.entity.ProductoJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper de persistencia. Convierte entre el modelo de dominio puro
 * y la entidad JPA de infraestructura.
 */
@Component
public class ProductoPersistenceMapper {

    public Producto toDomain(ProductoJpaEntity entity) {
        return Producto.builder()
                .id(entity.getId())
                .codigoBarras(entity.getCodigoBarras())
                .nombre(entity.getNombre())
                .fechaIngreso(entity.getFechaIngreso())
                .aplicaIva(entity.getAplicaIva())
                .precioBase(entity.getPrecioBase())
                .descripcionLarga(entity.getDescripcionLarga())
                .build();
    }

    public ProductoJpaEntity toEntity(Producto domain) {
        return ProductoJpaEntity.builder()
                .id(domain.getId())
                .codigoBarras(domain.getCodigoBarras())
                .nombre(domain.getNombre())
                .fechaIngreso(domain.getFechaIngreso())
                .aplicaIva(domain.getAplicaIva())
                .precioBase(domain.getPrecioBase())
                .descripcionLarga(domain.getDescripcionLarga())
                .build();
    }
}
