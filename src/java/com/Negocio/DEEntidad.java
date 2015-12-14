/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class DEEntidad {

    //Atributos
    private int idDEEntidad;
    private String entidad;
    private int numEntidad;


    //Constructor
    public DEEntidad()
    {

    }

    public DEEntidad(int pIdDEEntidad, String pEntidad, int pNumEntidad)
    {
        idDEEntidad = pIdDEEntidad;
        entidad = pEntidad;
        numEntidad = pNumEntidad;
    }

    public DEEntidad(String pEntidad, int pNumEntidad)
    {
        entidad = pEntidad;
        numEntidad = pNumEntidad;
    }


    //Metodos Get y Set
    public int getIdDEEntidad() {
        return idDEEntidad;
    }

    public void setIdDEEntidad(int idDEEntidad) {
        this.idDEEntidad = idDEEntidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public int getNumEntidad() {
        return numEntidad;
    }

    public void setNumEntidad(int numEntidad) {
        this.numEntidad = numEntidad;
    }

}
