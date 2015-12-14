/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class FederadoDireccion {

    //Atributos
    private int idFederadoDireccion;
    private String calle;
    private String numero;
    private String escalera;
    private String piso;
    private String puerta;
    private String complemento;
    private String poblacion;
    private String cp;
    private String provincia;
    private TipoDireccion tipoDireccion;
    private int idFederado;


    //Constructor
    public FederadoDireccion()
    {

    }

    public FederadoDireccion(int pIdFederadoDireccion, String pCalle, String pNumero, String pEscalera, String pPiso, String pPuerta, String pComplemento, String pPoblacion, String pCP, String pProvincia, TipoDireccion pTipoDireccion, int pIdFederado)
    {
        idFederadoDireccion = pIdFederadoDireccion;
        calle = pCalle;
        numero = pNumero;
        escalera = pEscalera;
        piso = pPiso;
        puerta = pPuerta;
        complemento = pComplemento;
        poblacion = pPoblacion;
        cp = pCP;
        provincia = pProvincia;
        tipoDireccion = pTipoDireccion;
        idFederado = pIdFederado;
    }

    public FederadoDireccion(String pCalle, String pNumero, String pEscalera, String pPiso, String pPuerta, String pComplemento, String pPoblacion, String pCP, String pProvincia, TipoDireccion pTipoDireccion, int pIdFederado)
    {
        calle = pCalle;
        numero = pNumero;
        escalera = pEscalera;
        piso = pPiso;
        puerta = pPuerta;
        complemento = pComplemento;
        poblacion = pPoblacion;
        cp = pCP;
        provincia = pProvincia;
        tipoDireccion = pTipoDireccion;
        idFederado = pIdFederado;
    }

    
    //Metodos Get y Set
    public int getIdFederadoDireccion() {
        return idFederadoDireccion;
    }

    public void setIdFederadoDireccion(int idFederadoDireccion) {
        this.idFederadoDireccion = idFederadoDireccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getIdFederado() {
        return idFederado;
    }

    public void setIdFederado(int idFederado) {
        this.idFederado = idFederado;
    }

    public TipoDireccion getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(TipoDireccion tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEscalera() {
        return escalera;
    }

    public void setEscalera(String escalera) {
        this.escalera = escalera;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
