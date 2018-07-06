/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@Controller
public class MyErrorController implements ErrorController{
    
    @RequestMapping("/error")
    public String error(){
        
        return "redirect:/index";
    }

    @Override
    public String getErrorPath() {
        System.out.println("yonis hola");
       return"/error"; 
    }
    
    
}
