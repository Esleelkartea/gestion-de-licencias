/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class TipoEmail {

    //Atributos
    private int idTipoEmail;
    private String tipo;

    //Constructor
    public TipoEmail()
    {

    }

    public TipoEmail(int pIdTipoEmail, String pTipo)
    {
        idTipoEmail = pIdTipoEmail;
        tipo = pTipo;
    }

    public TipoEmail(String pTipo)
    {
        tipo = pTipo;
    }

    //Metodos Get y Set
    public int getIdTipoEmail() {
        return idTipoEmail;
    }

    public void setIdTipoEmail(int idTipoEmail) {
        this.idTipoEmail = idTipoEmail;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
