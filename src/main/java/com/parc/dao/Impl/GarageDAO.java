/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.dao.Impl;

import com.parc.domaine.Garage;
import com.parc.dao.IGarageDAO;

/**
 *
 * @author yeo_sglo
 */

public class GarageDAO extends DAO<Garage, Long> implements IGarageDAO {

    public GarageDAO() {
        super(Garage.class);
    }

}
