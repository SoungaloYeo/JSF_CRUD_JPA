/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service;

import com.parc.domaine.Voiture;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yeo_sglo IVoitureService est l'interface propre à la classe
 * Voiture. C'est ici qu'on mettra les methodes portant uniquement sur le
 * classe Voiture. Dans ce projet nous faisons juste un CRUD commun à toutes
 * les classes. les methode sont donc dans l'interface IService qu'ettend IVoitureService
 */
public interface IVoitureService extends IService<Voiture, Long>{
    
    public List<String> immatMarque();
    public Map<String, Long> mapVoiture();
    public List<Voiture> findRange(List<Long> id);
    
}
