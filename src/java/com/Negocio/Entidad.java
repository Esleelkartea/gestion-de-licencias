/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Entidad {

    //Atributos
    private int idEntidad;
    private String codigo;
    private String desCastellano;
    private String desEuskera;
    private String email;

    //Constructores
    public Entidad()
    {

    }

    public Entidad(int pIdEntidad, String pCodigo, String pCastellano, String pEuskera, String pEmail)
    {
        idEntidad = pIdEntidad;
        codigo = pCodigo;
        desCastellano = pCastellano;
        desEuskera = pEuskera;
        email = pEmail;
    }

    public Entidad(String pCodigo, String pCastellano, String pEuskera, String pEmail)
    {
        codigo = pCodigo;
        desCastellano = pCastellano;
        desEuskera = pEuskera;
        email = pEmail;
    }

    //Metodos Get y Set
    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesCastellano() {
        return desCastellano;
    }

    public void setDesCastellano(String desCastellano) {
        this.desCastellano = desCastellano;
    }

    public String getDesEuskera() {
        return desEuskera;
    }

    public void setDesEuskera(String desEuskera) {
        this.desEuskera = desEuskera;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
