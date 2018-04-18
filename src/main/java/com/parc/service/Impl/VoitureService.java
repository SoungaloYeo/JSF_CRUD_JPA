/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service.Impl;

import com.parc.dao.Impl.VoitureDAO;
import com.parc.domaine.Voiture;
import com.parc.service.IVoitureService;
import javax.ejb.Stateless;
import com.parc.dao.IVoitureDAO;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yeo_sglo
 */
@Stateless
public class VoitureService extends Service<Voiture, Long> implements IVoitureService {

    public VoitureService() {
        this.dao = new VoitureDAO();
    }

    public VoitureService(IVoitureDAO voitureDao) {
        super(voitureDao);
    }

    @Override
    public List<String> immatMarque() {
        List<String> listVoiture = new ArrayList<String>();
        for (Voiture voiture : findAll()) {
            listVoiture.add(voiture.getImmat() + " " + voiture.getMarque());
        }
        return listVoiture;
    }

    @Override
    public Map<String, Long> mapVoiture() {
        Map<String, Long> map = new LinkedHashMap<>();
        for (Voiture voiture : findAll()) {
            map.put(voiture.getImmat() + " " + voiture.getMarque(), voiture.getId());
        }
        return map;
    }

    @Override
    public List<Voiture> findRange(List<Long> myId) {
        List<Voiture> listV = new ArrayList<>();
        for (Long lg : myId) {
            listV.add(findOne(lg));
        }
        return listV;
    }

}
