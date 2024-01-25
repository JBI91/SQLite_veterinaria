package com.example.sqlite_veterinaria.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Perro {
    private long id, raza_id, propietario_id;
    private String nombre, comentarios;
    private boolean esMacho, estaVacunado;
   // private GregorianCalendar fecha_nacimiento;

    public Perro(long id, long raza_id, long propietario_id, String nombre, String comentarios, boolean esMacho, boolean estaVacunado) {
        this.id = id;
        this.raza_id = raza_id;
        this.propietario_id = propietario_id;
        this.nombre = nombre;
        this.comentarios = comentarios;
        this.esMacho = esMacho;
        this.estaVacunado = estaVacunado;

        // Convierte la cadena de fecha a GregorianCalendar
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date date = dateFormat.parse(String.valueOf(fecha_nacimiento));
            this.fecha_nacimiento = new GregorianCalendar();
            this.fecha_nacimiento.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRaza_id() {
        return raza_id;
    }

    public void setRaza_id(long raza_id) {
        this.raza_id = raza_id;
    }

    public long getPropietario_id() {
        return propietario_id;
    }

    public void setPropietario_id(long propietario_id) {
        this.propietario_id = propietario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public boolean isEsMacho() {
        return esMacho;
    }

    public void setEsMacho(boolean esMacho) {
        this.esMacho = esMacho;
    }

    public boolean isEstaVacunado() {
        return estaVacunado;
    }

    public void setEstaVacunado(boolean estaVacunado) {
        this.estaVacunado = estaVacunado;
    }

    /*public GregorianCalendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }*/

    /*public void setFecha_nacimiento(GregorianCalendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }*/

    @Override
    public String toString() {
        return "Perro{" +
                "id=" + id +
                ", raza_id=" + raza_id +
                ", propietario_id=" + propietario_id +
                ", nombre='" + nombre + '\'' +
                ", comentarios='" + comentarios + '\'' +
                ", esMacho=" + esMacho +
                ", estaVacunado=" + estaVacunado +
                '}';
    }
}
