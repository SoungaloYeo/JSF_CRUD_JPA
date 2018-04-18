/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.exception;

/**
 *
 * @author yeo_sglo
 */
public class BusynessException extends RuntimeException{

    public BusynessException(String message) {
        super(message);
    }

    public BusynessException(Throwable cause) {
        super(cause);
    }
    
    
}
