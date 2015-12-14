/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class FederadoEmail {

    //Atributos
    private int idEmail;
    private String email;
    private TipoEmail tipoEmail;
    private int idFederado;

    //Constructor
    public FederadoEmail()
    {

    }

    public FederadoEmail(int pIdEmail, String pEmail, TipoEmail pTipoEmail, int pIdFederado)
    {
        idEmail = pIdEmail;
        email = pEmail;
        tipoEmail = pTipoEmail;
        idFederado = pIdFederado;
    }

    public FederadoEmail(String pEmail, TipoEmail pTipoEmail, int pIdFederado)
    {
        email = pEmail;
        tipoEmail = pTipoEmail;
        idFederado = pIdFederado;
    }

    //Metodos Get y Set
    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoEmail getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(TipoEmail tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public int getIdFederado() {
        return idFederado;
    }

    public void setIdFederado(int idFederado) {
        this.idFederado = idFederado;
    }

}
