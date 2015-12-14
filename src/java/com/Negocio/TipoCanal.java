/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class TipoCanal {

    //Atributos
    private int idTipoCanal;
    private String nombre;
    private String descripcion;

    //Constructor
    public TipoCanal()
    {

    }

    public TipoCanal(int pIdTipoCanal, String pNombre, String pDescripcion)
    {
        idTipoCanal = pIdTipoCanal;
        nombre = pNombre;
        descripcion = pDescripcion;
    }

    public TipoCanal(String pNombre, String pDescripcion)
    {
        nombre = pNombre;
        descripcion = pDescripcion;
    }


    //Metodos Get y Set
    public int getIdTipoCanal() {
        return idTipoCanal;
    }

    public void setIdTipoCanal(int idTipoCanal) {
        this.idTipoCanal = idTipoCanal;
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
