/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.Documento;
import com.example.demo.model.service.DocumentoService;
import com.example.demo.model.service.TipoEquipoService;
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
@RequestMapping("/solicitudAsig")
public class SolicitudAsigEquipoController {

    @Autowired
    private DocumentoService docDao;
    
    @Autowired
    private TipoEquipoService tipoEquiDAO;
    
    
    @GetMapping("/creaSolicitud")
    public String crearSolicitud(Model model){
        
        model.addAttribute("listTipo", tipoEquiDAO.findAll());
        model.addAttribute("Documento", new Documento());
        return "solicitudAsigEqui/crearSolicitudAsigEquipo";
    }

    
}
