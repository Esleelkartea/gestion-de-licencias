/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class DECurso {

    //Atributos
    private int idCurso;
    private String nombre;

    //Constructor
    public DECurso()
    {

    }

    public DECurso(int pIdCurso, String pNombre)
    {
        idCurso = pIdCurso;
        nombre = pNombre;
    }

    public DECurso(String pNombre)
    {
        nombre = pNombre;
    }



    //Metodos Get y Set
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

}
