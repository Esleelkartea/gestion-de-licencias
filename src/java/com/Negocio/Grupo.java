/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Grupo {

    //Atributos
    private int idGrupo;
    private String letra;
    private String nombre;
    private String descripcion;

    //Constructor
    public Grupo()
    {

    }

    public Grupo(int pIdGrupo, String pLetra, String pNombre, String pDescripcion)
    {
        idGrupo = pIdGrupo;
        letra = pLetra;
        nombre = pNombre;
        descripcion = pDescripcion;
    }

    public Grupo(String pLetra, String pNombre, String pDescripcion)
    {
        letra = pLetra;
        nombre = pNombre;
        descripcion = pDescripcion;
    }


    //Metodos Get y Set
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

}
