/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class TipoTelefono {

    //Atributos
    private int idTipoTelefono;
    private String tipo;

    //Constructor
    public TipoTelefono()
    {

    }

    public TipoTelefono(int pIdTipoTelefono, String pTipo)
    {
        idTipoTelefono = pIdTipoTelefono;
        tipo = pTipo;
    }

    public TipoTelefono(String pTipo)
    {
        tipo = pTipo;
    }

    //Metodos Get y Set
    public int getIdTipoTelefono() {
        return idTipoTelefono;
    }

    public void setIdTipoTelefono(int idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
