/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service.Impl;

import com.parc.dao.Impl.ChauffeurDAO;
import com.parc.domaine.Chauffeur;
import com.parc.service.IChauffeurService;
import com.parc.dao.IChauffeurDAO;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yeo_sglo la classe ChauffeurService est un EJB Stateless dont l'etat
 * n'est pas conservé
 */
public class ChauffeurService extends Service<Chauffeur, Long> implements IChauffeurService {

    public ChauffeurService() {
        this.dao = new ChauffeurDAO();
    }

    public ChauffeurService(IChauffeurDAO chauffeurDao) {
        super(chauffeurDao);
    }

    @Override
    public Map<String, Long> listNomPrenom() {
        Map<String, Long> myMap = new LinkedHashMap<>();
        List<Chauffeur> findAll = findAll();
        for (Chauffeur c : findAll) {
            myMap.put(c.getNom() + " " + c.getPrenom(), c.getId());
        }
        return myMap;
    }

}
