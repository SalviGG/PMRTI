/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

//Import de dependencias
import com.example.demo.model.entity.TipoEquipo;
import com.example.demo.model.service.TipoEquipoService;
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
@RequestMapping("/index")
public class IndexController {
    
    @GetMapping("index")
    public String form(){
        return "index/index";
    }
    
    
}