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
import com.esprit.entities.Coach;
import com.esprit.services.ServiceUser;


/**
 *
 * @author user
 */

public class AjoutCoachForm extends Form {

    private TextField tfNom;
    private TextField tfPrenom;
    private TextField tfAdresse;
    private TextField tfNomUtilisateur;
    private TextField tfMotDePass;
    private ComboBox<String> tfRole;
    private ComboBox<String> tfEtat;
    private TextField tfMail;
    private TextField tfSpecialite;    
    
    private Button btnAjout;

    private Form previousForm;

    public AjoutCoachForm(Form f) {
        super("Inscription", BoxLayout.y());
        previousForm = f;
        OnGui();
        addActions();
    }

    private void OnGui() {
        tfNom = new TextField(null, "Nom");
        tfPrenom = new TextField(null, "Prénom");
        tfAdresse = new TextField(null, "Adresse");
        tfNomUtilisateur = new TextField(null, "NomUtilisateur");
        tfMotDePass = new TextField(null, "MotDePass", 0, TextField.PASSWORD);
        tfRole = new ComboBox<>();
        tfRole.addItem("Adherent");
        tfRole.addItem("Coach");
        tfRole.setSelectedItem(HomeForm.tfRole.getSelectedItem());
        tfRole.setEnabled(false);
        tfEtat = new ComboBox<>();
        tfEtat.addItem("Activé");
        tfEtat.addItem("Desactivé");
        tfMail = new TextField(null, "Mail");
        tfSpecialite = new TextField(null, "Specialite");
        //tfPoids = new TextField(null, "Poids");
      //  tfTaille = new TextField(null, "Taille");
        //tfAbonnement = new TextField(null, "Abonnement");
        btnAjout = new Button("S'inscrire");
        this.addAll(tfNom, tfPrenom,tfAdresse,tfNomUtilisateur,tfMotDePass,tfRole,tfEtat,tfMail,tfSpecialite,btnAjout);
      
        /* if (tfRole.getSelectedItem().equals("Adherent")) {
           tfRole.setSelectedItem("Adherent");
        this.addAll(tfPoids,tfTaille, tfAbonnement, btnAjout); 
        }
      
        if (tfRole.getSelectedItem().equals("Coach")) {
          tfPoids.setVisible(false);
        this.addAll(tfSpecialite, btnAjout); } 
        */
        
    }

    private void addActions() {
        btnAjout.addActionListener((evt) -> {
            if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || tfAdresse.getText().isEmpty() || tfNomUtilisateur.getText().isEmpty() || tfMotDePass.getText().isEmpty() || tfRole.getSelectedItem().isEmpty() || tfEtat.getSelectedItem().isEmpty() || tfMail.getText().isEmpty() || tfSpecialite.getText().isEmpty()) {
                Dialog.show("Alerte", "Veuillez remplir tous les champs", "OK", null);
            } else {
                ServiceUser sp = new ServiceUser();
                
                if (sp.ajouter(new Coach(tfNom.getText(), tfPrenom.getText(), tfAdresse.getText(),tfNomUtilisateur.getText(), tfMotDePass.getText(),tfRole.getSelectedItem(), tfEtat.getSelectedItem(),tfMail.getText(),tfSpecialite.getText()))) {
                    Dialog.show("SUCCESS", "Coach ajouté !", "OK", null);
                     new HomeForm().show();
                } else {
                    Dialog.show("ERROR", "Erreur serveur", "OK", null);
                }   }
            });
        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previousForm.showBack();
        }); 
    }
    


    /*
    private void addActions() {
        Inscripition.addActionListener((evt) -> {
            if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || tfemail.getText().isEmpty()|| tfpassword.getText().isEmpty()  || tfrole.getSelectedItem().isEmpty() || tfnumber.getText().isEmpty()
                     || tfsexe.getText().isEmpty() || tfadresse.getText().isEmpty() ) {
                Dialog.show("Alerte", "Veillez remplir tous les champs", "OK", null);
            } else {
                serviceUtilisateur sp = new serviceUtilisateur();
                if (tfrole.getSelectedItem().equals("client"))
                {
                if (sp.ajouter(new Client(Integer.parseInt(tfnumber.getText()), tfsexe.getText(),tfadresse.getText(),tfNom.getText(), tfPrenom.getText(),tfemail.getText(), tfpassword.getText(),tfrole.getSelectedItem()))) {
                    Dialog.show("SUCCESS", "Client ajoutée !", "OK", null);
                }
                else
                {
                    
                    Dialog.show("ERROR", "Erreur serveur", "OK", null);
                }
                }
                
                
                
                else if(tfrole.getSelectedItem().equals("gestionnaire"))
                {
                    if(sp.ajouter( new Gestionnaire(Integer.parseInt(tfnumber.getText()),tfadresse.getText(),tfNom.getText(), tfPrenom.getText(),tfemail.getText(), tfpassword.getText(),tfrole.getSelectedItem())))
                {
                    Dialog.show("SUCCESS", "Gestionnaire ajoutée !", "OK", null);
                }
                else {
                    Dialog.show("ERROR", "Erreur serveur", "OK", null);
                }

            }
            }
        });

        this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previousForm.showBack();
        });
    } */
}
