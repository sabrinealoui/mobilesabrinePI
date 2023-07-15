/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.entities.Adherent;
//import com.esprit.entities.Adherent;
import com.esprit.entities.Coach;
import com.esprit.entities.User;
import com.esprit.services.ServiceUser;

/**
 *
 * @author user
 */
public class ModifUserForm extends Form {
    
    Button modifierButton = new Button("Modifier");
    Button btnRetour = new Button("Annuler");
    ServiceUser sp = new ServiceUser();
    public static User u = null;
    private Form previousForm;
    private TextField tfNom;
    private TextField tfPrenom;
    private TextField tfAdresse;
    private TextField tfNomUtilisateur;
    private TextField tfMotDePass;
    private ComboBox<String> tfRole;
    private ComboBox<String> tfEtat;
    private TextField tfMail;
    private TextField tfSpecialite;
    private TextField tfPoids;
    private TextField tfTaille;
    private TextField tfAbonnement;
    
    // String url = Statics.BASE_URL + "/id";
     // ConnectionRequest request = new ConnectionRequest();

    public ModifUserForm(User u) {
        super("Modifier", BoxLayout.y());
        this.u =u;
        OnGui();
        addActions();
    }
    
    private void OnGui() {
 
        tfNom = new TextField(u.getNom(), "Nom");
        tfPrenom = new TextField(u.getPrenom(), "PrÃ©nom");
        tfAdresse = new TextField(u.getAdresse(), "Adresse");
        tfNomUtilisateur = new TextField(u.getNomUtilisateur(), "Nom d'utilisateur");
        tfMotDePass= new TextField(u.getMotDePass(), "Mot de pass");
        tfRole = new ComboBox<>(String.valueOf(u.getRole()));
        tfEtat = new ComboBox<>(String.valueOf(u.getEtat()));
        tfEtat.addItem("Desactivé");
        tfMail = new TextField(u.getMail(), "Mail");
        //tfSpecialite = new TextField(((Coach)u).getSpecialite(), "SpecialitÃ©");
       // tfPoids = new TextField(String.valueOf(((Adherent)u).getPoids()), "Poids");
        //tfTaille = new TextField(String.valueOf(((Adherent)u).getTaille()), "Taille");
        //tfAbonnement = new TextField(((Adherent)u).getAbonnement(), "Abonnement");
       
         
        if (u.getRole().equals("Coach")){ 
            tfSpecialite = new TextField(((Coach)u).getSpecialite(), "Specialité");
            this.addAll(tfNom,tfPrenom,tfAdresse,tfNomUtilisateur,tfMotDePass,tfRole,tfEtat,tfMail,tfSpecialite,modifierButton);
            //Component[] components = {tfNom, tfPrenom,tfAdresse,tfNomUtilisateur,tfMotDePass,tfRole,tfEtat,tfMail,tfSpecialite, modifierButton, btnRetour};
            //Container container = new Container();
            //container.setLayout(BoxLayout.y());
            //container.addAll(components);

            //this.add(container);
        }else
        if (u.getRole().equals("Adherent")){
            tfPoids = new TextField(String.valueOf(((Adherent)u).getPoids()), "Poids");
            tfTaille = new TextField(String.valueOf(((Adherent)u).getTaille()), "Taille");
            tfAbonnement = new TextField(((Adherent)u).getAbonnement(), "Abonnement");
            this.addAll(tfNom,tfPrenom,tfAdresse,tfNomUtilisateur,tfMotDePass,tfRole,tfEtat,tfMail,tfPoids,tfTaille,tfAbonnement,modifierButton);
        
            /*  Component[] components = {tfNom, tfPrenom,tfAdresse,tfNomUtilisateur,tfMotDePass,tfRole,tfEtat,tfMail,tfPoids,tfTaille,tfAbonnement, modifierButton, btnRetour};
                Container container = new Container();
                container.setLayout(BoxLayout.y());
                container.addAll(components);

                this.add(container); */
        }
    }
     

    private void addActions() {
        
  modifierButton.addActionListener((evt) -> {
       
 /*   if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || tfAdresse.getText().isEmpty() || tfNomUtilisateur.getText().isEmpty() || tfMotDePass.getText().isEmpty() || tfRole.getSelectedItem().isEmpty() || tfEtat.getSelectedItem().isEmpty() || tfMail.getText().isEmpty() || tfSpecialite.getText().isEmpty() || Double.parseDouble(tfPoids.getText()) || Double.parseDouble(tfTaille.getText()) || tfAbonnement.getSelectedItem().isEmpty()) {
                Dialog.show("Alerte", "Veuillez remplir tous les champs", "OK", null);
        //return;
    } 
    else { */
        ServiceUser sp = new ServiceUser();
   boolean updateResult = sp.modifier(u);
            if (updateResult) {
                Dialog.show("Succès", "Modification effectuée avec succès", "OK", null);
                 new AffichageUserform(this).show();
            } else {
                Dialog.show("Erreur", "Echec de modification", "OK", null);
            }
     }); 
   
      
                  /*    if (sp.ajouter(new Coach(tfNom.getText(), tfPrenom.getText(), tfAdresse.getText(),tfNomUtilisateur.getText(), tfMotDePass.getText(),tfRole.getSelectedItem(), tfEtat.getSelectedItem(),tfMail.getText(),tfSpecialite.getText()))) {
                          Dialog.show("SUCCESS", "Coach ajouté !", "OK", null);
                          new HomeForm().show();
                      } else {
                          Dialog.show("ERROR", "Erreur serveur", "OK", null);
                  */

        btnRetour.addActionListener(e -> {
             previousForm.showBack();
        });
    }
   
}