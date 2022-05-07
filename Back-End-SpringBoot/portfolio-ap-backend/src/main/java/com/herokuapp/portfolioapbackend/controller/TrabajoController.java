/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.ExperienciaLaboralDTO;
import com.herokuapp.portfolioapbackend.mappers.IExperienciaLaboralMapper;
import com.herokuapp.portfolioapbackend.model.Trabajo;
import com.herokuapp.portfolioapbackend.services.ITrabajoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@CrossOrigin(origins="http://localhost:4200")//Por ahora asi para poder usar angular
@RestController
public class TrabajoController {
    
    @Autowired
    private IExperienciaLaboralMapper experienciaMapper;
    
    @Autowired
    private ITrabajoService trabajoService;
    
    
    @GetMapping("/experiencias")
    public List<ExperienciaLaboralDTO> getTrabajo(){
        List<Trabajo> lista= trabajoService.traer();
        List<ExperienciaLaboralDTO> retorno=new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(experienciaMapper.toDTO(lista.get(i)));
        }
        return retorno;
    }
    
    @GetMapping("/experiencias/{id}")
    public ExperienciaLaboralDTO getTrabajo(@PathVariable Long id)throws Exception{
        return experienciaMapper.toDTO(trabajoService.traer(id));
    }
    
    @PostMapping("/experiencias")
    public ExperienciaLaboralDTO postTrabajo(@RequestBody ExperienciaLaboralDTO experiencia ){
        /*Lo convierto en entidad, lo guardo, lo vuelvo a convertir a dto y lo devuelvo*/
        return experienciaMapper.toDTO(trabajoService.guardar(experienciaMapper.toEntity(experiencia)));
    }
    
    @PutMapping("/experiencias/{id}")
    public void putTrabajo(@PathVariable Long id, @RequestBody ExperienciaLaboralDTO experiencia )throws Exception{
        if(id==experiencia.getId())
            trabajoService.modificar(experienciaMapper.toEntity(experiencia));
    }
    
    @DeleteMapping("/experiencias/{id}")
    public void delete(@PathVariable Long id){
        trabajoService.borrar(id);
    }
    
    
}