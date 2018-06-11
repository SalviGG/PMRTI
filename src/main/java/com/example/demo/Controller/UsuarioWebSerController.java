/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.UsuarioExterno;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.service.UsuarioExternoService;

/**
 *
 * @author Asus
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioWebSerController {
    
   @Autowired 
   private UsuarioExternoService user;
   
   @GetMapping("/listar")
    public String listado(Model model){        
        List<UsuarioExterno> list = new ArrayList();
        list = user.findAll();
        model.addAttribute("listUser", list);        
        return "user/listar";
    }
    
}
