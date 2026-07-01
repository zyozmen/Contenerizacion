package com.zyozmen.products.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimiento_id")
    private Long movimientoId;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductoJpaEntity producto;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "cantidad", nullable = false)
    private Short cantidad;

    @Column(name = "peso_empaque_kg", nullable = false)
    private Float pesoEmpaqueKg;

    @Column(name = "margen_ganancia", nullable = false)
    private Double margenGanancia;

    @Lob
    @Column(name = "imagen_evidencia")
    private byte[] imagenEvidencia;
}
