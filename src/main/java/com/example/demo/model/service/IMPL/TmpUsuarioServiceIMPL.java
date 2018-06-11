/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.DAO.ITmpUsuario;
import com.example.demo.model.entity.TmpUsuario;
import com.example.demo.model.service.TmpUsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service 
public class TmpUsuarioServiceIMPL implements TmpUsuarioService{
    
    @Autowired
    private ITmpUsuario tmpUsuarioDAO;
    
    @Override
    public List<TmpUsuario> findAll() {
        return (List<TmpUsuario>) tmpUsuarioDAO.findAll();
    }

    @Override
    public void save(TmpUsuario equipo) {
        tmpUsuarioDAO.save(equipo);
    }

    @Override
    public Optional<TmpUsuario> findOne(String id) {
       return tmpUsuarioDAO.findById(id);
    }

    @Override
    public void delete(String id) {
        tmpUsuarioDAO.deleteById(id);
    }
    
}
