/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.entity.UsuarioExterno;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Asus
 */
public interface UsuarioExternoService {
   public List<UsuarioExterno> findAll();
   //public void save (UsuarioExternoService tipEqui);
   public UsuarioExterno findOne(int id);
   //public void delete(int id);
   public UsuarioExterno findOne(String idNacional);
   public UsuarioExterno findOne(String email,String passwer);
}
