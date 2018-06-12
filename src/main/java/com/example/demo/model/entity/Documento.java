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
@Entity
@Table(name = "documento")
public class Documento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "rut_solicitante")
    private  int rutSolicitante;
    
    @Column(name = "rut_receptor")
    private  String rut_receptor;
    
    @Column(name = "rut_TI")
    private  int rut_TI;
    
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private  Date fecha_solicitud;
 
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private  Date fecha_entrega;
    
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private  Date fecha_devolucion;
    
    @Column(name = "estado")
    private  int estado;
    
    @Column(name = "tipo_documento")
    private  String tipo_documento;
    
    @Column(name = "id_equipo")
    private  int id_equipo;
    
}
