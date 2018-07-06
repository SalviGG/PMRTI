/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.DAO.IEstadoDocumento;
import com.example.demo.model.entity.EstadoDocumento;
import com.example.demo.model.service.EstadoDocumentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class EstadoDocumentoServiceIMPL implements EstadoDocumentoService{

    @Autowired
    private IEstadoDocumento estadoDocDao;
    
    @Override
    public List<EstadoDocumento> findAll() {
        return (List<EstadoDocumento>)estadoDocDao.findAll();
    }

    @Override
    public void save(EstadoDocumento equipo) {
        estadoDocDao.save(equipo);
    }

    @Override
    public EstadoDocumento findOne(int id) {
        return estadoDocDao.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        estadoDocDao.deleteById(id);
    }
    
}
