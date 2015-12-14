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
public class Historial {

    //Atributos
    private int idHistorial;
    private String campo;
    private String valorAntiguo;
    private String valorNuevo;
    private Date fecha;
    private Usuario usuario;
    private TipoCanal tipoCanal;


    //Constructor
    public Historial()
    {

    }

    public Historial(int pIdHistorial, String pCampo, String pValorAntiguo, String pValorNuevo, Date pFecha, Usuario pUsuario, TipoCanal pTipoCanal)
    {
        idHistorial = pIdHistorial;
        campo = pCampo;
        valorAntiguo = pValorAntiguo;
        valorNuevo = pValorNuevo;
        fecha = pFecha;
        usuario = pUsuario;
        tipoCanal = pTipoCanal;
    }

    public Historial(String pCampo, String pValorAntiguo, String pValorNuevo, Date pFecha, Usuario pUsuario, TipoCanal pTipoCanal)
    {
        campo = pCampo;
        valorAntiguo = pValorAntiguo;
        valorNuevo = pValorNuevo;
        fecha = pFecha;
        usuario = pUsuario;
        tipoCanal = pTipoCanal;
    }


    //Metodos Get y Set
    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getValorAntiguo() {
        return valorAntiguo;
    }

    public void setValorAntiguo(String valorAntiguo) {
        this.valorAntiguo = valorAntiguo;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoCanal getTipoCanal() {
        return tipoCanal;
    }

    public void setTipoCanal(TipoCanal tipoCanal) {
        this.tipoCanal = tipoCanal;
    }

}
