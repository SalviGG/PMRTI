/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.DAO.IEstadoEquipo;
import com.example.demo.model.entity.EstadoEquipo;
import com.example.demo.model.service.EstadoEquipoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class EstadoEquipoServiceIMPL implements EstadoEquipoService{
    
    @Autowired
    private IEstadoEquipo estadoEquipoDAO;
    
    @Override
    public List<EstadoEquipo> findAll() {
       return (List<EstadoEquipo>) estadoEquipoDAO.findAll();
    }

    @Override
    public void save(EstadoEquipo equipo) {
        estadoEquipoDAO.save(equipo);
    }

    @Override
    public Optional<EstadoEquipo> findOne(int id) {
        return estadoEquipoDAO.findById(id);
    }

    @Override
    public void delete(EstadoEquipo estado) {
        estadoEquipoDAO.delete(estado);
    }
    
    
}
