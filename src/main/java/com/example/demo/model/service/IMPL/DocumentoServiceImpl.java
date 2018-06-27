/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.DAO.IDocumento;
import com.example.demo.model.entity.Documento;
import com.example.demo.model.entity.RelacionDocumentoUserExterno;
import com.example.demo.model.service.DocumentoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class DocumentoServiceImpl implements DocumentoService{
    
    @Autowired
    private IDocumento docDAO;
    
    @Autowired
    private UsuarioExternoServiceIMPL userDao;
    
    @Override
    public List<Documento> findAll() {
        return (List<Documento>) docDAO.findAll();
    }
    
    @Override
    public void save(Documento equipo) {
        docDAO.save(equipo);
    }

    @Override
    public Documento findOne(int id) {
      return  docDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        docDAO.deleteById(id);
    }

    @Override
    public List<RelacionDocumentoUserExterno> findAllWithRelacion() {
        List<Documento> listDoc = this.findAll();
        List<RelacionDocumentoUserExterno> listDocWithRel  = new ArrayList<RelacionDocumentoUserExterno>();
        
        RelacionDocumentoUserExterno docWithRel = null;
        for (Documento doc : listDoc) {
            docWithRel = new RelacionDocumentoUserExterno();
            docWithRel.setDoc(doc);
            docWithRel.setSolicitante(userDao.findOne(doc.getRutSolicitante()+""));
            docWithRel.setReceptor(userDao.findOne(doc.getRutReceptor()));
            docWithRel.setTi(userDao.findOne(doc.getRutTI()));
            listDocWithRel.add(docWithRel);
        }
        
        return listDocWithRel;
    }

    @Override
    public RelacionDocumentoUserExterno findOneWithRelacion(int id) {
        Documento doc = this.findOne(id);
        
        RelacionDocumentoUserExterno reDoc = new RelacionDocumentoUserExterno();
        reDoc.setDoc(doc);
        reDoc.setSolicitante(userDao.findOne(doc.getRutSolicitante()));
        reDoc.setReceptor(userDao.findOne(doc.getRutReceptor()));
        reDoc.setTi(userDao.findOne(doc.getRutTI()));
        
        return reDoc;
    }

    @Override
    public List<RelacionDocumentoUserExterno> findAllWithRelacionForSolicitante(String rutSolicitante,String tipDoc ) {
       
        List<Documento> listDoc = (List<Documento>)docDAO.findByIdNacional(rutSolicitante, tipDoc);
        List<RelacionDocumentoUserExterno> listDocWithRel  = new ArrayList<RelacionDocumentoUserExterno>();
        
        RelacionDocumentoUserExterno docWithRel = null;
        for (Documento doc : listDoc) {
            docWithRel = new RelacionDocumentoUserExterno();
            docWithRel.setDoc(doc);
            docWithRel.setSolicitante(userDao.findOne(doc.getRutSolicitante()+""));
            docWithRel.setReceptor(userDao.findOne(doc.getRutReceptor()));
            docWithRel.setTi(userDao.findOne(doc.getRutTI()));
            listDocWithRel.add(docWithRel);
        }            
        return listDocWithRel;
    }

    @Override
    public List<RelacionDocumentoUserExterno> findByEstado(int estado) {
        
        List<Documento> listDoc = (List<Documento>)docDAO.findByEstado(estado);
        List<RelacionDocumentoUserExterno> listDocWithRel  = new ArrayList<RelacionDocumentoUserExterno>();
        
        RelacionDocumentoUserExterno docWithRel = null;
        for (Documento doc : listDoc) {
            docWithRel = new RelacionDocumentoUserExterno();
            docWithRel.setDoc(doc);
            docWithRel.setSolicitante(userDao.findOne(doc.getRutSolicitante()+""));
            docWithRel.setReceptor(userDao.findOne(doc.getRutReceptor()));
            docWithRel.setTi(userDao.findOne(doc.getRutTI()));
            listDocWithRel.add(docWithRel);
        }            
        return listDocWithRel;
        
    }
    
}
