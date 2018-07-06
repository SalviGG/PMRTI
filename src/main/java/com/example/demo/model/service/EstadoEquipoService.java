/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.entity.EstadoEquipo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Asus
 */
public interface EstadoEquipoService {
    
    public List<EstadoEquipo> findAll();
    public void save(EstadoEquipo equipo);
    public Optional<EstadoEquipo> findOne(int id);
    public void delete(EstadoEquipo estado);
}
