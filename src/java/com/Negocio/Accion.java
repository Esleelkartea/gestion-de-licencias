/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Accion {

    //Atributos
    private int idAccion;
    private String nombre;

    //Constructores
    public Accion()
    {

    }

    public Accion(int pIdAccion, String pNombre)
    {
        idAccion = pIdAccion;
        nombre = pNombre;
    }

    public Accion(String pNombre)
    {
        nombre = pNombre;
    }

    //Metodos Get y Set
    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
