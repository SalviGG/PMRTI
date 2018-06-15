/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "id_documento")
    private int id;
    
    @Column(name = "rut_solicitante")
    private  Integer rutSolicitante;
    
    @Column(name = "rut_receptor")
    private  String rut_receptor;
    
    @Column(name = "rut_TI")
    private  String rut_TI;
    
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private  Date fechaSolicitud;
 
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private  Date fecha_entrega;
    
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private  Date fecha_devolucion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private  EstadoDocumento estado;
    
    @Column(name = "tipo_documento")
    private  String tipoDocumento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private  Equipo equipo;
    
    public Documento(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRutSolicitante() {
        return rutSolicitante;
    }

    public void setRutSolicitante(int rutSolicitante) {
        this.rutSolicitante = rutSolicitante;
    }

    public String getRut_receptor() {
        return rut_receptor;
    }

    public void setRut_receptor(String rut_receptor) {
        this.rut_receptor = rut_receptor;
    }

    public String getRut_TI() {
        return rut_TI;
    }

    public void setRut_TI(String rut_TI) {
        this.rut_TI = rut_TI;
    }

    public Date getFecha_solicitud() {
        return fechaSolicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fechaSolicitud = fecha_solicitud;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public EstadoDocumento getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocumento estado) {
        this.estado = estado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
}
