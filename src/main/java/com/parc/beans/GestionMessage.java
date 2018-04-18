/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author yeo_sglo
 */
@ManagedBean
@RequestScoped
public class GestionMessage{
    private String messageRequit;

    public String getMessageRequit() {
        return "veillez renseigne ce champs";
    }

    public void setMessageRequit(String messageRequit) {
        this.messageRequit = messageRequit;
    }

    public GestionMessage() {
    }
    
    
}
