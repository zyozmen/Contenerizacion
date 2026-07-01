package com.zyozmen.products.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Entidad JPA de infraestructura. Las anotaciones de persistencia
 * (@Entity, @Table, @Column) residen aquí, no en el modelo de dominio,
 * manteniendo el dominio libre de dependencias de frameworks.
 */
@Entity
@Table(name = "productos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_barras", nullable = false, unique = true, length = 13, columnDefinition = "CHAR(13)")
    private String codigoBarras;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "aplica_iva", nullable = false)
    private Boolean aplicaIva;

    @Column(name = "precio_base", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioBase;

    @Column(name = "descripcion_larga", columnDefinition = "TEXT")
    private String descripcionLarga;

    @OneToMany(mappedBy = "producto")
    @Builder.Default
    private List<MovimientoJpaEntity> movimientos = new ArrayList<>();
}
