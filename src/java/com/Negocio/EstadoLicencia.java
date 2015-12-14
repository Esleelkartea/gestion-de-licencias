/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class EstadoLicencia {

    //Atributos
    private int idEstadoLicencia;
    private String estado;

    //Constructor
    public EstadoLicencia()
    {

    }

    public EstadoLicencia(int pIdEstadoLicencia, String pEstado)
    {
        idEstadoLicencia = pIdEstadoLicencia;
        estado = pEstado;
    }

    public EstadoLicencia(String pEstado)
    {
        estado = pEstado;
    }

    //Metodos Get y Set
    public int getIdEstadoLicencia() {
        return idEstadoLicencia;
    }

    public void setIdEstadoLicencia(int idEstadoLicencia) {
        this.idEstadoLicencia = idEstadoLicencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
