/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.entity.EstadoDocumento;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface EstadoDocumentoService {
    
    
    public List<EstadoDocumento> findAll();
    public void save(EstadoDocumento equipo);
    public EstadoDocumento findOne(int id);
    public void delete(int id);
    
}
