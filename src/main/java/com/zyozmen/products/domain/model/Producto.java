package com.zyozmen.products.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Modelo de dominio Producto. 
 * 
 */
public class Producto {

    private Integer id;
    private String codigoBarras;
    private String nombre;
    private LocalDate fechaIngreso;
    private Boolean aplicaIva;
    private BigDecimal precioBase;
    private String descripcionLarga;

    public Producto() {
    }

    public Producto(Integer id, String codigoBarras, String nombre, LocalDate fechaIngreso,
                    Boolean aplicaIva, BigDecimal precioBase, String descripcionLarga) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.aplicaIva = aplicaIva;
        this.precioBase = precioBase;
        this.descripcionLarga = descripcionLarga;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Boolean getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(Boolean aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id)
                && Objects.equals(codigoBarras, producto.codigoBarras)
                && Objects.equals(nombre, producto.nombre)
                && Objects.equals(fechaIngreso, producto.fechaIngreso)
                && Objects.equals(aplicaIva, producto.aplicaIva)
                && Objects.equals(precioBase, producto.precioBase)
                && Objects.equals(descripcionLarga, producto.descripcionLarga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBarras, nombre, fechaIngreso, aplicaIva, precioBase, descripcionLarga);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
            ", codigoBarras='" + codigoBarras + '\'' +
                ", nombre='" + nombre + '\'' +
            ", fechaIngreso=" + fechaIngreso +
            ", aplicaIva=" + aplicaIva +
            ", precioBase=" + precioBase +
            ", descripcionLarga='" + descripcionLarga + '\'' +
                '}';
    }

    public static class Builder {

        private Integer id;
        private String codigoBarras;
        private String nombre;
        private LocalDate fechaIngreso;
        private Boolean aplicaIva;
        private BigDecimal precioBase;
        private String descripcionLarga;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder codigoBarras(String codigoBarras) {
            this.codigoBarras = codigoBarras;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder fechaIngreso(LocalDate fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
            return this;
        }

        public Builder aplicaIva(Boolean aplicaIva) {
            this.aplicaIva = aplicaIva;
            return this;
        }

        public Builder precioBase(BigDecimal precioBase) {
            this.precioBase = precioBase;
            return this;
        }

        public Builder descripcionLarga(String descripcionLarga) {
            this.descripcionLarga = descripcionLarga;
            return this;
        }

        public Producto build() {
            return new Producto(id, codigoBarras, nombre, fechaIngreso, aplicaIva, precioBase, descripcionLarga);
        }
    }
}
