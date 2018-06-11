/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.entity.TmpUsuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author usuario
 */
public interface TmpUsuarioService {
    public List<TmpUsuario> findAll();
    public void save(TmpUsuario equipo);
    public Optional<TmpUsuario> findOne(String id);
    public void delete(String id);
}
