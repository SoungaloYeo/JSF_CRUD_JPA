/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.beans;

import com.parc.domaine.Voiture;
import com.parc.service.Impl.ChauffeurService;
import com.parc.service.Impl.VoitureService;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 * @author yeo_sglo la classe VoitureManagedB est un ManagerBeans un sort de
 * controleur propre a notre classe Voiture. c'est elle qui sera appelée depuis
 * le web pour fournir ou recuperer des données.
 */
@ManagedBean(name = "voitureMB")
@RequestScoped
public class VoitureManagedB implements Serializable {

    /**
     * pouvoir beneficier des savoir faires de notre logic Metier via
     * l'interface VoitureService
     */
    private VoitureService voitureService;
    private ChauffeurService chauffeurService;
    private Map<String, Long> mapChauffeurs;
    private Long idChauffeur;

    public Long getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(Long idChauffeur) {
        this.idChauffeur = idChauffeur;
    }
    

    public Map<String, Long> getMapChauffeurs() {
        mapChauffeurs = chauffeurService.listNomPrenom();
        return mapChauffeurs;
    }

    /**
     * ce champ nous permettra de recuperer ou modifier les champs de la classe
     * Voiture depuis le web grace aux setteur et getteurs declaré dans celui-ci
     */
    private Voiture v;

    public Voiture getV() {
        return v;
    }

    public void setV(Voiture v) {
        this.v = v;
    }

    public List<Voiture> getListVoiture() {
        return voitureService.findAll();
    }

    public VoitureManagedB() {
        voitureService = new VoitureService();
        v = new Voiture();
        chauffeurService = new ChauffeurService();
        mapChauffeurs = new LinkedHashMap<String, Long>();
    }

    /**
     * cette methode nous permet d'annuler une operation l'orsque l'utilisateur
     * a devant lui un formulaire de modification/suppression dans notre cas.
     *
     * @return list_voiture
     */
    public String annuler() {
        v = null;
        return "list_voiture";
    }

    /**
     *
     * permet de recuperer l'etat du Voiture selectioner dans le web puis le
     * transmet dans notre ManagedBean et retourne la page à afficher qui est
     * ici la page de modification d'une Voiture
     *
     * @param vSelect represente l'objet voiture qui a ete selectionné
     * @return update_voiture
     */
    public String selected(Voiture vSelect) {
        setIdChauffeur(vSelect.getChauffeur().getId());
        setV(vSelect);
        return "update_voiture";
    }

    public void changerChauffeur(ValueChangeEvent event){
        idChauffeur = (Long) event.getNewValue();
    }
    
    /**
     * Ajout d'un Voiture. on fait appelle à la methode add de notre logic
     * Metier en lui passant en parametre l'objet à ajouter
     *
     * @return list_voiture
     */
    public String add() {
        v.setChauffeur(chauffeurService.findOne(idChauffeur));
        voitureService.save(v);
        v = null;
        return "list_voiture";
    }

    /**
     * modiffication d'un Voiture. on fait appelle à la methode update de notre
     * logic Metier en lui passant en parametre l'objet à modifier
     *
     * @return list_voiture
     */
    public String update() {
        v.setChauffeur(chauffeurService.findOne(idChauffeur));
        voitureService.update(v);
        v = null;
        return "list_voiture";
    }

    /**
     * suppression d'un Chauffeur. on fait appelle à la methode deleteByEntity
     * de notre logic Metier en lui passant en parametre l'objet à supprimer qui
     * a été recuperé depuis le web
     *
     * @param v represente l'objet voiture à supprimer
     * @return list_voiture
     */
    public String delete(Voiture v) {
        voitureService.delete(v);
        return "list_voiture";
    }

    /**
     * affichage de tous les chauffeurs. on fait appelle à la methode findAll de
     * notre logic Metier
     *
     * @return voitureService.findAll
     */
    public List<Voiture> findAll() {
        return voitureService.findAll();
    }

}
