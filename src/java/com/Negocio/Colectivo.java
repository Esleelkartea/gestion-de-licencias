/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Colectivo {

    //Atributos
    private int idColectivo;
    private String nombre;
    private String descripcion;

    //Constructor
    public Colectivo()
    {

    }

    public Colectivo(int pIdColectivo, String pNombre, String pDescripcion)
    {
        idColectivo = pIdColectivo;
        nombre = pNombre;
        descripcion = pDescripcion;
    }

    public Colectivo(String pNombre, String pDescripcion)
    {
        nombre = pNombre;
        descripcion = pDescripcion;
    }


    //Metodos Get y Set
    public int getIdColectivo() {
        return idColectivo;
    }

    public void setIdColectivo(int idColectivo) {
        this.idColectivo = idColectivo;
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

}
