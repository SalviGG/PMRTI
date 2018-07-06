/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service.IMPL;

import com.example.demo.model.entity.EstadoEquipo;
import com.example.demo.model.entity.TipoEquipo;
import com.example.demo.model.service.EquipoService;
import com.example.demo.model.service.EstadoEquipoService;
import com.example.demo.model.service.GraficDatosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class GraficDatosServiceIMPL implements GraficDatosService{
    
    @Autowired
    private EquipoService equipoDAO;
    
    @Autowired
    private EstadoEquipoService estEquipoDAO;
    
    @Override
    public String graficColmAndGroup(List<TipoEquipo> listEqui ,String idContainer,String title,String titleLef) {
        
        
        
        String graficData = "";
        String categoria ="xAxis: {categories:[";
        String series = "series: [";
        int count = 0;
        String seriesDisponible ="{name: 'disponible',data: [" ;
        String seriesNoDisponible="{name: 'no disponible',data: [";
        String seriesPrestados="{name: 'prestados',data: [";
        String seriesAsignados="{name: 'asignados',data: [";
        String seriesEnMantenimiento="{name: 'En Mantenimiento',data: [";
        
        
        for (TipoEquipo tipoEquipo : listEqui) {
            long disponible=equipoDAO.countForTypeAndForGroup(tipoEquipo, 1);
            long noDisponible=equipoDAO.countForTypeAndForGroup(tipoEquipo, 3);
            long pretados=equipoDAO.countForTypeAndForStado(tipoEquipo, estEquipoDAO.findOne(3).orElse(null));
            long asignados=equipoDAO.countForTypeAndForStado(tipoEquipo, estEquipoDAO.findOne(4).orElse(null));
            long enMantenimiento=equipoDAO.countForTypeAndForStado(tipoEquipo, estEquipoDAO.findOne(2).orElse(null));
            
            if(count>0){
                categoria +=",";                
                seriesDisponible +="," ;
                seriesNoDisponible+=",";
                seriesPrestados+=",";
                seriesAsignados+=",";
                seriesEnMantenimiento+=",";
            }
            categoria +="'"+tipoEquipo.getNombre()+"'";
                seriesDisponible +=""+disponible ;
                seriesNoDisponible+=""+noDisponible;
                seriesPrestados+=""+pretados;
                seriesAsignados+=""+asignados;
                seriesEnMantenimiento+=""+enMantenimiento;
            
            count++;
        }
        categoria +="]},";               
                seriesDisponible +="],stack: 'Dis'}" ;
                seriesNoDisponible+="],stack: 'Dis'}";
                seriesPrestados+="],stack: 'det'}";
                seriesAsignados+="],stack: 'det'}";
                seriesEnMantenimiento+="],stack: 'man'}";
        series += seriesDisponible+","+seriesNoDisponible+","+seriesPrestados+","+seriesAsignados+","+seriesEnMantenimiento+"]";
        System.out.println(series);
        
        String graficHead ="Highcharts.chart('"+idContainer+"', {"       
            +"chart: {type: 'column'},"
            +"title: {text: '"+title+"'},"
            +categoria
            +"yAxis: {allowDecimals: false,min: 0,title: {"
            +"text: '"+titleLef+"'}},"
            +"tooltip: {"
            +"formatter: function () {"
            +"return '<b>' + this.x + '</b><br/>' +"
            +"this.series.name + ': ' + this.y + '<br/>' +"
            +"'Total: ' + this.point.stackTotal;"
            +"}},"
            +"plotOptions: {column: {stacking: 'normal'}},"
            +series+"});";
        
        return graficHead;
    }
    
    @Override
    public String graficSereieforColum(List<TipoEquipo>listEqui) {
        
        String series = "{\"serie\":[";
        int count = 0;
        String seriesDisponible ="{\"name\": \"disponible\",\"data\": [" ;
        String seriesNoDisponible="{\"name\": \"no disponible\",\"data\": [";
        String seriesPrestados="{\"name\": \"prestados\",\"data\": [";
        String seriesAsignados="{\"name\": \"asignados\",\"data\": [";
        String seriesEnMantenimiento="{\"name\": \"En Mantenimiento\",\"data\": [";
        
        
        for (TipoEquipo tipoEquipo : listEqui) {
            long disponible=equipoDAO.countForTypeAndForGroup(tipoEquipo, 1);
            long noDisponible=equipoDAO.countForTypeAndForGroup(tipoEquipo, 3);
            long pretados=equipoDAO.countForTypeAndForStado(tipoEquipo, estEquipoDAO.findOne(3).orElse(null));
            long asignados=equipoDAO.countForTypeAndForStado(tipoEquipo, estEquipoDAO.findOne(4).orElse(null));
            long enMantenimiento=equipoDAO.countForTypeAndForStado(tipoEquipo, estEquipoDAO.findOne(2).orElse(null));
            
            if(count>0){
                               
                seriesDisponible +="," ;
                seriesNoDisponible+=",";
                seriesPrestados+=",";
                seriesAsignados+=",";
                seriesEnMantenimiento+=",";
            }
            
                seriesDisponible +=""+disponible+"" ;
                seriesNoDisponible+=""+noDisponible+"";
                seriesPrestados+=""+pretados+"";
                seriesAsignados+=""+asignados+""; 
                seriesEnMantenimiento+=""+enMantenimiento+"";
            count++;
        }                    
        seriesDisponible +="],\"stack\": \"Dis\"}" ;
        seriesNoDisponible+="],\"stack\": \"Dis\"}";
        seriesPrestados+="],\"stack\": \"det\"}";
        seriesAsignados+="],\"stack\": \"det\"}";
        seriesEnMantenimiento+="],\"stack\": \"man\"}";
        series += seriesDisponible+","+seriesNoDisponible+","+seriesPrestados+","+seriesAsignados+","+seriesEnMantenimiento+"]}";
        System.out.println(series);
        return series;
    }
    
}
