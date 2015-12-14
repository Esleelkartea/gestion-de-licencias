/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

import java.sql.Date;

/**
 *
 * @author Julen
 */
public class FederadoConsulta {

    //Atributos
    private int idFederadoConsulta;
    private Federado federado;
    private Consulta consulta;
    private Date fechaConsulta;
    private boolean pendiente;
    private String observaciones;

    //Constructor
    public FederadoConsulta()
    {

    }

    public FederadoConsulta(int pIdFederadoConsulta, Federado pFederado, Consulta pConsulta, Date pFecha, boolean pPendiente, String pObservaciones)
    {
        idFederadoConsulta = pIdFederadoConsulta;
        federado = pFederado;
        consulta = pConsulta;
        fechaConsulta = pFecha;
        pendiente = pPendiente;
        observaciones = pObservaciones;
    }

    public FederadoConsulta(Federado pFederado, Consulta pConsulta, Date pFecha, boolean pPendiente, String pObservaciones)
    {
        federado = pFederado;
        consulta = pConsulta;
        fechaConsulta = pFecha;
        pendiente = pPendiente;
        observaciones = pObservaciones;
    }


    //Metodos Get y Set
    public int getIdFederadoConsulta() {
        return idFederadoConsulta;
    }

    public void setIdFederadoConsulta(int idFederadoConsulta) {
        this.idFederadoConsulta = idFederadoConsulta;
    }
    
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Federado getFederado() {
        return federado;
    }

    public void setFederado(Federado federado) {
        this.federado = federado;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

}
