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
public class DEResponsable {

    //Atributos
    private int idDEResponsable;
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNac;
    private String direccion;
    private String poblacion;
    private String pais;
    private String cp;
    private String provincia;
    private String fijo;
    private String movil;
    private String email;
    

    //Constructor
    public DEResponsable()
    {

    }

    public DEResponsable(int pIdDEResponsable, String pDNI, String pNombre, String pApellidos, Date pFechaNac, String pDireccion, String pPoblacion, String pCP, String pProvincia, String pFijo, String pMovil, String pEmail)
    {
        idDEResponsable = pIdDEResponsable;
        dni = pDNI;
        nombre = pNombre;
        apellidos = pApellidos;
        fechaNac = pFechaNac;
        direccion = pDireccion;
        poblacion = pPoblacion;
        cp = pCP;
        provincia = pProvincia;
        fijo = pFijo;
        movil = pMovil;
        email = pEmail;
    }

    public DEResponsable(String pDNI, String pNombre, String pApellidos, Date pFechaNac, String pDireccion, String pPoblacion, String pCP, String pProvincia, String pFijo, String pMovil, String pEmail)
    {
        dni = pDNI;
        nombre = pNombre;
        apellidos = pApellidos;
        fechaNac = pFechaNac;
        direccion = pDireccion;
        poblacion = pPoblacion;
        cp = pCP;
        provincia = pProvincia;
        fijo = pFijo;
        movil = pMovil;
        email = pEmail;
    }



    //Metodos Get y Set
    public int getIdDEResponsable() {
        return idDEResponsable;
    }

    public void setIdDEResponsable(int idDEResponsable) {
        this.idDEResponsable = idDEResponsable;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
