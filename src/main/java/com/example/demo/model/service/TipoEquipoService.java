/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;


import com.example.demo.model.entity.TipoEquipo;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */

public interface TipoEquipoService {
   public List<TipoEquipo> findAll();
   public void save (TipoEquipo tipEqui);
   public Optional<TipoEquipo> findOne(int id);
   public void delete(int id);
    
}
