/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class FederadoColectivo {

    //Atributos
    private int idFederadoColectivo;
    private Federado federado;
    private Colectivo colectivo;
    private String observaciones;

    //Constructor
    public FederadoColectivo()
    {

    }

    public FederadoColectivo(int pIdFederadoColectivo, Federado pFederado, Colectivo pColectivo, String pObservaciones)
    {
        idFederadoColectivo = pIdFederadoColectivo;
        federado = pFederado;
        colectivo = pColectivo;
        observaciones = pObservaciones;
    }

    public FederadoColectivo(Federado pFederado, Colectivo pColectivo, String pObservaciones)
    {
        federado = pFederado;
        colectivo = pColectivo;
        observaciones = pObservaciones;
    }


    //Metodos Get y Set
    public int getIdFederadoColectivo() {
        return idFederadoColectivo;
    }

    public void setIdFederadoColectivo(int idFederadoColectivo) {
        this.idFederadoColectivo = idFederadoColectivo;
    }

    public Federado getFederado() {
        return federado;
    }

    public void setFederado(Federado federado) {
        this.federado = federado;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
