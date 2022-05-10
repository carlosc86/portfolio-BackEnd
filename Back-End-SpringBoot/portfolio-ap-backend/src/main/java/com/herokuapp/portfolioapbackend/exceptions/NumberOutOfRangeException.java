/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.portfolioapbackend.exceptions;

/**
 *
 * @author carlos
 */
public class NumberOutOfRangeException extends Exception {
    
    public static final String DESCRIPCION="Numero fuera del rango permitido";

    public NumberOutOfRangeException() {
        super(DESCRIPCION);
    }

    public NumberOutOfRangeException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
    
}
