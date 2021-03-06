/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.controller;

import com.herokuapp.portfolioapbackend.dto.AuthDTO;
import com.herokuapp.portfolioapbackend.dto.UsuarioDTO;
import com.herokuapp.portfolioapbackend.mappers.IUsuarioMapper;
import com.herokuapp.portfolioapbackend.model.Usuario;
import com.herokuapp.portfolioapbackend.security.JwtService;
import com.herokuapp.portfolioapbackend.security.MyUserDetails;
import com.herokuapp.portfolioapbackend.services.IUsuarioService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@CrossOrigin(origins="${portfolio.frontend.url}")
@RestController
public class AuthController {
    
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IUsuarioMapper usuarioMapper;
    @Autowired
    private JwtService jwt;
    
    
    @PostMapping("/auth")
    public AuthDTO login(@AuthenticationPrincipal MyUserDetails usuario) throws Exception{
        /*Este metodo es accesible con basic auth y devuelve un dto con datos del usuario y el token jwt*/
        AuthDTO auth=new AuthDTO();//Se crea aca, pues no necesita mapper
        /*Busco el usuario para generar el dto que se devuelve*/
        Usuario usuarioGuardado=usuarioService.traer(usuario.getUsername());
        usuarioGuardado.setUltimoAcceso(LocalDateTime.now());//Marco su acceso
        usuarioService.modificar(usuarioGuardado);//actualizo los datos del usuario
        auth.setUsuario(usuarioMapper.toDTO(usuarioGuardado));
        /*Asigno el token para devolverselo al frontend*/
        auth.setToken(jwt.createToken(usuario.getUsername(), 
                                     usuarioGuardado.getPrivilegios().getNombre()));
        return auth;        
    }
    
    @PostMapping("/auth/logout")
    public void logout(UsuarioDTO usuario){
        /*Por ahora no se hace nada en el backend al desloguear,
         *Pero tal vez se podria inhabilitar el token.
        */
        
    }
    
    
}
