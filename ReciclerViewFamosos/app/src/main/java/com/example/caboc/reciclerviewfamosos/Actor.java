package com.example.caboc.reciclerviewfamosos;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by caboc on 30/01/2017.
 */

public class Actor implements Serializable{

    String nombre;
    String descripcion;
    String fNacimiento;
    String pais;
    String altura;
    String pareja;
    String hijos;
    String urlImagen;
    Bitmap imagen;



    public Actor(String nombre, String descripcion, String fNacimiento, String pais, String altura, String pareja, String hijos, String urlImagen, Bitmap imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fNacimiento = fNacimiento;
        this.pais = pais;
        this.altura = altura;
        this.pareja = pareja;
        this.hijos = hijos;
        this.urlImagen = urlImagen;
        this.imagen = imagen;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPareja() {
        return pareja;
    }

    public void setPareja(String pareja) {
        this.pareja = pareja;
    }

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public void imprimir(){
        String texto = "nombre "+this.nombre+" descripcion "+this.descripcion+" cumple "+fNacimiento+" altura "+altura+" pareja "+pareja+ " hijos "+ hijos +" urlimagen "+urlImagen;
        Log.d("prueba",texto);
    }
}
