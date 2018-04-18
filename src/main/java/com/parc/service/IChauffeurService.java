/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service;

import com.parc.domaine.Chauffeur;
import java.util.Map;

/**
 *
 * @author yeo_sglo IChauffeurService est l'interface propre à la classe
 * Chauffeur. C'est ici qu'on mettra les methodes portant uniquement sur le
 * classe Chauffeur. Dans ce projet nous faisons juste un CRUD commun à toutes
 * les classes. les methode sont donc dans l'interface IService qu'ettend IChauffeurService
 */
public interface IChauffeurService extends IService<Chauffeur, Long> {
    
    public Map<String, Long> listNomPrenom();

}
