package com.zyozmen.products.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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
@Schema(description = "Datos de entrada para crear o actualizar un producto")
public class ProductoRequestDTO {

    @Schema(description = "ID autoincremental del producto", example = "1")
    private Integer id;

    @NotBlank(message = "El codigo de barras es obligatorio")
    @Size(min = 13, max = 13, message = "El codigo de barras debe tener exactamente 13 caracteres")
    @Schema(description = "Codigo EAN-13 del producto", example = "7701234567890")
    private String codigoBarras;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
    @Schema(description = "Nombre comercial del producto", example = "Laptop Dell XPS 15")
    private String nombre;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    @PastOrPresent(message = "La fecha de ingreso no puede ser futura")
    @Schema(description = "Fecha en la que se catalogo el producto", example = "2026-06-30")
    private LocalDate fechaIngreso;

    @NotNull(message = "El indicador aplicaIva es obligatorio")
    @Schema(description = "Indica si el producto aplica IVA", example = "true")
    private Boolean aplicaIva;

    @NotNull(message = "El precio base es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio base debe ser mayor a cero")
    @Schema(description = "Costo financiero preciso del producto", example = "1299.99")
    private BigDecimal precioBase;

    @Schema(description = "Ficha tecnica detallada del articulo", example = "Procesador Intel Core i7, 16GB RAM")
    private String descripcionLarga;
}
