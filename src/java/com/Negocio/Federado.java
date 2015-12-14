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
public class Federado {

    //Atributos
    private int idFederado;
    private String numFederado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private Date fechaNac;
    private String sexo;
    private String nacionalidad;
    private boolean residente;
    private boolean tutor;
    private String tutorTipo;
    private String tutorNombre;
    private String tutorApellido1;
    private String tutorApellido2;
    private String dniTutor;

    private String tutorNumFederado;

    private boolean handicap;
    private double numHandicap;
    private String formaPago;
    private String numCuenta;
    private boolean nota1;
    private boolean nota2;
    private boolean nota3;
    private int idEntidad;
    private int estadoLicencia;
    private int estadoEconomico;


    private Date fechaPreAlta;
    private Date fechaAlta;
    private Date fechaBaja;
    private int razonBaja;

    private boolean homolagada;
   

    //Constructor
    public Federado()
    {

    }

    
    public Federado(int pIdFederado, String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI, Date pFechaNac, String pSexo, String pNacionalidad, boolean pResidente, boolean pTutor, String pTutorTipo, String pTutorNombre, String pTutorApellido1, String pTutorApellido2, String pTutorDNI, boolean pHandicap, double pNumHandicap, String pFormaPago, String pNumCuenta, boolean pNota1, boolean pNota2, boolean pNota3, int pIdEntidad, int pEstadoEconomico, int pEstadoLicencia, Date pFechaPreAlta, Date pFechaAlta, Date pFechaBaja, int pRazonBaja, boolean pHomologada, String pTutorNumFederado)
    {
        idFederado = pIdFederado;
        numFederado = pNumFederado;
        nombre = pNombre;
        apellido1 = pApellido1;
        apellido2 = pApellido2;
        dni = pDNI;
        fechaNac = pFechaNac;
        sexo = pSexo;
        nacionalidad = pNacionalidad;
        residente = pResidente;
        tutor = pTutor;
        tutorTipo = pTutorTipo;
        tutorNombre = pTutorNombre;
        tutorApellido1 = pTutorApellido1;
        tutorApellido2 = pTutorApellido2;
        dniTutor = pTutorDNI;
        tutorNumFederado = pTutorNumFederado;
        handicap = pHandicap;
        numHandicap = pNumHandicap;
        formaPago = pFormaPago;
        numCuenta = pNumCuenta;
        nota1 = pNota1;
        nota2 = pNota2;
        nota3 = pNota3;

        idEntidad = pIdEntidad;
        estadoLicencia = pEstadoLicencia;
        estadoEconomico = pEstadoEconomico;

        fechaPreAlta = pFechaPreAlta;
        fechaAlta = pFechaAlta;
        fechaBaja = pFechaBaja;
        razonBaja = pRazonBaja;

        homolagada = pHomologada;

    }

    //Prueba
    public Federado(String pNombre, String pApellido1, String pApellido2, String pDNI, Date pFechaNac, String pSexo)
    {
        nombre = pNombre;
        apellido1 = pApellido1;
        apellido2 = pApellido2;
        dni = pDNI;
        fechaNac = pFechaNac;
    }
    //Fin Prueba

    public Federado(String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI, Date pFechaNac, String pSexo, String pNacionalidad, boolean pResidente, boolean pTutor, String pTutorTipo, String pTutorNombre, String pTutorApellido1, String pTutorApellido2, String pTutorDNI, boolean pHandicap, double pNumHandicap, String pFormaPago, String pNumCuenta, boolean pNota1, boolean pNota2, boolean pNota3, int pIdEntidad, int pEstadoEconomico, int pEstadoLicencia, Date pFechaPreAlta, Date pFechaAlta, Date pFechaBaja, int pRazonBaja, boolean pHomologada, String pTutorNumFederado)
    {
        nombre = pNombre;
        numFederado = pNumFederado;
        apellido1 = pApellido1;
        apellido2 = pApellido2;
        dni = pDNI;
        fechaNac = pFechaNac;
        sexo = pSexo;
        nacionalidad = pNacionalidad;
        residente = pResidente;
        tutor = pTutor;
        tutorTipo = pTutorTipo;
        tutorNombre = pTutorNombre;
        tutorApellido1 = pTutorApellido1;
        tutorApellido2 = pTutorApellido2;
        dniTutor = pTutorDNI;
        tutorNumFederado = pTutorNumFederado;
        handicap = pHandicap;
        numHandicap = pNumHandicap;
        formaPago = pFormaPago;
        numCuenta = pNumCuenta;
        nota1 = pNota1;
        nota2 = pNota2;
        nota3 = pNota3;

        idEntidad = pIdEntidad;
        estadoLicencia = pEstadoLicencia;
        estadoEconomico = pEstadoEconomico;

        fechaPreAlta = pFechaPreAlta;
        fechaAlta = pFechaAlta;
        fechaBaja = pFechaBaja;
        razonBaja = pRazonBaja;

        homolagada = pHomologada;

    }


    //Metodos Get y Set
    public int getIdFederado() {
        return idFederado;
    }

    public void setIdFederado(int idFederado) {
        this.idFederado = idFederado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isResidente() {
        return residente;
    }

    public void setResidente(boolean residente) {
        this.residente = residente;
    }

    public boolean isTutor() {
        return tutor;
    }

    public void setTutor(boolean tutor) {
        this.tutor = tutor;
    }

    public String getTutorTipo() {
        return tutorTipo;
    }

    public void setTutorTipo(String tutorTipo) {
        this.tutorTipo = tutorTipo;
    }

    public String getTutorNombre() {
        return tutorNombre;
    }

    public void setTutorNombre(String tutorNombre) {
        this.tutorNombre = tutorNombre;
    }

    public String getTutorApellido1() {
        return tutorApellido1;
    }

    public void setTutorApellido1(String tutorApellido1) {
        this.tutorApellido1 = tutorApellido1;
    }

    public String getTutorApellido2() {
        return tutorApellido2;
    }

    public void setTutorApellido2(String tutorApellido2) {
        this.tutorApellido2 = tutorApellido2;
    }

    public String getDniTutor() {
        return dniTutor;
    }

    public void setDniTutor(String dniTutor) {
        this.dniTutor = dniTutor;
    }

    public boolean isHandicap() {
        return handicap;
    }

    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    public double getNumHandicap() {
        return numHandicap;
    }

    public void setNumHandicap(double numHandicap) {
        this.numHandicap = numHandicap;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public boolean isNota1() {
        return nota1;
    }

    public void setNota1(boolean nota1) {
        this.nota1 = nota1;
    }

    public boolean isNota2() {
        return nota2;
    }

    public void setNota2(boolean nota2) {
        this.nota2 = nota2;
    }

    public boolean isNota3() {
        return nota3;
    }

    public void setNota3(boolean nota3) {
        this.nota3 = nota3;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public int getEstadoLicencia() {
        return estadoLicencia;
    }

    public void setEstadoLicencia(int estadoLicencia) {
        this.estadoLicencia = estadoLicencia;
    }

    public int getEstadoEconomico() {
        return estadoEconomico;
    }

    public void setEstadoEconomico(int estadoEconomico) {
        this.estadoEconomico = estadoEconomico;
    }

    public String getNumFederado() {
        return numFederado;
    }

    public void setNumFederado(String numFederado) {
        this.numFederado = numFederado;
    }

    public Date getFechaPreAlta() {
        return fechaPreAlta;
    }

    public void setFechaPreAlta(Date fechaPreAlta) {
        this.fechaPreAlta = fechaPreAlta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getRazonBaja() {
        return razonBaja;
    }

    public void setRazonBaja(int razonBaja) {
        this.razonBaja = razonBaja;
    }

    public boolean isHomolagada() {
        return homolagada;
    }

    public void setHomolagada(boolean homolagada) {
        this.homolagada = homolagada;
    }

    public String getTutorNumFederado() {
        return tutorNumFederado;
    }

    public void setTutorNumFederado(String tutorNumFederado) {
        this.tutorNumFederado = tutorNumFederado;
    }
 

}
