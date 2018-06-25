package com.example.demo.model.DAO;

import com.example.demo.model.entity.UsuarioExterno;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public interface IUsuarioExterno extends CrudRepository<UsuarioExterno, Integer> {
        
    @Query("select u from UsuarioExterno u where u.idNacional = ?1")
    public UsuarioExterno findByIdNacional(String rut);
    
    
}
