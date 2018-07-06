/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
//	tmp_usuario
@Entity
@Table(name = "tmp_usuario")
public class UsuarioExterno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    
    private String email;
    
    private String passwer;
    
    @Column(name="last_name")
    private String lastName;
    
    private String name;
    
    
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    
    @Column(name= "idnacional")
    private String idNacional;
    
    private String estado;
    
    private String departamento;
    
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String Departamento) {
        this.departamento = Departamento;
    }
    
    
    
}