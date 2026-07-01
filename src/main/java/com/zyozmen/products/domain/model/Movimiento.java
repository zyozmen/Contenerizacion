package com.zyozmen.products.domain.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * Modelo de dominio Movimiento.
 */
public class Movimiento {

    private Long movimientoId;
    private Integer productoId;
    private LocalDateTime fechaHora;
    private Short cantidad;
    private Float pesoEmpaqueKg;
    private Double margenGanancia;
    private byte[] imagenEvidencia;

    public Movimiento() {
    }

    public Movimiento(Long movimientoId, Integer productoId, LocalDateTime fechaHora, Short cantidad,
                      Float pesoEmpaqueKg, Double margenGanancia, byte[] imagenEvidencia) {
        this.movimientoId = movimientoId;
        this.productoId = productoId;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.pesoEmpaqueKg = pesoEmpaqueKg;
        this.margenGanancia = margenGanancia;
        this.imagenEvidencia = imagenEvidencia;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPesoEmpaqueKg() {
        return pesoEmpaqueKg;
    }

    public void setPesoEmpaqueKg(Float pesoEmpaqueKg) {
        this.pesoEmpaqueKg = pesoEmpaqueKg;
    }

    public Double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(Double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public byte[] getImagenEvidencia() {
        return imagenEvidencia;
    }

    public void setImagenEvidencia(byte[] imagenEvidencia) {
        this.imagenEvidencia = imagenEvidencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movimiento that = (Movimiento) o;
        return Objects.equals(movimientoId, that.movimientoId)
                && Objects.equals(productoId, that.productoId)
                && Objects.equals(fechaHora, that.fechaHora)
                && Objects.equals(cantidad, that.cantidad)
                && Objects.equals(pesoEmpaqueKg, that.pesoEmpaqueKg)
                && Objects.equals(margenGanancia, that.margenGanancia)
                && Arrays.equals(imagenEvidencia, that.imagenEvidencia);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(movimientoId, productoId, fechaHora, cantidad, pesoEmpaqueKg, margenGanancia);
        result = 31 * result + Arrays.hashCode(imagenEvidencia);
        return result;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "movimientoId=" + movimientoId +
                ", productoId=" + productoId +
                ", fechaHora=" + fechaHora +
                ", cantidad=" + cantidad +
                ", pesoEmpaqueKg=" + pesoEmpaqueKg +
                ", margenGanancia=" + margenGanancia +
                ", imagenEvidenciaBytes=" + (imagenEvidencia == null ? 0 : imagenEvidencia.length) +
                '}';
    }

    public static class Builder {

        private Long movimientoId;
        private Integer productoId;
        private LocalDateTime fechaHora;
        private Short cantidad;
        private Float pesoEmpaqueKg;
        private Double margenGanancia;
        private byte[] imagenEvidencia;

        public Builder movimientoId(Long movimientoId) {
            this.movimientoId = movimientoId;
            return this;
        }

        public Builder productoId(Integer productoId) {
            this.productoId = productoId;
            return this;
        }

        public Builder fechaHora(LocalDateTime fechaHora) {
            this.fechaHora = fechaHora;
            return this;
        }

        public Builder cantidad(Short cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder pesoEmpaqueKg(Float pesoEmpaqueKg) {
            this.pesoEmpaqueKg = pesoEmpaqueKg;
            return this;
        }

        public Builder margenGanancia(Double margenGanancia) {
            this.margenGanancia = margenGanancia;
            return this;
        }

        public Builder imagenEvidencia(byte[] imagenEvidencia) {
            this.imagenEvidencia = imagenEvidencia;
            return this;
        }

        public Movimiento build() {
            return new Movimiento(movimientoId, productoId, fechaHora, cantidad, pesoEmpaqueKg, margenGanancia, imagenEvidencia);
        }
    }
}
