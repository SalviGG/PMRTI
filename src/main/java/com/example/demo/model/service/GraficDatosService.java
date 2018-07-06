/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.entity.TipoEquipo;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface GraficDatosService {
    
    public String graficColmAndGroup(List<TipoEquipo> listEqui,String idContainer,String title,String titleLeft);
    public String graficSereieforColum(List<TipoEquipo>listEqui);
}
