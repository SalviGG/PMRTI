/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.entity;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class UsuarioExterno {
    
    private int idUsuario;
    private String email;
    private String passwer;
    private String lastName;
    private String name;
    private Date birthdate;
    private String idNacional;
    private String estado;
    
    public UsuarioExterno(){
        
    }   

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswer() {
        return passwer;
    }

    public void setPasswer(String passwer) {
        this.passwer = passwer;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getIdNacional() {
        return idNacional;
    }

    public void setIdNacional(String idNacional) {
        this.idNacional = idNacional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}