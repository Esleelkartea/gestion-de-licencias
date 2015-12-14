/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class TipoModificacion {

    //Atributos
    private int idTipoModificacion;
    private String nombre;

    //Constructor
    public TipoModificacion()
    {

    }

    public TipoModificacion(int pIdTipoModificacion, String pNombre)
    {
        idTipoModificacion = pIdTipoModificacion;
        nombre = pNombre;
    }

    public TipoModificacion(int pIdTipoModificacion)
    {
        idTipoModificacion = pIdTipoModificacion;
    }

    //Metodos Get y Set
    public int getIdTipoModificacion() {
        return idTipoModificacion;
    }

    public void setIdTipoModificacion(int idTipoModificacion) {
        this.idTipoModificacion = idTipoModificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    
}
