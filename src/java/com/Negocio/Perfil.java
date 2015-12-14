/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Perfil {

    //Atributos
    private int idPerfil;
    private String nombre;
    private String descripcion;


    //Constructor
    public Perfil()
    {

    }

    public Perfil(int pIdPerfil, String pNombre, String pDescripcion)
    {
        idPerfil = pIdPerfil;
        nombre = pNombre;
        descripcion = pDescripcion;
    }

    public Perfil(String pNombre, String pDescripcion)
    {
        nombre = pNombre;
        descripcion = pDescripcion;
    }

   
    //Metodos Get y Set
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
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
