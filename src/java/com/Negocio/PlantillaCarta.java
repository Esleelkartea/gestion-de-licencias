/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class PlantillaCarta {

    //Atributos
    private int idPlantillaCarta;
    private String nombre;
    private String fichero;

    //Constructores
    public PlantillaCarta()
    {

    }

    public PlantillaCarta(int pIdPlantillaCarta, String pNombre, String pFichero)
    {
        idPlantillaCarta = pIdPlantillaCarta;
        nombre = pNombre;
        fichero = pFichero;
    }

    public PlantillaCarta(String pNombre, String pFichero)
    {
        nombre = pNombre;
        fichero = pFichero;
    }

    //Metodos Get y Set
    public int getIdPlantillaCarta() {
        return idPlantillaCarta;
    }

    public void setIdPlantillaCarta(int idPlantillaCarta) {
        this.idPlantillaCarta = idPlantillaCarta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

}
