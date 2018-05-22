/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.Usuario;
import com.example.demo.model.entity.UsuarioExterno;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.model.service.UsuarioExternoService;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
@Service
public class UsuarioExternoServiceIMPL  implements UsuarioExternoService{

    @Override
    public List<UsuarioExterno> findAll() {
        List<UsuarioExterno> list = new ArrayList<>();
        try { // Call Web Service Operation
            com.example.demo.Usuarios_Service service = new com.example.demo.Usuarios_Service();
            com.example.demo.Usuarios port = service.getUsuariosPort();
            // TODO process result here
            java.util.List<com.example.demo.Usuario> result = port.findAll();
            UsuarioExterno user =null;
            for (Usuario usuario : result) {
                user = new UsuarioExterno();
                user.setIdUsuario(usuario.getIdUsuario());
                user.setEmail(usuario.getEmail());
                user.setPasswer(usuario.getPasswer());
                user.setLastName(usuario.getLastName());
                user.setName(usuario.getName());
                user.setIdNacional(usuario.getIdNacional());
                user.setEstado(usuario.getEstado());
                list.add(user);
            }
        } catch (Exception ex) {
            
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
            
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return user;
    }

    @Override
    public UsuarioExterno findOne(String idNacional) {
        UsuarioExterno user = new UsuarioExterno();
        try { // Call Web Service Operation
            com.example.demo.Usuarios_Service service = new com.example.demo.Usuarios_Service();
            com.example.demo.Usuarios port = service.getUsuariosPort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
            com.example.demo.Usuario result = port.findIdNacional(idNacional);
            user = new UsuarioExterno();
            
            user.setIdUsuario(result.getIdUsuario());
            user.setEmail(result.getEmail());
            user.setPasswer(result.getPasswer());
            user.setLastName(result.getLastName());
            user.setName(result.getName());
            user.setIdNacional(result.getIdNacional());
            user.setEstado(result.getEstado());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return user;
    }

    @Override
    public UsuarioExterno findOne(String email, String passwer) {
         UsuarioExterno user = new UsuarioExterno();
        try { // Call Web Service Operation
            com.example.demo.Usuarios_Service service = new com.example.demo.Usuarios_Service();
            com.example.demo.Usuarios port = service.getUsuariosPort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
            com.example.demo.Usuario result = port.findEmailPasswer(email, passwer);
            user = new UsuarioExterno();
            
            user.setIdUsuario(result.getIdUsuario());
            user.setEmail(result.getEmail());
            user.setPasswer(result.getPasswer());
            user.setLastName(result.getLastName());
            user.setName(result.getName());
            user.setIdNacional(result.getIdNacional());
            user.setEstado(result.getEstado());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return user;
    }
    
}
