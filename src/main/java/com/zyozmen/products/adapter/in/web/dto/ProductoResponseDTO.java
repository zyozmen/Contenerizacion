package com.zyozmen.products.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Datos del producto devueltos por la API")
public class ProductoResponseDTO {

    @Schema(description = "Identificador único del producto", example = "1")
    private Integer id;

    @Schema(description = "Codigo EAN-13 del producto", example = "7701234567890")
    private String codigoBarras;

    @Schema(description = "Nombre comercial del producto", example = "Laptop Dell XPS 15")
    private String nombre;

    @Schema(description = "Fecha en la que se catalogo el producto", example = "2026-06-30")
    private LocalDate fechaIngreso;

    @Schema(description = "Indica si el producto aplica IVA", example = "true")
    private Boolean aplicaIva;

    @Schema(description = "Costo financiero preciso del producto", example = "1299.99")
    private BigDecimal precioBase;

    @Schema(description = "Ficha tecnica detallada del articulo", example = "Procesador Intel Core i7, 16GB RAM")
    private String descripcionLarga;
}
