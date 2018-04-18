/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author yeo_sglo la classe Translate est un ManagedBean il nous permet de
 * controler l'internationnalisation dans notre projet
 */
@ManagedBean(name = "translateMB")
@SessionScoped
public class Translate implements Serializable {

    private String langue = "fr";

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getLangue() {
        return langue;
    }

    /**
     * cette methode met la valeur du champ langue en 'fr' l'orsque l'on click
     * sur le lien Francais de la page web
     *
     * @return null
     */
    public String inFrench() {
        setLangue("fr");
        return null;
    }

    /**
     * cette methode met la valeur du champ langue en 'en' l'orsque l'on click
     * sur le lien English de la page web
     *
     * @return null
     */
    public String inEnglish() {
        setLangue("en");
        return null;
    }

}
