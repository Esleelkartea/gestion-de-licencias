/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Negocio;

/**
 *
 * @author Julen
 */
public class Usuario {

    //Atributos
    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private String email;

    //Constructores
    public Usuario()
    {

    }

    public Usuario(String pNombre, String pApellidos, String pUsuario, String pPassword, String pEmail)
    {
        nombre = pNombre;
        apellidos = pApellidos;
        usuario = pUsuario;
        password = pPassword;
        email = pEmail;
    }

    public Usuario(int pIdUsuario, String pNombre, String pApellidos, String pUsuario, String pPassword, String pEmail)
    {
        nombre = pNombre;
        apellidos = pApellidos;
        usuario = pUsuario;
        password = pPassword;
        email = pEmail;
    }
   
    // Metodos Get y Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
