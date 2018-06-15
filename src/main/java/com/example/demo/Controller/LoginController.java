/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;


import com.example.demo.model.entity.UsuarioExterno;

import com.example.demo.model.service.UsuarioExternoService;
import com.example.demo.objetos.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author sgutierrez
 */
@Controller
@RequestMapping("/")
public class LoginController {
    
    @Autowired
    private UsuarioExternoService usuarioExternoService;
    
    
    @GetMapping("prueba")
    public String prueba(Model model){
        model.addAttribute("usuario", null);
        return "plantilla/fragmentos";
    }
      
    @GetMapping("")
    public String login(Model model){
        
        model.addAttribute("Login", new Login());
        
        return "/login/page-login";
    }
    
    @PostMapping("/page-login")
    public String ingresar(@Valid Login login ,SessionStatus status ,Model model,HttpSession request){
        
        UsuarioExterno user = usuarioExternoService.findOne(login.getUser(), login.getPass());
        
        if(user == null){
            model.addAttribute("Login", new Login());
            return "redirect:/";
        }    
        
        request.setAttribute("usuario", user);
        
        return "redirect:/index";
    }
    
}
