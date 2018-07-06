/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.Documento;
import com.example.demo.model.entity.RelacionDocumentoUserExterno;
import com.example.demo.model.entity.UsuarioExterno;
import com.example.demo.model.service.DocumentoService;
import com.example.demo.model.service.EstadoDocumentoService;
import com.example.demo.model.service.TipoEquipoService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */
@Controller
@RequestMapping("/prestamo")
public class PrestamosController {
    
    @Autowired
    private DocumentoService docDAO;
    
    @Autowired
    private TipoEquipoService tipoEquiDAO;
    
    @Autowired  
    private EstadoDocumentoService tipoEstaDocService;
    
    @GetMapping("/pedirPrestamo")
    public String pedirPrestamo( Model model ){
        model.addAttribute("listTipo", tipoEquiDAO.findAll());
        model.addAttribute("Documento", new Documento());
        return "prestamo/pedirPrestamo";
    }
    
    @PostMapping("/pedirPrestamo")
    public String guardarPrestamo(@Valid Documento doc, HttpSession session){
        
        UsuarioExterno user = (UsuarioExterno)session.getAttribute("usuario");
        doc.setRutSolicitante(user.getIdNacional());
        doc.setRutReceptor(user.getIdNacional());
        doc.setFechaSolicitud(new Date());
        doc.setTipoDocumento("PR");
        doc.setEstado(tipoEstaDocService.findOne(1));
                
        docDAO.save(doc);
        
        return "redirect:/index";
    }
    
    @GetMapping("/listar")
    public String listarPrestamos(HttpSession session,Model model){
        UsuarioExterno user = (UsuarioExterno)session.getAttribute("usuario");
        List<RelacionDocumentoUserExterno> list = docDAO.findAllWithRelacionForSolicitante(user.getIdNacional(), "PR");
        
        model.addAttribute("lisDocum", list);
        
    
        return "prestamo/listar";
    }
    
    
    
}
