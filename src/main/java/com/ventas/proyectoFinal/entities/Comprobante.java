package com.ventas.proyectoFinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="COMPROBANTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


public class Comprobante {

    //creo un ID que se aut-genera y el resto de las columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comprobanteId;

    @Column (name = "FECHA")
    private Date fecha;

    @Column (name="CANTIDAD")
    private int cantidad;

    @Column (name="TOTAL")
    private float total;

    //declaro la relación con la tabla cliente
    @JsonBackReference(value = "cliente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    //declaro la relación con la tabla linea
    @JsonManagedReference
    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Linea> linea;

    //constructor vacío
    public Comprobante() {
    }

    //constructor con todas las properties


    public Comprobante(long comprobanteId, Date fecha, int cantidad, float total, Cliente cliente, List<Linea> linea) {
        this.comprobanteId = comprobanteId;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente = cliente;
        this.linea = linea;
    }

    //constructor con todas las properties menos ID
    public Comprobante(Date fecha, int cantidad, float total, Cliente cliente, List<Linea> linea) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente = cliente;
        this.linea = linea;
    }

    // Getters y Setters
    public long getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(long comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Linea> getLinea() {
        return linea;
    }

    public void setLinea(List<Linea> linea) {
        this.linea = linea;
    }
//Equals y Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprobante that = (Comprobante) o;
        return comprobanteId == that.comprobanteId && cantidad == that.cantidad && Float.compare(that.total, total) == 0 && fecha.equals(that.fecha) && cliente.equals(that.cliente) && linea.equals(that.linea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comprobanteId, fecha, cantidad, total, cliente, linea);
    }


    //Genearte toString


    @Override
    public String toString() {
        return "Comprobante{" +
                "comprobanteId=" + comprobanteId +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", total=" + total +
                ", cliente=" + cliente +
                ", linea=" + linea +
                '}';
    }
}
