/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class TipoDireccion {

    //Atributos
    private int idTipoDireccion;
    private String tipo;

    //Constructor
    public TipoDireccion()
    {

    }

    public TipoDireccion(int pIdTipoDireccion, String pTipo)
    {
        idTipoDireccion = pIdTipoDireccion;
        tipo = pTipo;
    }

    public TipoDireccion(String pTipo)
    {
        tipo = pTipo;
    }

    
    //Metodos Get y Set
    public int getIdTipoDireccion() {
        return idTipoDireccion;
    }

    public void setIdTipoDireccion(int idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
