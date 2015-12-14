/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Categoria {

    //Atributos
    private int idCategoria;
    private String codigo;
    private String nomCastellano;
    private String nomEuskera;
    private int edadMinima;
    private int edadMaxima;


    //Constructor
    public Categoria()
    {

    }

    public Categoria(int pIdCategoria, String pCodigo, String pCastellano, String pEuskera, int pEdadMinima, int pEdadMaxima)
    {
        idCategoria = pIdCategoria;
        codigo = pCodigo;
        nomCastellano = pCastellano;
        nomEuskera = pEuskera;
        edadMinima = pEdadMinima;
        edadMaxima = pEdadMaxima;
    }

    public Categoria(String pCodigo, String pCastellano, String pEuskera, int pEdadMinima, int pEdadMaxima)
    {
        codigo = pCodigo;
        nomCastellano = pCastellano;
        nomEuskera = pEuskera;
        edadMinima = pEdadMinima;
        edadMaxima = pEdadMaxima;
    }


    //Metodos Get y Set
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomCastellano() {
        return nomCastellano;
    }

    public void setNomCastellano(String nomCastellano) {
        this.nomCastellano = nomCastellano;
    }

    public String getNomEuskera() {
        return nomEuskera;
    }

    public void setNomEuskera(String nomEuskera) {
        this.nomEuskera = nomEuskera;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }
  

}
