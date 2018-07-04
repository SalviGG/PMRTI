/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

//Import de dependencias
import com.example.demo.model.entity.TipoEquipo;
import com.example.demo.model.entity.UsuarioExterno;
import com.example.demo.model.service.EquipoService;
import com.example.demo.model.service.EstadoEquipoService;
import com.example.demo.model.service.GraficDatosService;
import com.example.demo.model.service.TipoEquipoService;
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
@RequestMapping("/index")
public class IndexController {
    
    @Autowired
    private TipoEquipoService tipEquiDAO;
    
    @Autowired
    private EquipoService equiDAO;
    
    @Autowired
    private EstadoEquipoService estadoEquiDAO;
    
    @Autowired
    private GraficDatosService Generategrafic;
    
    @GetMapping("index")
    public String form( HttpServletRequest request){
        
        UsuarioExterno user = (UsuarioExterno)request.getSession().getAttribute("usuario");
        
        if (user == null){
         return"redirect:/";
        }
        
        return "index/index";
    }
    
    @GetMapping("index2")
    public String form2( HttpServletRequest request){
        
               
        return "index/index2";
    }
    @GetMapping("index3")
    public String form3(Model model ){
       
        String grafic =Generategrafic.graficColmAndGroup(tipEquiDAO.findAll(), "container", "Prueba", "cantidad");
        System.out.println(grafic);
        model.addAttribute("grafic", grafic);
        return "index/index3";
    }
    
    @GetMapping("")
    public String index2(HttpSession request){
        
        UsuarioExterno user = (UsuarioExterno)request.getAttribute("usuario");
        
        if (user == null){
            return"redirect:/";
        }
        System.out.println(user.getName());
        return "index/index";
    }
    
}
