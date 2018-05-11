/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "tipo_equipo")
public class TipoEquipo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_equipo;
    
    @NotNull
    private String nombre;

    public int getId_tipo_equipo() {
        return id_tipo_equipo;
    }

    public void setId_tipo_equipo(int id_tipo_equipo) {
        this.id_tipo_equipo = id_tipo_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
}
