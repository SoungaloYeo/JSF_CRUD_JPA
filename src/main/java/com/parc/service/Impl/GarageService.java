/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service.Impl;

import com.parc.dao.Impl.GarageDAO;
import com.parc.domaine.Garage;
import com.parc.service.IGarageService;
import com.parc.dao.IGarageDAO;
import com.parc.domaine.Voiture;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yeo_sglo
 */
public class GarageService extends Service<Garage, Long> implements IGarageService {

    public GarageService() {
        this.dao = new GarageDAO();
    }

    public GarageService(IGarageDAO garageDao) {
        super(garageDao);
    }

    @Override
    public List<Long> idGarage(Garage g) {
        List<Long> listId = new ArrayList<>();
        for (Voiture voiture : g.getVoitures()) {
            listId.add(voiture.getId());
        }
        return listId;
    }

    @Override
    public List<Long> convertListStringToLong(List<String> strList) {
        List<Long> longList = new ArrayList<>();
        //utilisation des lambdas 1.8
        //strList.forEach(s -> longList.add(Long.valueOf(s)));
        for (String string : strList) {
            longList.add(Long.valueOf(string));
        }
        return longList;
    }

}
