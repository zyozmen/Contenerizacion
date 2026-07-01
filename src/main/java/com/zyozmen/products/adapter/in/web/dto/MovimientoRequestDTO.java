package com.zyozmen.products.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Datos de entrada para crear o actualizar un movimiento")
public class MovimientoRequestDTO {

    @Schema(description = "ID del movimiento", example = "1")
    private Long movimientoId;

    @NotNull(message = "El productoId es obligatorio")
    @Positive(message = "El productoId debe ser mayor a cero")
    @Schema(description = "ID del producto asociado", example = "5")
    private Integer productoId;

    @NotNull(message = "La fechaHora es obligatoria")
    @Schema(description = "Momento exacto del movimiento", example = "2026-06-30T10:20:00")
    private LocalDateTime fechaHora;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Schema(description = "Cantidad de unidades movidas", example = "15")
    private Short cantidad;

    @NotNull(message = "El pesoEmpaqueKg es obligatorio")
    @Schema(description = "Peso del empaque en kg", example = "2.35")
    private Float pesoEmpaqueKg;

    @NotNull(message = "El margenGanancia es obligatorio")
    @Schema(description = "Margen de ganancia", example = "0.18")
    private Double margenGanancia;

    @Schema(description = "Imagen de evidencia en binario (BLOB)", type = "string", format = "byte")
    private byte[] imagenEvidencia;
}
