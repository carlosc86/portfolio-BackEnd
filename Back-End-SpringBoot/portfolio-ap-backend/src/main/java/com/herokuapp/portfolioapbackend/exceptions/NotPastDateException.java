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
public class NotPastDateException extends Exception {
    
    public static final String DESCRIPCION="La fecha no es pasado";

    public NotPastDateException() {
        super(DESCRIPCION);
    }

    public NotPastDateException(String detalle) {
        super(DESCRIPCION+". "+detalle);
    }
    
}
