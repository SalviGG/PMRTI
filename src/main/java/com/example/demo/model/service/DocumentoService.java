/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.entity.Documento;
import com.example.demo.model.entity.RelacionDocumentoUserExterno;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface DocumentoService {
    public List<Documento> findAll();
    public List<RelacionDocumentoUserExterno> findAllWithRelacion();
    public List<RelacionDocumentoUserExterno> findAllWithRelacionForSolicitante(String rutSolicitante, String tipDoc);
    public List<RelacionDocumentoUserExterno> findByEstado(int estado);
    public void save(Documento equipo);
    public Documento findOne(int id);
    public RelacionDocumentoUserExterno findOneWithRelacion(int id);
    public void delete(int id);
}
