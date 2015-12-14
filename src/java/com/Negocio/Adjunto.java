/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Adjunto {

    //Atributos
    private int idAdjunto;
    private String nombre;

    //Constructor
    public Adjunto()
    {

    }

    public Adjunto(int pIdAdjunto, String pNombre)
    {
        idAdjunto = pIdAdjunto;
        nombre = pNombre;
    }

    public Adjunto(String pNombre)
    {
        nombre = pNombre;
    }


    //Metodos Get y Set
    public int getIdAdjunto() {
        return idAdjunto;
    }

    public void setIdAdjunto(int idAdjunto) {
        this.idAdjunto = idAdjunto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
}
