/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class EstadoEconomico {

      //Atributos
    private int idEstadoEconomico;
    private String estado;
    private int numDias;

    //Constructores
    public EstadoEconomico()
    {

    }

    public EstadoEconomico(int pIdEstadoEconomico, String pEstado, int pNumDias)
    {
        idEstadoEconomico = pIdEstadoEconomico;
        estado = pEstado;
        numDias = pNumDias;
    }

    public EstadoEconomico(String pEstado, int pNumDias)
    {
        estado = pEstado;
        numDias = pNumDias;
    }

    //Metodos Get y Set
    public int getIdEstadoEconomico() {
        return idEstadoEconomico;
    }

    public void setIdEstadoEconomico(int idEstadoEconomico) {
        this.idEstadoEconomico = idEstadoEconomico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

}
