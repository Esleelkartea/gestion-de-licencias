/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class FederadoTelefono {

    //Atributos
    private int idTelefono;
    private String telefono;
    private TipoTelefono tipoTelefono;
    private int idFederado;

    //Constructor
    public FederadoTelefono()
    {

    }

    public FederadoTelefono(int pIdTelefono, String pTelefono, TipoTelefono pTipoTelefono, int pIdFederado)
    {
        idTelefono = pIdTelefono;
        telefono = pTelefono;
        tipoTelefono = pTipoTelefono;
        idFederado = pIdFederado;
    }

    public FederadoTelefono(String pTelefono, TipoTelefono pTipoTelefono, int pIdFederado)
    {
        telefono = pTelefono;
        tipoTelefono = pTipoTelefono;
        idFederado = pIdFederado;
    }

    //Metodos Get y Set
    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdFederado() {
        return idFederado;
    }

    public void setIdFederado(int idFederado) {
        this.idFederado = idFederado;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }
  
    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

}
