package com.ventas.proyectoFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="LINEA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Linea {
    //creo un ID que se aut-genera y el resto de las columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lineaId;

    @Column (name = "DESCRIPCION")
    private String descripcion;

    @Column (name = "CANTIDAD")
    private int cantidad;

    @Column (name = "PRECIO")
    private float precio;

    //declaro la relación con la tabla comprobante
    @JsonBackReference (value="comprobante")
    @ManyToOne (fetch = FetchType.EAGER)
    private Comprobante comprobante;

    //declaro la relación con la tabla producto
//    @ManyToOne
//    @JoinColumn(name="productoid")
//    private Producto producto;
    @JsonBackReference(value = "producto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;

    //constructor vacío
    public Linea() {
    }

    //constructor con todas las properties
    public Linea(long lineaId, String descripcion, int cantidad, float precio, Comprobante comprobante, Producto producto) {
        this.lineaId = lineaId;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    //constructor con todas las properties menos ID

    public Linea(String descripcion, int cantidad, float precio, Comprobante comprobante, Producto producto) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.comprobante = comprobante;
        this.producto = producto;
    }


    // Getters y Setters

    public long getLineaId() {
        return lineaId;
    }

    public void setLineaId(long lineaId) {
        this.lineaId = lineaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //Equals y Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linea linea = (Linea) o;
        return lineaId == linea.lineaId && cantidad == linea.cantidad && Float.compare(linea.precio, precio) == 0 && descripcion.equals(linea.descripcion) && comprobante.equals(linea.comprobante) && producto.equals(linea.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineaId, descripcion, cantidad, precio, comprobante, producto);
    }


    //toString


    @Override
    public String toString() {
        return "Linea{" +
                "lineaId=" + lineaId +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", comprobante=" + comprobante +
                ", producto=" + producto +
                '}';
    }
}
