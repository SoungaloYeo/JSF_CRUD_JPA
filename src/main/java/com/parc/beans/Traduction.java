/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author yeo_sglo
 */
@ManagedBean(name = "traduction")
@ApplicationScoped
public class Traduction implements Serializable {

    private String localeCode = "fr";
    private static Map<String, String> mapCountryCode;

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public Map<String, String> getMapCountryCode() {
        return mapCountryCode;
    }

    public void setMapCountryCode(Map<String, String> mapCountryCode) {
        Traduction.mapCountryCode = mapCountryCode;
    }

    public Traduction() {
        mapCountryCode = new LinkedHashMap<>();
        mapCountryCode.put("français (fr)", "fr");
        mapCountryCode.put("englais (en)", "en");
    }

    public void changerLangue(ValueChangeEvent event) {
        localeCode = event.getNewValue().toString();
    }
}
