/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.TmpUsuario;
import com.example.demo.model.service.TmpUsuarioService;
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
@RequestMapping("tmpUsuario")
public class TmpUsuarioController {
    
    @Autowired
    private TmpUsuarioService tmpUseuariService;
    
    @GetMapping("/listar")
    public String listar(Model model){
         
        List<TmpUsuario> list = tmpUseuariService.findAll();
        model.addAttribute("listar", list);
        
        return "/tmpUsuario/listar";
    }
    
    
}
