/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.DAO;

import com.example.demo.model.entity.Documento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author usuario
 */
public interface IDocumento extends CrudRepository<Documento, Integer>{
    
    
    @Query("select d from Documento d where d.rutSolicitante = ?1 and d.tipoDocumento = ?2 ")
    public List<Documento> findByIdNacional(String rut,String tipoDoc);
    
    @Query("select d from Documento d where d.estado.id = ?1 ")
    public List<Documento> findByEstado(int rut);
}
