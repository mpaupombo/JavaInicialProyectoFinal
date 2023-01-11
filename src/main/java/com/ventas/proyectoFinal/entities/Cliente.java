package com.ventas.proyectoFinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

//declaro la entity y la tabla
@Entity
@Table (name="CLIENTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Cliente {

    //creo un ID que se aut-genera y el resto de las columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clienteid;

    @Column (name="DNI")
    private int dni;

    @Column (name="NOMBRE")
    private String nombre;

    @Column (name="APELLIDO")
    private String apellido;

    //declaro la relación con la tabla comprobante
    @JsonManagedReference (value="comprobante")
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Comprobante> comprobante;

    //constructor vacío
    public Cliente() {
    }


    //constructor con todas las properties
    public Cliente(long clienteid, int dni, String nombre, String apellido, List<Comprobante> comprobante) {
        this.clienteid = clienteid;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.comprobante = comprobante;
    }

    //constructor con todas las properties menos id
    public Cliente(int dni, String nombre, String apellido, List<Comprobante> comprobante) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.comprobante = comprobante;
    }

    //setters y getters

    public long getClienteid() {
        return clienteid;
    }

    public void setClienteid(long clienteid) {
        this.clienteid = clienteid;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(List<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }

//equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return clienteid == cliente.clienteid && dni == cliente.dni && nombre.equals(cliente.nombre) && apellido.equals(cliente.apellido) && comprobante.equals(cliente.comprobante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteid, dni, nombre, apellido, comprobante);
    }

    //toString

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteid=" + clienteid +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", comprobante=" + comprobante +
                '}';
    }
}
