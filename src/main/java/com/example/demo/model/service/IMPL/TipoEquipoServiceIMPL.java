/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.DAO.ITipoEquipo;
import com.example.demo.model.entity.TipoEquipo;
import com.example.demo.model.service.TipoEquipoService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class TipoEquipoServiceIMPL implements TipoEquipoService{
    
    @Autowired
    private ITipoEquipo tipoEquipoDAO;
    
    @Override
    public List<TipoEquipo> findAll() {
        return (List<TipoEquipo>) tipoEquipoDAO.findAll();
    }

    @Override
    public void save(TipoEquipo tipEqui) {
        tipoEquipoDAO.save(tipEqui);
    }

    @Override
    public Optional<TipoEquipo> findOne(int id) {
        return tipoEquipoDAO.findById(id);
    }

    @Override
    public void delete(int id) {
       tipoEquipoDAO.deleteById(id);
    }    

    
}
