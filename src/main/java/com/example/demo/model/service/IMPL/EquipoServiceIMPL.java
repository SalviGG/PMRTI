/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.DAO.IEquipo;
import com.example.demo.model.entity.Equipo;
import com.example.demo.model.service.EquipoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class EquipoServiceIMPL implements EquipoService{

    @Autowired
    private IEquipo equipoDAO;
    
    @Override
    public List<Equipo> findAll() {
        return (List<Equipo>) equipoDAO.findAll();
    }

    @Override
    public void save(Equipo equipo) {
        equipoDAO.save(equipo);
    }
    
    @Override
    public Optional<Equipo> findOne(int id) {
        return equipoDAO.findById(id);
    }

    @Override
    public void delete(int id) {
        equipoDAO.deleteById(id);
    }

    
    
}
