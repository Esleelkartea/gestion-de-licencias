/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class TipoBaja {

    //Atributos
    private int idTipoBaja;
    private String razon;

    //Constructor
    public TipoBaja()
    {

    }

    public TipoBaja(int pIdTipoBaja, String pRazon)
    {
        idTipoBaja = pIdTipoBaja;
        razon = pRazon;
    }
    
    public TipoBaja(String pRazon)
    {
        razon = pRazon;
    }

    
    //Metodos Get y Set
    public int getIdTipoBaja() {
        return idTipoBaja;
    }

    public void setIdTipoBaja(int idTipoBaja) {
        this.idTipoBaja = idTipoBaja;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
 
}
