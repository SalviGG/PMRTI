/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.UsuarioExterno;
import com.example.demo.model.service.UsuarioExternoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/user")
public class UserRestControl {
    
    @Autowired
    private UsuarioExternoService userDao;
    
    @GetMapping("/findall")
    public List<UsuarioExterno> findAll(){
    
        return userDao.findAll();
    }
    
}
