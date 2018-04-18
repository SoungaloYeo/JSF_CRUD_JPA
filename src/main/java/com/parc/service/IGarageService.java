/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service;

import com.parc.domaine.Garage;
import java.util.List;

/**
 *
 * @author yeo_sglo IGarageService est l'interface propre à la classe Garage.
 * C'est ici qu'on mettra les methodes portant uniquement sur le classe Garage.
 * Dans ce projet nous faisons juste un CRUD commun à toutes les classes. les
 * methode sont donc dans l'interface IService qu'ettend IGarageService
 */
public interface IGarageService extends IService<Garage, Long> {

    public List<Long> idGarage(Garage g);
    public List<Long> convertListStringToLong(List<String> strList);

}
