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
public class DEActividad {

    //Atributos
    private int idDEActividad;
    private DEResponsable responsable;
    private DECurso curso;
    private DEEntidad entidad;
    private String temporada;
    private Date fechaInicio;
    private Date fechaFin;

    //Constructor
    public DEActividad()
    {

    }

    public DEActividad(int pIdDEActividad, DEResponsable pResponsable, DECurso pCurso, DEEntidad pEntidad, String pTemporada, Date pFechaInicio, Date pFechaFin)
    {
        idDEActividad = pIdDEActividad;
        responsable = pResponsable;
        curso = pCurso;
        entidad = pEntidad;
        temporada = pTemporada;
        fechaInicio = pFechaInicio;
        fechaFin = pFechaFin;
    }

    public DEActividad(DEResponsable pResponsable, DECurso pCurso, DEEntidad pEntidad, String pTemporada, Date pFechaInicio, Date pFechaFin)
    {
        responsable = pResponsable;
        curso = pCurso;
        entidad = pEntidad;
        temporada = pTemporada;
        fechaInicio = pFechaInicio;
        fechaFin = pFechaFin;
    }

    
    //Metodos Get y Set
    public int getIdDEActividad() {
        return idDEActividad;
    }

    public void setIdDEActividad(int idDEActividad) {
        this.idDEActividad = idDEActividad;
    }

    public DEResponsable getResponsable() {
        return responsable;
    }

    public void setResponsable(DEResponsable responsable) {
        this.responsable = responsable;
    }

    public DECurso getCurso() {
        return curso;
    }

    public void setCurso(DECurso curso) {
        this.curso = curso;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public DEEntidad getEntidad() {
        return entidad;
    }

    public void setEntidad(DEEntidad entidad) {
        this.entidad = entidad;
    }

}
