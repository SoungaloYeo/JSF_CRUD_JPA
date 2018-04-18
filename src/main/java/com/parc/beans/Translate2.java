/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

/**
 *
 * @author yeo_sglo
 */
@ManagedBean(name = "translate")
@SessionScoped
public class Translate2 implements ValueChangeListener, Serializable {

    private String langue = "fr";
    private String francais = "fr";
    private String engish = "en";

    public String getFrancais() {
        return francais;
    }

    public void setFrancais() {
        this.langue = "fr";
    }

    public String getEngish() {
        return engish;
    }

    public void setEngish() {
        this.langue = "en";
    }
    
    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Translate2() {
    }

    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        this.langue = event.getNewValue().toString();
        System.out.println("==============================");
        System.out.println("LANGUE :" + this.langue);
        System.out.println("==============================");
    }
}
