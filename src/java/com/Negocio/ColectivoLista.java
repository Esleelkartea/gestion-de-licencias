/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class ColectivoLista {

    //Atributos
    private int idColectivoLista;
    private Colectivo colectivo;
    private Federado federado;

    //Constructor
    public ColectivoLista()
    {

    }

    public ColectivoLista(int pIdColectivoLista, Colectivo pColectivo, Federado pFederado)
    {
        idColectivoLista = pIdColectivoLista;
        colectivo = pColectivo;
        federado = pFederado;
    }

    public ColectivoLista(Colectivo pColectivo, Federado pFederado)
    {
        colectivo = pColectivo;
        federado = pFederado;
    }


    //Metodos Get y Set
    public int getIdColectivoLista() {
        return idColectivoLista;
    }

    public void setIdColectivoLista(int idColectivoLista) {
        this.idColectivoLista = idColectivoLista;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Federado getFederado() {
        return federado;
    }

    public void setFederado(Federado federado) {
        this.federado = federado;
    }    
}
