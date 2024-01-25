package com.example.sqlite_veterinaria.Model;

public class Raza {
    private long id;
    private String nombre, caracteristicas;

    public Raza(long id, String nombre, String caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "Raza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                '}';
    }
}
