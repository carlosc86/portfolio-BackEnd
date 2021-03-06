/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.services;

import com.herokuapp.portfolioapbackend.exceptions.HabilidadNotFoundException;
import com.herokuapp.portfolioapbackend.model.Habilidad;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IHabilidadService {
    public List<Habilidad> traer();
    public Habilidad traer(Long id)throws HabilidadNotFoundException;
    public Habilidad guardar(Habilidad habilidad);
    public void modificar(Habilidad habilidad)throws HabilidadNotFoundException;
    public void borrar(Long id);
    
}
