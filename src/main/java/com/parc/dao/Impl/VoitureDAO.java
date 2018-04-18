/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.dao.Impl;

import com.parc.domaine.Voiture;
import com.parc.dao.IVoitureDAO;

/**
 *
 * @author yeo_sglo
 */
public class VoitureDAO extends DAO<Voiture, Long> implements IVoitureDAO {

    public VoitureDAO() {
        super(Voiture.class);
    }

   
}
