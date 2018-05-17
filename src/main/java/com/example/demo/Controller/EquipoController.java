/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;


import com.example.demo.model.entity.Equipo;
import com.example.demo.model.entity.TipoEquipo;
import com.example.demo.model.service.EquipoService;
import com.example.demo.model.service.TipoEquipoService;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


/**
 *
 * @author Asus
 */
@Controller
@RequestMapping("/equipo")
public class EquipoController {
    
    @Autowired 
    private EquipoService equipoService;
    
    @Autowired
    private TipoEquipoService tipoEquiServ;
    
    @GetMapping("/listar")
    public String listado(Model model){
        
        model.addAttribute("listEquipo", equipoService.findAll());
        
        return "equipo/listar";
    }
    
    @GetMapping("/form")
    public String form( Model model){
        
        Equipo Equi = new Equipo();
        
        List<TipoEquipo> lisTipoEqui = tipoEquiServ.findAll();
        model.addAttribute("Equipo", Equi);
        model.addAttribute("listTipoEqui", lisTipoEqui);
        
        return "equipo/form";
    }
    
    @PostMapping("/from")
    public String guardar(@Valid Equipo equi ,SessionStatus status){
            
        equi.setEstado("P");
        equipoService.save(equi);
        
        status.setComplete();
        return "redirect:listar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id,Model model,SessionStatus status){
        Equipo equi = equipoService.findOne(id).orElse(null);
        if(equi != null){
            equipoService.delete(id);
            status.setComplete();
        }        
        return "redirect:../listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id,Model model){
        Equipo equi = equipoService.findOne(id).orElse(null);
        if(equi != null){
            
            List<TipoEquipo> lisTipoEqui = tipoEquiServ.findAll();
            model.addAttribute("Equipo", equi);
            model.addAttribute("listTipoEqui", lisTipoEqui);
            return "equipo/editar/from";
        }
        return "redirect:listar";
    }
}
