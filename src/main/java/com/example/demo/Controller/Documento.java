/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findByIdDocumento", query = "SELECT d FROM Documento d WHERE d.idDocumento = :idDocumento")
    , @NamedQuery(name = "Documento.findByRutSolicitante", query = "SELECT d FROM Documento d WHERE d.rutSolicitante = :rutSolicitante")
    , @NamedQuery(name = "Documento.findByRutReceptor", query = "SELECT d FROM Documento d WHERE d.rutReceptor = :rutReceptor")
    , @NamedQuery(name = "Documento.findByRutTI", query = "SELECT d FROM Documento d WHERE d.rutTI = :rutTI")
    , @NamedQuery(name = "Documento.findByFechaSolicitud", query = "SELECT d FROM Documento d WHERE d.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Documento.findByFechaEntrega", query = "SELECT d FROM Documento d WHERE d.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Documento.findByFechaDevolucion", query = "SELECT d FROM Documento d WHERE d.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "Documento.findByEstado", query = "SELECT d FROM Documento d WHERE d.estado = :estado")
    , @NamedQuery(name = "Documento.findByTipoDocumento", query = "SELECT d FROM Documento d WHERE d.tipoDocumento = :tipoDocumento")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento")
    private Integer idDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_solicitante")
    private int rutSolicitante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_receptor")
    private int rutReceptor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_TI")
    private int rutTI;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_documento")
    private String tipoDocumento;

    public Documento() {
    }

    public Documento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Documento(Integer idDocumento, int rutSolicitante, int rutReceptor, int rutTI, Date fechaSolicitud, Date fechaEntrega, Date fechaDevolucion, String estado, String tipoDocumento) {
        this.idDocumento = idDocumento;
        this.rutSolicitante = rutSolicitante;
        this.rutReceptor = rutReceptor;
        this.rutTI = rutTI;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getRutSolicitante() {
        return rutSolicitante;
    }

    public void setRutSolicitante(int rutSolicitante) {
        this.rutSolicitante = rutSolicitante;
    }

    public int getRutReceptor() {
        return rutReceptor;
    }

    public void setRutReceptor(int rutReceptor) {
        this.rutReceptor = rutReceptor;
    }

    public int getRutTI() {
        return rutTI;
    }

    public void setRutTI(int rutTI) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.Controller.Documento[ idDocumento=" + idDocumento + " ]";
    }
    
}
