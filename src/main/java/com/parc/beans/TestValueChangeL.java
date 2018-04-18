/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.beans;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * @author yeo_sglo
 */
public class TestValueChangeL implements ValueChangeListener{

    @Override
    public void processValueChange(ValueChangeEvent vce) throws AbortProcessingException {
        Object newValue = vce.getNewValue(); 
        System.out.println("**************************************");
        System.out.println("2 ième nvouvelle valeur :"+newValue);
        System.out.println("**************************************");
    }
    
}
