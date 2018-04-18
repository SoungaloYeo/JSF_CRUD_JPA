/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.domaine;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author yeo_sglo la classe Voiture est un beans: anotation Entity champ
 * private getter et setter obligatoire constructeur par defaut au moin
 */
@Entity
public class Voiture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "immat")
    private String immat;

    @Column(name = "marque")
    private String marque;

    @Column(name = "couleur")
    private String couleur;

    @OneToOne
    @JoinColumn(name = "id_chauffeur")
    private Chauffeur chauffeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    /**
     * le constructeur par defaud comme l'exige la definition d'un beans il rend
     * ainsi possible sa creation/getion automatique par le EntityManager et
     * conteneur d'application
     */
    public Voiture() {
    }

    /**
     * Ce autre constructeur me permettra de creer en une ligne de code un
     * Voiture avec des parametres
     *
     * @param immat l'Immatriculation de la voiture
     * @param marque la Marque de la voiture
     * @param couleur la Couleur de la voiture
     * @param chauffeur le chauffeur à qui es assigné la voiture
     */
    public Voiture(String immat, String marque, String couleur, Chauffeur chauffeur) {
        this.immat = immat;
        this.marque = marque;
        this.couleur = couleur;
        this.chauffeur = chauffeur;
    }

    /**
     * quand à ce constructeur il nous permettra d'avoir l'identifient d'un
     * objet Voiture recuperé depuis la Base de donnée
     *
     * @param id l'Identifient de la voiture
     * @param immat l'Immatriculation de la voiture
     * @param marque la Marque de la voiture
     * @param couleur la Couleur de la voiture
     * @param chauffeur le chauffeur à qui es assigné la voiture
     */
    public Voiture(Long id, String immat, String marque, String couleur, Chauffeur chauffeur) {
        this.id = id;
        this.immat = immat;
        this.marque = marque;
        this.couleur = couleur;
        this.chauffeur = chauffeur;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + id + ", immat=" + immat + ", marque=" + marque + ", couleur=" + couleur + ", chauffeur=" + chauffeur + "}\n";
    }

    
    
}
