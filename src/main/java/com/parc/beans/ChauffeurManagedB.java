package com.parc.beans;

import com.parc.domaine.Chauffeur;
import com.parc.service.IChauffeurService;
import com.parc.service.Impl.ChauffeurService;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author yeo_sglo la classe ChauffeurManagedB est un ManagerBeans un sort de
 * controleur propre a notre classe Chauffeur. c'est elle qui sera appelée
 * depuis le web pour fournir ou recuperer des données.
 */
@ManagedBean(name = "chauffeurMB")
@RequestScoped
public class ChauffeurManagedB implements Serializable {

    /**
     * ce champ nous permettra de recuperer ou modifier les champs de la classe
     * Chauffeur depuis le web grace aux setteur et getteurs declaré dans ce
     * POJO
     */
    private Chauffeur c;
    private Map<String, Long> mapChauffeurs;

    public Map<String, Long> getMapChauffeurs() {
        mapChauffeurs = chauffeurService.listNomPrenom();
        return mapChauffeurs;
    }

    public void setMapChauffeurs(Map<String, Long> mapChauffeurs) {
        this.mapChauffeurs = mapChauffeurs;
    }

    /**
     * pouvoir beneficier des savoir faires de notre logic Metier via
     * l'interface IChauffeurService
     */
    private IChauffeurService chauffeurService;

    public Chauffeur getC() {
        return c;
    }

    public void setC(Chauffeur c) {
        this.c = c;
    }

    public IChauffeurService getChauffeurService() {
        return chauffeurService;
    }

    public void setChauffeurService(IChauffeurService chauffeurService) {
        this.chauffeurService = chauffeurService;
    }

    public List<Chauffeur> getListChauffeur() {
        mapChauffeurs = chauffeurService.listNomPrenom();
        return chauffeurService.findAll();
    }

    /**
     * constructeur par defaut appelé de façon automatique par le conteneur.
     * nous y profitons pour initialiser nos objet chauffeurService et c
     */
    public ChauffeurManagedB() {
        chauffeurService = new ChauffeurService();
        c = new Chauffeur();
        mapChauffeurs = new LinkedHashMap<String, Long>();
    }

    /**
     * permet de recuperer l'etat du chauffeur selectioner dans le web puis le
     * transmet dans notre ManagedBean et retourne la page à afficher qui est
     * ici la page de modification d'un Chauffeu
     *
     * @param cSelect represente le chauffeur à modifier
     * @return update_chauffeur
     */
    public String selected(Chauffeur cSelect) {
        setC(cSelect);
        return "update_chauffeur";
    }

    /**
     * cette methode nous permet d'annuler une operation l'orsque l'utilisateur
     * a devant lui un formulaire de modification/suppression dans notre cas.
     *
     * @return list_chauffeur
     */
    public String annuler() {
        c = null;
        return null;
    }

    /**
     * Ajout d'un Chauffeur. on fait appelle à la methode add de notre logic
     * Metier en lui passant en parametre l'objet à ajouter
     *
     * @return list_chauffeur
     */
    public String add() {
        chauffeurService.save(this.c);
        c = null;
        return "list_chauffeur";
    }

    /**
     * modiffication d'un Chauffeur. on fait appelle à la methode update de
     * notre logic Metier en lui passant en parametre l'objet à modifier
     *
     * @return list_chauffeur
     */
    public String update() {
        chauffeurService.update(this.c);
        c = null;
        return "list_chauffeur";
    }

    /**
     * suppression d'un Chauffeur. on fait appelle à la methode deleteByEntity
     * de notre logic Metier en lui passant en parametre l'objet à supprimer qui
     * a été recuperé depuis le web
     *
     * @param c represente l'objet chauffeur à supprimer
     * @return list_chauffeur
     */
    public String delete(Chauffeur c) {
        chauffeurService.delete(c);
        setC(null);
        return "list_chauffeur";
    }

    /**
     * affichage de tous les chauffeurs. on fait appelle à la methode findAll de
     * notre logic Metier
     *
     * @return chauffeurService.findAll
     */
    public List<Chauffeur> findAll() {
        return chauffeurService.findAll();
    }

}
