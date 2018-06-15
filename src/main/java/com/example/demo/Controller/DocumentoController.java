/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.Documento;
import com.example.demo.model.service.DocumentoService;
import java.util.List;
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
@RequestMapping("/document")
public class DocumentoController{
    @Autowired
    private DocumentoService docService;
    
    @GetMapping("/listar")
    public String listarDoc(Model model){
        List<Documento> listDoc = docService.findAll();
        System.out.println("\n \n"+listDoc.size()+"\n \n");
        model.addAttribute("listDoc",listDoc);
        
        return "documentos/listarDocumentos";
    }
    
}
