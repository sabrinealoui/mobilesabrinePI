/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author user
 */
public class Coach extends User {
    private String Specialite ;
    
    
    
    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }

    public Coach(String Nom, String Prenom, String Adresse, String NomUtilisateur, String MotDePass, String Role,String Etat, String Mail,String Specialite) {
        super(Nom, Prenom, Adresse, NomUtilisateur, MotDePass, Role, Etat,Mail);
        this.Specialite = Specialite;
    }

    public Coach(int id, String Nom, String Prenom, String Adresse, String NomUtilisateur, String MotDePass, String Role, String Etat,String Mail,String Specialite) {
        super(id, Nom, Prenom, Adresse, NomUtilisateur, MotDePass, Role, Etat,Mail);
        this.Specialite = Specialite;
    }
    
}

    

