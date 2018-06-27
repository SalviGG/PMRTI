/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/listar")
    public String listarEquiposParaDev(Model model){
            
        model.addAttribute("lisDocum", docDAO.findByEstado(5));
        
        return "devolucion/listar";
    }
}
