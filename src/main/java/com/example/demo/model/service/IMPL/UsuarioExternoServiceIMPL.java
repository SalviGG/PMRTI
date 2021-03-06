/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.Usuario;
import com.example.demo.model.DAO.IUsuarioExterno;
import com.example.demo.model.entity.UsuarioExterno;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.model.service.UsuarioExternoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Asus
 */
@Service
public class UsuarioExternoServiceIMPL  implements UsuarioExternoService{
    @Autowired
    private IUsuarioExterno userDAO;
    
    @Override
    public List<UsuarioExterno> findAll() {
        List<UsuarioExterno> list = new ArrayList<>();
        try { // Call Web Service Operation
            com.example.demo.Usuarios_Service service = new com.example.demo.Usuarios_Service();
            com.example.demo.Usuarios port = service.getUsuariosPort();
            // TODO process result here
            java.util.List<com.example.demo.Usuario> result = port.findAll();
            UsuarioExterno user = null;
            for (Usuario usuario : result) {
                user = new UsuarioExterno();
                user.setIdUsuario(usuario.getIdUsuario());
                user.setEmail(usuario.getEmail());
                user.setPasswer(usuario.getPasswer());
                user.setLastName(usuario.getLastName());
                user.setName(usuario.getName());
                user.setIdNacional(usuario.getIdNacional());
                user.setEstado(usuario.getEstado());
                user.setDepartamento(usuario.getDepartament());
                list.add(user);
            }
        } catch (Exception ex) {
            
        }
        
        List<UsuarioExterno> local = (List<UsuarioExterno>)userDAO.findAll();
        
        
        for (UsuarioExterno usuarioExterno : local) {
            list.add(usuarioExterno);
        }
        return list;
    }

    @Override
    public UsuarioExterno findOne(int id) {
        UsuarioExterno user = new UsuarioExterno();
        try { // Call Web Service Operation
            com.example.demo.Usuarios_Service service = new com.example.demo.Usuarios_Service();
            com.example.demo.Usuarios port = service.getUsuariosPort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
            com.example.demo.Usuario result = port.findId(id);
             user = new UsuarioExterno();
            
            user.setIdUsuario(result.getIdUsuario());
            user.setEmail(result.getEmail());
            user.setPasswer(result.getPasswer());
            user.setLastName(result.getLastName());
            user.setName(result.getName());
            user.setIdNacional(result.getIdNacional());
            user.setEstado(result.getEstado());
            user.setDepartamento(result.getDepartament());
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return user;
    }
    
    
    @Override
    public UsuarioExterno findOne(String idNacional) {
        UsuarioExterno user = null;
        try { // Call Web Service Operation
            com.example.demo.Usuarios_Service service = new com.example.demo.Usuarios_Service();
            com.example.demo.Usuarios port = service.getUsuariosPort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
            com.example.demo.Usuario result = port.findIdNacional(idNacional);
            
            
            if(result.getIdUsuario() > 0){
                
                user = new UsuarioExterno();                
                user.setIdUsuario(result.getIdUsuario());
                user.setEmail(result.getEmail());
                user.setPasswer(result.getPasswer());
                user.setLastName(result.getLastName());
                user.setName(result.getName());
                user.setIdNacional(result.getIdNacional());
                user.setEstado(result.getEstado());
                user.setDepartamento(result.getDepartament());
            } 
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        if(user == null){ 
            user = userDAO.findByIdNacional(idNacional);
        }
        
        return user;
    }

    @Override
    public UsuarioExterno findOne(String email, String passwer) {
         UsuarioExterno user = null;
        try { // Call Web Service Operation
            com.example.demo.Usuarios_Service service = new com.example.demo.Usuarios_Service();
            com.example.demo.Usuarios port = service.getUsuariosPort();
            // TODO initialize WS operation arguments here            
            // TODO process result here
            com.example.demo.Usuario result = port.findEmailPasswer(email, passwer);          
            
            if(result.getIdUsuario() > 0){
                user = new UsuarioExterno();                
                user.setIdUsuario(result.getIdUsuario());
                user.setEmail(result.getEmail());
                user.setPasswer(result.getPasswer());
                user.setLastName(result.getLastName());
                user.setName(result.getName());
                user.setIdNacional(result.getIdNacional());
                user.setEstado(result.getEstado());
                user.setDepartamento(result.getDepartament());
            } 
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return user;
    }

    @Override
    public void save(UsuarioExterno user) {
       userDAO.save(user);
    } 
    
}
