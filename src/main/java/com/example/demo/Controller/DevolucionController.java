/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.Documento;
import com.example.demo.model.entity.EstadoEquipo;
import com.example.demo.model.service.DocumentoService;
import com.example.demo.model.service.EstadoEquipoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */

@Controller
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @Autowired
    private DocumentoService docDAO;
    
    @Autowired
    private EstadoEquipoService estEquiDAO;
    @GetMapping("/listar")
    public String listarEquiposParaDev(Model model){
            
        model.addAttribute("lisDocum", docDAO.findByEstado(5));
        
        return "devolucion/listar";
    }
    
    @GetMapping("/recepcion/{id}")
    public String recepcionarEquipo(@PathVariable int id,Model model){
        model.addAttribute("listEstado", estEquiDAO.findAll());
        model.addAttribute("doc", docDAO.findOneWithRelacion(id));
        model.addAttribute("Documento", new Documento());
        return "devolucion/recepcion";
    }
    
    @PostMapping("/recepcion")
    public String aceptarEquipo(@Valid Documento doc,Model model){
        
        
        
        return "devolucion/recepcion";
    }
    
}
