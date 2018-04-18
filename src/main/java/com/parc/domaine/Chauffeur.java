/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.domaine;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yeo_sglo la classe Chauffeur est un beans: anotation Entity champ
 * private getter et setter obligatoire constructeur par defaut au moin
 */
@Entity
public class Chauffeur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    /**
     * le constructeur par defaud comme l'exige la definition d'un beans il rend
     * ainsi possible sa creation/getion automatique par le EntityManager et
     * conteneur d'application
     */
    public Chauffeur() {
    }

    /**
     * Ce autre constructeur me permettra de creer en une ligne de code un
     * chauffeur avec des parametres
     *
     * @param nom Nom du chauffeur
     * @param prenom Prenom du chauffeur
     * @param dateEmbauche Date d'embauche du chauffeur
     */
    public Chauffeur(String nom, String prenom, Date dateEmbauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
    }

    /**
     * quand à ce constructeur il nous permettra d'avoir l'identifient d'un
     * objet Chauffeur recuperé depuis la Base de donnée
     *
     * @param id Identifient du chauffeur
     * @param nom Nom du chauffeur
     * @param prenom Prenom du chauffeur
     * @param dateEmbauche Date d'embauche du chauffeur
     */
    public Chauffeur(Long id, String nom, String prenom, Date dateEmbauche) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
    }

    /**
     * jutilise cette methode pour m'assurer de la vericité de mes données. Je
     * les affiches le plus souvent dans la console
     *
     * @return une de caractaire
     */
    @Override
    public String toString() {
        return "Chauffeur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateEmbauche=" + dateEmbauche + "}\n";
    }

}
