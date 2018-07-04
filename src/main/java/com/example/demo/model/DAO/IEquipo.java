/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.DAO;

import com.example.demo.model.entity.Equipo;
import com.example.demo.model.entity.EstadoEquipo;
import com.example.demo.model.entity.TipoEquipo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Asus
 */
public interface IEquipo extends CrudRepository<Equipo, Integer>{
    
    @Query("select e from Equipo e where e.estado.grupo = ?1 ")
    public List<Equipo> findByGroup(int group);
    
    @Query("select e from Equipo e where e.estado.grupo = ?1 and e.tipoEquipo = ?2 ")
    public List<Equipo> findByGroupAndTipo(int group,TipoEquipo tipo);
    
    @Query("select COUNT(e) from Equipo e where e.tipoEquipo = ?1 ")
    public long countForType(TipoEquipo tipo);
    
    @Query("select COUNT(e) from Equipo e where e.tipoEquipo = ?1 and e.estado = ?2 ")
    public long countForTypeAndForStado(TipoEquipo tipo,EstadoEquipo estado);
    
    @Query("select COUNT(e) from Equipo e where e.tipoEquipo = ?1 and e.estado.grupo = ?2 ")
    public long countForTypeAndForGroup(TipoEquipo tipo,int grupo);
    
    
}
