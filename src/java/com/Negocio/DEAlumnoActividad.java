/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class DEAlumnoActividad {

    //Atributos
    private int idDEAlumnoActividad;
    private int idDEAlumno;
    private int idDEActividad;

    //Constructor
    public DEAlumnoActividad()
    {

    }

    public DEAlumnoActividad(int pIdDEAlumnoActividad, int pIdDEAlumno, int pIdDEActividad)
    {
        idDEAlumnoActividad = pIdDEAlumnoActividad;
        idDEAlumno = pIdDEAlumno;
        idDEActividad = pIdDEActividad;
    }

    public DEAlumnoActividad(int pIdDEAlumno, int pIdDEActividad)
    {
        idDEAlumno = pIdDEAlumno;
        idDEActividad = pIdDEActividad;
    }

    //Metodos Get y Set
    public int getIdDEAlumnoActividad() {
        return idDEAlumnoActividad;
    }
 
    public void setIdDEAlumnoActividad(int idDEAlumnoActividad) {
        this.idDEAlumnoActividad = idDEAlumnoActividad;
    }

    public int getIdDEAlumno() {
        return idDEAlumno;
    }

    public void setIdDEAlumno(int idDEAlumno) {
        this.idDEAlumno = idDEAlumno;
    }

    public int getIdDEActividad() {
        return idDEActividad;
    }

    public void setIdDEActividad(int idDEActividad) {
        this.idDEActividad = idDEActividad;
    }

}
