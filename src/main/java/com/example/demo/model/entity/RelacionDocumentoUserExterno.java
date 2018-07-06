/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.entity;

/**
 *
 * @author usuario
 */
public class RelacionDocumentoUserExterno {
    
    private Documento doc;
    
    private UsuarioExterno solicitante;
    private UsuarioExterno ti;
    private UsuarioExterno receptor;
    
    public RelacionDocumentoUserExterno(){
    
    }

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }

    public UsuarioExterno getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(UsuarioExterno solicitante) {
        this.solicitante = solicitante;
    }

    public UsuarioExterno getTi() {
        return ti;
    }

    public void setTi(UsuarioExterno ti) {
        this.ti = ti;
    }

    public UsuarioExterno getReceptor() {
        return receptor;
    }

    public void setReceptor(UsuarioExterno receptor) {
        this.receptor = receptor;
    }
    
    
    
}
