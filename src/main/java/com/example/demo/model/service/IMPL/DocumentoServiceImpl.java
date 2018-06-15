/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.DAO.IDocumento;
import com.example.demo.model.entity.Documento;
import com.example.demo.model.service.DocumentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class DocumentoServiceImpl implements DocumentoService{
    
    @Autowired
    private IDocumento docDAO;
    
    @Override
    public List<Documento> findAll() {
        return (List<Documento>) docDAO.findAll();
    }

    @Override
    public void save(Documento equipo) {
        docDAO.save(equipo);
    }

    @Override
    public Documento findOne(int id) {
      return  docDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        docDAO.deleteById(id);
    }
    
}
