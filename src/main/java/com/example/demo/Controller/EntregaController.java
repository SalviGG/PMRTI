/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.model.entity.Documento;
import com.example.demo.model.entity.RelacionDocumentoUserExterno;
import com.example.demo.model.entity.UsuarioExterno;
import com.example.demo.model.service.DocumentoService;
import com.example.demo.model.service.EquipoService;
import com.example.demo.model.service.EstadoDocumentoService;
import com.example.demo.model.service.EstadoEquipoService;
import com.example.demo.model.service.TipoEquipoService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author usuario
 */


@Controller
@RequestMapping("/entrega")
public class EntregaController {
    @Autowired
    private DocumentoService docDAO;
    
    @Autowired
    private TipoEquipoService tipoEquipo;
    
    @Autowired 
    private EquipoService equipoDAO;
    
    @Autowired
    private EstadoEquipoService estaEquiDAO;
    
    @Autowired
    private EstadoDocumentoService estDocDAO;
            
         
    
    @GetMapping("/listarSolicitudEstado")
    public String lestarPendienteEntrega(Model model){
    
        List<RelacionDocumentoUserExterno> list = docDAO.findByEstado(1);
        model.addAttribute("lisDocum", list);
        
        
    return "entrega/listarPendientes";
    }
    
    @GetMapping("/entregar/{id}")
    public String entregar(@PathVariable int id , Model model){
        RelacionDocumentoUserExterno doc = docDAO.findOneWithRelacion(id);
        model.addAttribute("doc",doc);
        
        model.addAttribute("listEquipoDis", equipoDAO.findByGroupAndTipo(1,doc.getDoc().getTipoEquipo()));
        model.addAttribute("Documento", docDAO.findOne(id));
        
        return"entrega/entrega";
    }
    
    @GetMapping("/rechazar/{id}")
    public String rechazar(@PathVariable int id , Model model){
        RelacionDocumentoUserExterno doc = docDAO.findOneWithRelacion(id);
        doc.getDoc().setEstado(estDocDAO.findOne(6));
        docDAO.save(doc.getDoc());
        return"redirect:/entrega/listarSolicitudEstado";
    }
    
    @PostMapping("entregar")
    public String dejarEntrega(@Valid Documento doc,HttpSession session){
        
        Documento docAnt = docDAO.findOne(doc.getId());
        docAnt.setEquipo(doc.getEquipo());
        
        
        if(docAnt.getTipoDocumento().equals("SL")){
            docAnt.getEquipo().setEstado(estaEquiDAO.findOne(4).orElse(null));
        }else{
            docAnt.getEquipo().setEstado(estaEquiDAO.findOne(3).orElse(null));
        }        
        docAnt.setEstado(estDocDAO.findOne(5));
        UsuarioExterno user = (UsuarioExterno)session.getAttribute("usuario");
        docAnt.setRutTI(user.getIdNacional());
        docAnt.setFechaEntrega(new Date());
        docDAO.save(docAnt);
        return "redirect:/index";
    }
    
}
