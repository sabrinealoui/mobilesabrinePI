/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author user
 */
public abstract class User {
    private int id;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String NomUtilisateur;
    private String MotDePass;
    private String Role;
    private String Etat;
    private String Mail;

    
    public static User u;
    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getMotDePass() {
        return MotDePass;
    }

    public void setMotDePass(String MotDePass) {
        this.MotDePass = MotDePass;
    }

    public String getNomUtilisateur() {
        return NomUtilisateur;
    }

    public void setNomUtilisateur(String NomUtilisateur) {
        this.NomUtilisateur = NomUtilisateur;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public User() {
    }

    public User(String Nom, String Prenom, String Adresse, String NomUtilisateur, String MotDePass ,String Role,String Etat, String Mail) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.NomUtilisateur = NomUtilisateur;
        this.MotDePass = MotDePass;
        this.Role = Role;
        this.Etat = Etat;
        this.Mail = Mail;
    }

    public User(int id, String Nom, String Prenom, String Adresse, String NomUtilisateur, String MotDePass,String Role, String Etat, String Mail) {
        this.id= id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.NomUtilisateur = NomUtilisateur;
        this.MotDePass = MotDePass;
        this.Role = Role;
        this.Etat = Etat;
        this.Mail = Mail;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + ", NomUtilisateur=" + NomUtilisateur + ", MotDePass=" + MotDePass + ", Role=" + Role + ", Etat=" + Etat + ", Mail=" + Mail + '}';
    }
    }
