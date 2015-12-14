/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class PlantillaSMS {

    //Atributos
    private int idPlantillaSMS;
    private String nombre;
    private String texto;


    //Constructor
    public PlantillaSMS()
    {

    }

    public PlantillaSMS(int pIdPlantillaSMS, String pNombre, String pTexto)
    {
        idPlantillaSMS = pIdPlantillaSMS;
        nombre = pNombre;
        texto = pTexto;
    }

    public PlantillaSMS(String pNombre, String pTexto)
    {
        nombre = pNombre;
        texto = pTexto;
    }


    //Metodos Get y Set
    public int getIdPlantillaSMS() {
        return idPlantillaSMS;
    }

    public void setIdPlantillaSMS(int idPlantillaSMS) {
        this.idPlantillaSMS = idPlantillaSMS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
