package com.spring.docker.github01.entities;


import jakarta.persistence.*;

@Entity
public class Producto {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nombre;
    public String precio;

    public Producto() {
    }

    public Producto(int id, String nombre, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
