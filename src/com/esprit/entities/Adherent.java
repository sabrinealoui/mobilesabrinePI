/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author user
 */
public class Adherent extends User {
    double Poids;
    double Taille;
    String Abonnement ; 
   

    public double getPoids() {
        return Poids;
    }

    public void setPoids(double Poids) {
        this.Poids = Poids;
    }

    public double getTaille() {
        return Taille;
    }

    public void setTaille(double Taille) {
        this.Taille = Taille;
    }

    public String getAbonnement() {
        return Abonnement;
    }

    public void setAbonnement(String Abonnement) {
        this.Abonnement = Abonnement;
    }

    public Adherent(String Nom, String Prenom, String Adresse, String NomUtilisateur, String Motdepass, String Role, String Etat,String Mail,double Poids, double Taille, String Abonnement) {
        super(Nom, Prenom, Adresse, NomUtilisateur, Motdepass, Role, Etat, Mail);
        this.Poids = Poids;
        this.Taille = Taille;
        this.Abonnement = Abonnement;
    }

    public Adherent(int id, String Nom, String Prenom, String Adresse, String NomUtilisateur, String MotDePass, String Role, String Etat,String Mail,double Poids, double Taille, String Abonnement) {
        super(id, Nom, Prenom, Adresse, NomUtilisateur, MotDePass, Role, Etat,Mail);
        this.Poids = Poids;
        this.Taille = Taille;
        this.Abonnement = Abonnement;
    }  
}
