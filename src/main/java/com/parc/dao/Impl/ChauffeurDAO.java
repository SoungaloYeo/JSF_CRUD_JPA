/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.dao.Impl;

import com.parc.domaine.Chauffeur;
import java.util.Collection;
import javax.persistence.Query;
import com.parc.dao.IChauffeurDAO;

/**
 *
 * @author yeo_sglo la classe ChauffeurService est un EJB Stateless dont l'etat
 * n'est pas conservé
 */
public class ChauffeurDAO extends DAO<Chauffeur, Long> implements IChauffeurDAO {

    public ChauffeurDAO() {
        super(Chauffeur.class);
    }

    @Override
    public Collection<Chauffeur> getAllByName(String name) {
        Query query = null;
        if (!name.isEmpty() && name != null) {
            try {
            query = (Query) em.createQuery("SELECT c FROM Chauffeur c WHERE c.nom LIKE %" + name + "%");
                
            } catch (Exception e) {
               // throw BusynessException("", e);
            }
        }
        return executeQuery(query);
    }
}
