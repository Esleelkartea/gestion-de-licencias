/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class PlantillaEmail {

    //Atributos
    private int idPlantillaEmail;
    private String nombre;
    private String fichero;

    //Constructores
    public PlantillaEmail()
    {

    }

    public PlantillaEmail(int pIdPlantillaEmail, String pNombre, String pFichero)
    {
        idPlantillaEmail = pIdPlantillaEmail;
        nombre = pNombre;
        fichero = pFichero;
    }

    public PlantillaEmail(String pNombre, String pFichero)
    {
        nombre = pNombre;
        fichero = pFichero;
    }

    //Metodos Get y Set
    public int getIdPlantillaEmail() {
        return idPlantillaEmail;
    }

    public void setIdPlantillaEmail(int idPlantillaEmail) {
        this.idPlantillaEmail = idPlantillaEmail;
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
