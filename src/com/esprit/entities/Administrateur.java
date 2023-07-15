/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author user
 */
public class Administrateur extends User {

    public Administrateur(int id, String Nom, String Prenom, String Adresse, String NomUtilisateur, String MotDePass, String Role,String Etat,String Mail) {
        super(id, Nom, Prenom, Adresse, NomUtilisateur, MotDePass, Role,Etat,Mail);
    }
    
    public Administrateur(String Nom, String Prenom, String Adresse, String NomUtilisateur, String MotDePass,String Role, String Etat,String Mail) {
        super(Nom, Prenom, Adresse , NomUtilisateur,MotDePass,Role, Etat,Mail);
    }   
}
