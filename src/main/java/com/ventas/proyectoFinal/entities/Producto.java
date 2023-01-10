package com.ventas.proyectoFinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="PRODUCTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Producto {

    //creo un ID que se aut-genera y el resto de las columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productoId;

    @Column (name = "CODIGO")
    private int codigo;

    @Column (name = "DESCRIPCION")
    private String descripcion;

    @Column (name = "CANTIDAD")
    private int cantidad;

    @Column (name = "PRECIO")
    private double precio;

//    declaro la relación con la tabla linea
    @JsonManagedReference
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Linea> linea;

    //constructor vacío
    public Producto() {
    }

    //constructor con todas las properties
    public Producto(long productoId, int codigo, String descripcion, int cantidad, double precio, List<Linea> linea) {
        this.productoId = productoId;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.linea = linea;
    }


    //constructor con todas las properties menos ID

    public Producto(int codigo, String descripcion, int cantidad, double precio, List<Linea> linea) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.linea = linea;
    }

    // Getters y Setters
    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<com.ventas.proyectoFinal.entities.Linea> getLinea() {
        return linea;
    }

    public void setLinea(List<com.ventas.proyectoFinal.entities.Linea> linea) {
        this.linea = linea;
    }

    //Equals y Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return productoId == producto.productoId && codigo == producto.codigo && cantidad == producto.cantidad && Double.compare(producto.precio, precio) == 0 && descripcion.equals(producto.descripcion) && linea.equals(producto.linea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, codigo, descripcion, cantidad, precio, linea);
    }

    //toString


    @Override
    public String toString() {
        return "Producto{" +
                "productoId=" + productoId +
                ", codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", linea=" + linea +
                '}';
    }
}
