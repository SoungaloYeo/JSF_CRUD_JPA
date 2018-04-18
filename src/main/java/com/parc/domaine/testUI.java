/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.domaine;

import com.parc.dao.Impl.SingletonEMF;
import com.parc.service.IChauffeurService;
import com.parc.service.IGarageService;
import com.parc.service.IVoitureService;
import com.parc.service.Impl.ChauffeurService;
import com.parc.service.Impl.GarageService;
import com.parc.service.Impl.VoitureService;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author yeo_sglo
 */
public class testUI {

    public static void main(String[] args) {

        EntityManager em = SingletonEMF.getEntityManagerFactory().createEntityManager();
//
//        Chauffeur ch1 = new Chauffeur("KOUASSI", "MARC ARNAUD", (new Date()));
//        Chauffeur ch2 = new Chauffeur("KONAN", "KOFFI ASALE", (new Date()));
//        Chauffeur ch3 = new Chauffeur("DIABATE", "GNAMAN LOKO", (new Date()));
//        Chauffeur ch4 = new Chauffeur("COULIBALY", "OUMAR PRESI", (new Date()));
//
//        Voiture v1 = new Voiture("7777 IM01", "B M W", "ROUGE", ch1);
//        Voiture v2 = new Voiture("8888 IM02", "TOYOTA", "NOIRE", ch2);
//        Voiture v3 = new Voiture("9999 IM03", "RENAULD", "BLANCHE", ch3);
//        Voiture v4 = new Voiture("6666 IM04", "F O R D", "GRIS", ch4);
//
//        List<Voiture> listV1 = new LinkedList<>();
//        listV1.add(v1);
//        listV1.add(v2);
//
//        List<Voiture> listV2 = new LinkedList<>();
//        listV2.add(v3);
//        listV2.add(v4);
//
//        Garage g1 = new Garage("LE GARAGE DES CHOCO", "COCODY", 10, listV1);
//        Garage g2 = new Garage("LE GRAND GARAGE", "YOPOUGON", 20, listV2);
//
//        //persistance des donnees
//        em.getTransaction().begin();
//        em.persist(ch1);
//        em.persist(ch2);
//        em.persist(ch3);
//        em.persist(ch4);
//        em.flush();
//
//        em.persist(v1);
//        em.persist(v2);
//        em.persist(v3);
//        em.persist(v4);
//        em.flush();
//
//        em.persist(g1);
//        em.persist(g2);
//
//        em.getTransaction().commit();
        
//        System.out.println("LISTE DES CHAUFFEURS");
        IChauffeurService chauffeurService = new ChauffeurService();
//        System.out.println(chauffeurService.findAll());
//        Chauffeur c = new Chauffeur("YAO", "KOUADIO", new Date());//        
//        chauffeurService.add(c);
//        System.out.println("LISTE DES VOITURES");
        IVoitureService VoitureService = new VoitureService();
//        System.out.println(VoitureService.findAll());
//        
//        System.out.println("LISTE DES GARAGES");
        IGarageService garageService = new GarageService();
//        System.out.println(garageService.findAll());

        //RETOURNER UN ELEMENT
        System.out.println("RETOURNER UN ELEMENT");
        System.out.println("=============================");
        System.out.println(garageService.count());
        System.out.println("=============================");
        //garageService.deleteAll();
        System.out.println(garageService.count());
        System.out.println("=============================");

//        em.close();
        SingletonEMF.getEntityManagerFactory().close();

    }
}
