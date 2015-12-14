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
public class DEAlumno {

    //Atributos
    private int idDEAlumno;
    private String nombre;
    private String apellidos;
    private Date fechaNac;
    private String curso;
    private String nombreTutor;
    private String apellidosTutor;
    private String fijo;
    private String movil;
    private String email;


    //Constructor
    public DEAlumno()
    {

    }

    public DEAlumno(int pIdAlumno, String pNombre, String pApellidos, Date pFechaNac, String pCurso, String pNombreTutor, String pApellidosTutor, String pFijo, String pMovil, String pEmail)
    {
        idDEAlumno = pIdAlumno;
        nombre = pNombre;
        apellidos = pApellidos;
        fechaNac = pFechaNac;
        curso = pCurso;
        nombreTutor = pNombreTutor;
        apellidosTutor = pApellidosTutor;
        fijo = pFijo;
        movil = pMovil;
        email = pEmail;
    }

    public DEAlumno(String pNombre, String pApellidos, Date pFechaNac, String pCurso, String pNombreTutor, String pApellidosTutor, String pFijo, String pMovil, String pEmail)
    {
        nombre = pNombre;
        apellidos = pApellidos;
        fechaNac = pFechaNac;
        curso = pCurso;
        nombreTutor = pNombreTutor;
        apellidosTutor = pApellidosTutor;
        fijo = pFijo;
        movil = pMovil;
        email = pEmail;
    }


    //Metodos Get y Set
    public int getIdDEAlumno() {
        return idDEAlumno;
    }

    public void setIdDEAlumno(int idDEAlumno) {
        this.idDEAlumno = idDEAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getApellidosTutor() {
        return apellidosTutor;
    }

    public void setApellidosTutor(String apellidosTutor) {
        this.apellidosTutor = apellidosTutor;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }  

}
