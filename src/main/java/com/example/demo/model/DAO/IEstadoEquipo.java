/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.DAO;

import com.example.demo.model.entity.EstadoEquipo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Asus
 */
public interface IEstadoEquipo extends CrudRepository<EstadoEquipo, Integer>{
    
}
