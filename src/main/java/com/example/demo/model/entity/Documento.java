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
    private  String rutReceptor;
    
    @Column(name = "rut_TI")
    private  String rutTI;
    
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private  Date fechaSolicitud;
 
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private  Date fechaEntrega;
    
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private  Date fechaDevolucion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private  EstadoDocumento estado;
    
    @Column(name = "tipo_documento")
    private  String tipoDocumento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private  Equipo equipo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_Equipo")
    private  TipoEquipo tipoEquipo;
    
    public Documento(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRutSolicitante() {
        return rutSolicitante;
    }

    public void setRutSolicitante(Integer rutSolicitante) {
        this.rutSolicitante = rutSolicitante;
    }

    public String getRutReceptor() {
        return rutReceptor;
    }

    public void setRutReceptor(String rutReceptor) {
        this.rutReceptor = rutReceptor;
    }

    public String getRutTI() {
        return rutTI;
    }

    public void setRutTI(String rutTI) {
        this.rutTI = rutTI;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }
    
    
    
    
}
