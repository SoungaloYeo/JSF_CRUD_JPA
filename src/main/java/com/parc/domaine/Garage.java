/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.domaine;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author yeo_sglo la classe Garage est un beans: anotation Entity champ
 * private getter et setter obligatoire constructeur par defaut au moin
 */
@Entity
public class Garage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "capacite")
    private Integer capacite;

    @OneToMany
    private List<Voiture> voitures;

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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    /**
     * le constructeur par defaud comme l'exige la definition d'un beans il rend
     * ainsi possible sa creation/getion automatique par le EntityManager et
     * conteneur d'application
     */
    public Garage() {
    }

    /**
     * Ce autre constructeur me permettra de creer en une ligne de code un
     * Garage avec des parametres
     *
     * @param nom Nom du garage
     * @param lieu Lieu du garage
     * @param capacite Capacite du garage
     * @param voitures les voitures du garage
     */
    public Garage(String nom, String lieu, Integer capacite, List<Voiture> voitures) {
        this.nom = nom;
        this.lieu = lieu;
        this.capacite = capacite;
        this.voitures = voitures;
    }

    /**
     * quand à ce constructeur il nous permettra d'avoir l'identifient d'un
     * objet Garage recuperé depuis la Base de donnée
     *
     * @param id Identifient du garage
     * @param nom Nom du garage
     * @param lieu Lieu du garage
     * @param capacite Capacite du garage
     * @param voitures les voitures du garage
     */
    public Garage(Long id, String nom, String lieu, Integer capacite, List<Voiture> voitures) {
        this.id = id;
        this.nom = nom;
        this.lieu = lieu;
        this.capacite = capacite;
        this.voitures = voitures;
    }

    /**
     * jutilise cette methode pour m'assurer de la vericité de mes données. Je
     * les affiches le plus souvent dans la console
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nGarage{" + "id=" + id + ", nom=" + nom + ", lieu=" + lieu + ","
                + " capacite=" + capacite + ", voitures=" + voitures + "}\n";
    }

}
