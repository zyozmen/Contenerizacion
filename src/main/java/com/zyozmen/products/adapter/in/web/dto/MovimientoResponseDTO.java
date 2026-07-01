package com.zyozmen.products.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Datos de salida de un movimiento")
public class MovimientoResponseDTO {

    @Schema(description = "ID del movimiento", example = "1")
    private Long movimientoId;

    @Schema(description = "ID del producto asociado", example = "5")
    private Integer productoId;

    @Schema(description = "Momento exacto del movimiento", example = "2026-06-30T10:20:00")
    private LocalDateTime fechaHora;

    @Schema(description = "Cantidad de unidades movidas", example = "15")
    private Short cantidad;

    @Schema(description = "Peso del empaque en kg", example = "2.35")
    private Float pesoEmpaqueKg;

    @Schema(description = "Margen de ganancia", example = "0.18")
    private Double margenGanancia;

    @Schema(description = "Imagen de evidencia en binario (BLOB)", type = "string", format = "byte")
    private byte[] imagenEvidencia;
}
