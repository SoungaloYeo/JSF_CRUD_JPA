/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.beans;

import com.parc.dao.Impl.VoitureDAO;
import com.parc.domaine.Garage;
import com.parc.service.IGarageService;
import com.parc.service.IVoitureService;
import com.parc.service.Impl.GarageService;
import com.parc.service.Impl.VoitureService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author yeo_sglo la classe GarageManagedB est un ManagerBeans un sort de
 * controleur propre a notre classe Garage. c'est elle qui sera appelée depuis
 * le web pour fournir ou recuperer des données.
 */
@ManagedBean(name = "garageMB")
@RequestScoped
public class GarageManagedB implements Serializable {

    /**
     * pouvoir beneficier des savoir faires de notre logic Metier via
     * l'interface IGarageService
     */
    private IGarageService garageService;
    private IVoitureService voitureService;
    private List<Long> selectedCars = new ArrayList<>();
    private String showDetail;
    private List<String> listVoiture;
    private Map<String, Long> mapVoiture;
    private Garage g;

    public Map<String, Long> getMapVoiture() {
        mapVoiture = voitureService.mapVoiture();
        return mapVoiture;
    }

    public void setMapVoiture(Map<String, Long> mapVoiture) {
        this.mapVoiture = mapVoiture;
    }

    public List<Long> getSelectedCars() {        
        return selectedCars;
    }

    public void setSelectedCars(List<Long> selectedCars) {
        this.selectedCars = selectedCars;
    }

    public List<String> getListVoiture() {
        listVoiture = voitureService.immatMarque();
        return listVoiture;
    }

    public void setListVoiture(ArrayList<String> listVoiture) {
        this.listVoiture = listVoiture;
    }

    public String getShowDetail() {
        return showDetail;
    }

    /**
     * ce objet nous permettra de recuperer ou modifier les champs de la classe
     * Garage depuis le web grace aux setteur et getteurs declarés dans celui-ci
     */
    public Garage getG() {
        return g;
    }

    public void setG(Garage g) {
        this.g = g;
    }

    public List<Garage> getListGarage() {
        return garageService.findAll();
    }

    /**
     * constructeur par defaut appelé de façon automatique par le conteneur.
     * nous y profitons pour initialiser nos objet garageService et g
     */
    public GarageManagedB() {
        garageService = new GarageService();
        voitureService = new VoitureService(new VoitureDAO());
        g = new Garage();
    }

    /**
     * cette methode nous permet d'annuler une operation l'orsque l'utilisateur
     * a devant lui un formulaire de modification/suppression dans notre cas.
     *
     * @return list_garage
     */
    public String annuler() {
        g = null;
        return null;
    }

    /**
     * Ajout d'un Garage. on fait appelle à la methode add de notre logic Metier
     * en lui passant en parametre l'objet à ajouter
     *
     * @return list_garage
     */
    public String add() {
        garageService.save(g);
        g = new Garage();
        showDetail = "";
        return "list_garage";
    }

    /**
     * permet de recuperer l'etat du Garage selectioner dans le web puis le
     * transmet dans notre ManagedBean et retourne la page à afficher qui est
     * ici la page de modification d'un Garage
     *
     * @param gSelect represente l'objet garage qui a ete selectionné dans le
     * web
     * @return update_garage
     */
    public String selected(Garage gSelect) {
        setG(gSelect);
        selectedCars = garageService.idGarage(gSelect);
        return "update_garage";
    }

    public String detail(Garage gSelect) {
        setG(gSelect);
        showDetail = "exist";
        return null;
    }

    /**
     * modiffication d'un Garage. on fait appelle à la methode update de notre
     * logic Metier en lui passant en parametre l'objet à modifier
     *
     * @return list_garage
     */
    public String update() {
//        selectedCars = garageService.convertListStringToLong(selectedCars);
//        g.setVoitures(voitureService.findRange(selectedCars));
//        garageService.update(g);
        return "list_garage";
    }

    /**
     * /**
     * suppression d'un Garage. on fait appelle à la methode deleteByEntity de
     * notre logic Metier en lui passant en parametre l'objet à supprimer qui a
     * été recuperé depuis le web
     *
     * @param gDelete represente l'objet garage à supprimer
     * @return list_garage
     */
    public String delete(Garage gDelete) {
        garageService.delete(gDelete);
        showDetail = "";
        return "list_garage";
    }

    /**
     * affichage de tous les chauffeurs. on fait appelle à la methode findAll de
     * notre logic Metier
     *
     * @return garageService.findAll
     */
    public List<Garage> findAll() {
        showDetail = "";
        return garageService.findAll();
    }
}
