/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.DAO;

import com.example.demo.model.entity.Documento;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author usuario
 */
public interface IDocumento extends CrudRepository<Documento, Integer>{
    
}
