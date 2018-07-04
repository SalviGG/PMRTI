/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.Documento;
import com.example.demo.model.entity.Equipo;
import com.example.demo.model.entity.UsuarioExterno;
import com.example.demo.model.service.DocumentoService;
import com.example.demo.model.service.EstadoDocumentoService;
import com.example.demo.model.service.TipoEquipoService;
import com.example.demo.model.service.UsuarioExternoService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author usuario
 */

@Controller
@RequestMapping("/solicitudAsig")
public class SolicitudAsigEquipoController {

    @Autowired
    private DocumentoService docDao;
    
    @Autowired
    private TipoEquipoService tipoEquiDAO;
    
    @Autowired
    private UsuarioExternoService userEctDAO;
    
    @Autowired
    private EstadoDocumentoService estaDocDAO;
    
    @GetMapping("/creaSolicitud")
    public String crearSolicitud(Model model){
        
        model.addAttribute("listUsers", userEctDAO.findAll());
        model.addAttribute("listTipo", tipoEquiDAO.findAll());
        model.addAttribute("Documento", new Documento());
        return "solicitudAsigEqui/crearSolicitudAsigEquipo";
    }
    @PostMapping("/creaSolicitud")
    public String saveDocumen(@Valid Documento doc , Model mode , HttpSession session){
        UsuarioExterno user = (UsuarioExterno)session.getAttribute("usuario");
        System.out.println(doc.getRutReceptor());
        doc.setRutSolicitante(user.getIdNacional());
        doc.setFechaSolicitud(new Date());
        doc.setEstado(estaDocDAO.findOne(1));
        doc.setTipoDocumento("SL");
        docDao.save(doc);
        
        return"redirect:/index";
    }
    
    @GetMapping("/listaSoliAsig")
    public String listarSolic(Model model ,HttpSession session){
        
        UsuarioExterno user = (UsuarioExterno) session.getAttribute("usuario");
        model.addAttribute("lisDocum", docDao.findAllWithRelacionForSolicitante(user.getIdNacional(),"SL"));
        
        return "solicitudAsigEqui/listaSoliAsig";
    }
    @PostMapping(value = "/crearUser" ,produces = {"application/json"})
    public @ResponseBody String crear(@RequestBody UsuarioExterno user){
        //
        String rest="{\"respuesta\":\"0\"}";
        try {
            UsuarioExterno userV = userEctDAO.findOne(user.getIdNacional());
            if(userV == null){
                userEctDAO.save(user);
                 rest="{\"respuesta\":\"1\"}";
            }else{
                rest="{\"respuesta\":\"2\"}";
            }
            
        } catch (Exception e) {
            rest="{\"respuesta\":\"3\"}";
        }        
        return rest;
    }
}
