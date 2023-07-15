/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.services.ServiceUser;

/**
 *
 * @author user
 */
public class HomeForm extends BaseForm {
    private Button btnLogin;
    private Button btnAddUser;
    private Button btnPassword;
    private TextField NomUtilisateur;
    private TextField MotDePass;
    static ComboBox<String> tfRole;
    ServiceUser sp = new ServiceUser();
    public HomeForm() {
        super("Home", BoxLayout.y());
        OnGui();
        addActions();
    }
    
    private void OnGui() {
        btnLogin = new Button("Login");
        btnPassword = new Button("Mot de pass oublié","RightLabel");
       // new LoginForm(this).show();
        Label separator = new Label("Vous n'avez pas de compte?", "WhiteSeparator");
        btnAddUser = new Button("S'inscrire");
        NomUtilisateur = new TextField(null, "Nom d'utilisateur");
        MotDePass = new TextField(null, "Mot de pass",0, TextField.PASSWORD); 
        tfRole = new ComboBox<>();
        tfRole.setLabelForComponent(new Label("s'inscrire"));
        tfRole.addItem("Adherent");
        tfRole.addItem("Coach");
        
        this.addAll(new Label("Connectez-vous :"),NomUtilisateur, MotDePass, btnLogin,btnPassword,separator,tfRole);
    }
    
    private void addActions() {
       
          btnLogin.addActionListener((evt) -> {
                if (NomUtilisateur.getText().isEmpty() || MotDePass.getText().isEmpty()   ) {
                Dialog.show("Alerte", "Veuillez remplir tous les champs", "OK", null);
            }             
            else {
                sp.Login(NomUtilisateur.getText(), MotDePass.getText());
                 new AffichageUserform(this).show();
        }});
       /* btnLogin.addActionListener((evt) -> {
            new LoginForm(this).show();
        });
          
        */
//        btnAddUser.addActionListener((evt) -> {
//            new AjoutCoachForm(this).show();
//        });
        
        btnPassword.addActionListener((evt) -> {
            new PasswordForm(this).show();
        });
        
        /* btnShowUser.addActionListener((evt) -> {
           new AfficheUsersForm(this).show();
        }); */
        
        tfRole.addActionListener((evt) -> {
            if(tfRole.getSelectedItem().equals("Coach")){
                new AjoutCoachForm(this).show();
            }
            if(tfRole.getSelectedItem().equals("Adherent")){
                new AjoutAdherentForm(this).show();
            }
            
        });
    }
    
}

