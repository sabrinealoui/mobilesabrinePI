/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.gui;


//import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.entities.Adherent;
import com.esprit.entities.Coach;
import com.esprit.entities.User;
import com.esprit.services.ServiceUser;
import java.util.List;



/**
 *
 * @author user
 */
public class AffichageUserform extends Form {

//     TextField NomUtilisateur ;
//     TextField MotDePass ; 
     public static User u = null;
     private Button updateButton;
//     private Button Login;
     private Form previousForm;
     
     public AffichageUserform(Form f) {
        super("Bienvenue", BoxLayout.y());
        previousForm = f;
        OnGui();
        addActions();
    }
     

    private void OnGui() {
        
   // NomUtilisateur = new TextField("", "Username", 20, TextField.ANY);
    //MotDePass = new TextField("", "Password", 20, TextField.PASSWORD);
    //Login = new Button("Login");
   
  //  Button updateButton = new Button("Modifier");
     // this.add(new SpanLabel(sp.afficher().toString()));
      
         ServiceUser sp = new ServiceUser();
        List<User> user = sp.afficher();
        for(User u : user) {
           addItem(u);         
        }
    }
     public void addItem(User u) {
        Container c1 = new Container(BoxLayout.x());
        Container c2 = new Container(BoxLayout.y());
        Container c3 = new Container(BoxLayout.x());
        Label nom = new Label("Nom : " +u.getNom());
        Label prenom = new Label("Prenom :" + u.getPrenom());
        Label adresse = new Label("Adresse :" + u.getAdresse());
        Label nomutilisateur = new Label("Nom d'utilisateur :" + u.getNomUtilisateur());
        Label role = new Label("Role :" + u.getRole());
        Label etat = new Label("Etat :" + u.getEtat());
        Label mail = new Label("Mail :" + u.getMail());
        
        if (role.getText().equals("Coach")) {
               Label specialite = new Label("Specialite :" + ((Coach)u).getSpecialite());

        }
        if (role.equals("Adherent")) {
            Label poids = new Label("Poids :" + ((Adherent)u).getPoids());
            Label taille = new Label("Taille :" + ((Adherent)u).getTaille());
            Label abonnement = new Label("Abonnement :" + ((Adherent)u).getAbonnement());
             
        }
        c2.addAll(nom, prenom,etat);
       FontImage modifIcon = FontImage.createMaterial(FontImage.MATERIAL_EDIT, "Label", 4);
        updateButton = new Button(modifIcon);
        
        updateButton.addActionListener(e -> {
        ModifUserForm ModifCoachForm = new ModifUserForm(u);
        ModifCoachForm.show();
    });
        c3.add(updateButton);
        
//        nom.addPointerPressedListener(p -> {
//            Dialog.show(nom.getText()+ "\n"+prenom.getText(),"OK", null);
//        });
        c2.setLeadComponent(nom);
//    c2.setUIID("UserContainer"); // Apply custom UIID to the blog container
    c1.addAll(c2,c3);
    add(c1);
    }
    
    private void addActions() {
       

          this.getToolbar().addCommandToLeftBar("Return", null, (evt) -> {
            previousForm.showBack();
        }); 
    }
    
}
