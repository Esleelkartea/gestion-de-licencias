/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Consulta {

    //Atributos
    private int idConsulta;
    private String consulta;
    private String descripcion;


    //Constructor
    public Consulta()
    {
        
    }

    public Consulta(int pIdConsulta, String pConsulta, String pDescripcion)
    {
        idConsulta = pIdConsulta;
        consulta = pConsulta;
        descripcion = pDescripcion;
    }

    public Consulta(String pConsulta, String pDescripcion)
    {
        consulta = pConsulta;
        descripcion = pDescripcion;
    }


    //Metodos Get y Set
    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
