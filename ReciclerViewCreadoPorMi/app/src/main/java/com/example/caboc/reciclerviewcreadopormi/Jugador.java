package com.example.caboc.reciclerviewcreadopormi;

/**
 * Created by caboc on 07/11/2016.
 */
public class Jugador {

    private int imagen;
    private int imagenEquipo;
    private String nombre;
    private String equipo;
    private String descripcion;
    private int posicion;
    int color;


    public int getPosicion() {
        return posicion;
    }

    public Jugador(int i, String n, String e, int c, String desc, int imagenE){

        this.imagen = i;
        this.nombre = n;
        this.equipo = e;
        this.color = c;
        this.descripcion = desc;
        this.imagenEquipo = imagenE;
        posicion = 0;

    }
    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImagen() {

        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getColor() {
        return color;
    }

    public int getImagenEquipo() {
        return imagenEquipo;
    }

    public void setImagenEquipo(int imagenEquipo) {
        this.imagenEquipo = imagenEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
