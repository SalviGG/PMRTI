/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.entity.Equipo;
import com.example.demo.model.entity.TipoEquipo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Asus
 */
public interface EquipoService  {
    public List<Equipo> findAll();
    public List<Equipo> findAllForGroup(int group);
    public List<Equipo> findByGroupAndTipo(int group,TipoEquipo tipo);
    public void save(Equipo equipo);
    public Optional<Equipo> findOne(int id);
    public void delete(int id);
}
