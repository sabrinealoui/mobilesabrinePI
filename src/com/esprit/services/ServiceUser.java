/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.esprit.entities.Adherent;
import com.esprit.entities.Coach;
import com.esprit.entities.User;
import com.esprit.utils.Statics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 *
 * @author user
 */
public class ServiceUser implements IService<User> {
    public static User u = null;
    private boolean responseResult;
    private List<User> users;
    List<String> emailList = null;
    public static ServiceUser instance = null ;
    
    private final String URI = Statics.BASE_URL + "/user/";

    public ServiceUser() {
        users = new ArrayList();
    }

    /**
     *
     * @param u
     * @return
     */
    @Override
    public boolean ajouter(User u) {
        ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI);
        request.setHttpMethod("POST");
        
        request.addArgument("nom", u.getNom());
        request.addArgument("prenom", u.getPrenom());
        request.addArgument("adresse", u.getAdresse());
        request.addArgument("nomutilisateur", u.getNomUtilisateur());
        request.addArgument("motdepass", u.getMotDePass());
        request.addArgument("role", u.getRole());
        request.addArgument("etat", u.getEtat());
        request.addArgument("mail", u.getMail());
               if (u.getRole().equals("Coach")) {
                  request.addArgument("specialite",((Coach)u).getSpecialite());   
                }
               if (u.getRole().equals("Adherent")) {
                  request.addArgument("poids", String.valueOf(((Adherent)u).getPoids()));
                  request.addArgument("poids", String.valueOf(((Adherent)u).getPoids()));
                  request.addArgument("abonnement",((Adherent)u).getAbonnement());
               }
       
        request.addResponseListener((evt) -> {
            responseResult = request.getResponseCode() == 201; // Code HTTP 201 OK
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }

    @Override
    public boolean modifier(User u) {
        ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI + u.getId());
        request.setHttpMethod("PUT");

        request.addArgument("nom", u.getNom());
        request.addArgument("prenom", u.getPrenom());
        request.addArgument("adresse", u.getAdresse());
        request.addArgument("nomutilisateur", u.getNomUtilisateur());
        request.addArgument("motdepass", u.getMotDePass());
        request.addArgument("role", u.getRole());
        request.addArgument("etat", u.getEtat());
        request.addArgument("mail", u.getMail());
        if (u.getRole().equals("Coach")) {
                  request.addArgument("specialite",((Coach)u).getSpecialite());   
                }
               if (u.getRole().equals("Adherent")) {
                  request.addArgument("poids", String.valueOf(((Adherent)u).getPoids()));
                  request.addArgument("poids", String.valueOf(((Adherent)u).getPoids()));
                  request.addArgument("abonnement",((Adherent)u).getAbonnement());
                } 
        request.addResponseListener((evt) -> {
            responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }

    @Override
    public boolean supprimer(User u) {
        ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI + u.getId());
        request.setHttpMethod("DELETE");

        request.addResponseListener((evt) -> {
            responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }

    
    @Override
    public List<User> afficher() {
        ConnectionRequest request = new ConnectionRequest();
        
        request.setUrl(URI+u.getId());
        request.setHttpMethod("GET");

        request.addResponseListener((evt) -> { 
            try { 
                InputStreamReader jsonText = new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8");
                Map<String, Object> result = new JSONParser().parseJSON(jsonText);
                List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("root");
                  System.out.println(list);
                for (Map<String, Object> obj : list) { 
                    int id = (int) Float.parseFloat(obj.get("id").toString());
                    String nom = obj.get("Nom").toString();
                    String prenom = obj.get("Prenom").toString();
                    String adresse = obj.get("Adresse").toString();
                    System.out.println(obj.get("NomUtilisateur").toString());
                    String nomutilisateur = obj.get("NomUtilisateur").toString();
                    System.out.println(nomutilisateur); 
                    String motdepass = obj.get("MotDePass").toString();
                    String role = obj.get("Role").toString();
                    String etat = obj.get("Etat").toString();
                    String mail = obj.get("Mail").toString();
                   
               if (role.equals("Coach")) {
              String specialite = obj.get("Specialite").toString();
                    users.add(new Coach(id,nom,prenom,adresse,nomutilisateur,motdepass,role,etat,mail,specialite ));  
                }
             
               if (role.equals("Adherent")) {
                    double poids = Double.parseDouble(obj.get("Poids").toString());
                    double taille = Double.parseDouble(obj.get("Taille").toString());
                    String abonnement = obj.get("Abonnement").toString();
                   users.add(new Adherent(id,nom,prenom,adresse,nomutilisateur,motdepass,role,etat,mail,poids,taille,abonnement));
                } 
                } } 

             catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return users;
    } 
    
     public void Login(String NomUtilisateur, String MotDePass) {
       ConnectionRequest request = new ConnectionRequest();
       request.setUrl(URI+"users/"+NomUtilisateur+"/"+MotDePass);
       System.out.println(URI);
       request.setHttpMethod("GET");
       request.addResponseListener((evt) -> { 
          // JSONParser j = new JSONParser();
          // String json= new String(request.getResponseData()) + "";
            try { 
                    InputStreamReader jsonText = new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8");
                    Map<String, Object> result = new JSONParser().parseJSON(jsonText);
                    System.out.println(result);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("root");
                    System.out.println(list);
                    if (list != null) {
                    
                        for (Map<String, Object> obj : list) {
                            int id = (int) Float.parseFloat(obj.get("id").toString());
                            String nom = obj.get("Nom").toString();
                            String prenom = obj.get("Prenom").toString();
                            String adresse = obj.get("Adresse").toString();
                            String nomutilisateur = obj.get("NomUtilisateur").toString();
                            String motdepass = obj.get("MotDePass").toString();
                            String role = obj.get("Role").toString();
                            String etat = obj.get("Etat").toString();
                            String mail = obj.get("Mail").toString();
                            switch (role) {
                                case "Coach":
                                    {
                                        String specialite = obj.get("Specialite").toString();
                                         u = new Coach (id,nom,prenom,adresse,nomutilisateur,motdepass,role,etat,mail,specialite);
                                        System.out.println("role connected : " + role);
                                        Dialog.show("SUCCESS", "Bienvenue Coach !", "OK", null);
                                        break ;
                                    }
                                case "Adherent":
                                    {
                                        double poids = Double.parseDouble(obj.get("Poids").toString());
                                        double taille = Double.parseDouble(obj.get("Taille").toString());
                                        System.out.println("abonnement :"+obj.get("Abonnement").toString());
                                        String abonnement = obj.get("Abonnement").toString();
                                         u = new Adherent(id,nom,prenom,adresse,nomutilisateur,motdepass,role,etat,mail,poids,taille,abonnement);
                                        System.out.println("role connected : " + role);
                                        Dialog.show("SUCCESS", "Bienvenue Adherent !", "OK", null);
                                        break;
                                    }
                                    
                                    default:
                         Dialog.show("Alerte", "Username ou password invalide, Merci de réessayer", "OK", null);
                        break;
                }
                    }
                } } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }   
        });
        NetworkManager.getInstance().addToQueueAndWait(request);
                               
    } 
                
       public List<String> afficherEmails() {
            ConnectionRequest request = new ConnectionRequest();

            request.setUrl(URI);
            request.setHttpMethod("GET");

            request.addResponseListener((evt) -> {
                try {
                    emailList = new ArrayList<>();
                    InputStreamReader jsonText = new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8");
                    Map<String, Object> result = new JSONParser().parseJSON(jsonText);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("root");

                    for (Map<String, Object> obj : list) {
                        String Mail =  obj.get("Mail").toString();
                        emailList.add(Mail);
                    }

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            });
            NetworkManager.getInstance().addToQueueAndWait(request);
        

            return emailList;
        }  
    /**
     *
     * @param Mail
     * @return
     */
    public String getPasswordBymail(String Mail) {
        
        String url = URI + "userp/"+ Mail ;
        ConnectionRequest request = new ConnectionRequest(); //false ya3ni url mazlt matba3thtich lel server
       
          request.setUrl(url);
        
        request.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
            String json = new String(request.getResponseData()) + "";
           
            try {
            
                System.out.println("data =="+json);
                Map<String,Object> MotDePass = j.parseJSON(new CharArrayReader(json.toCharArray()));
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        });
   
        NetworkManager.getInstance().addToQueueAndWait(request);
        String json = null;
    return json;
    }
    
     public static ServiceUser getInstance() {
        if(instance == null )
            instance = new ServiceUser();
        return instance ;
    }

  
   }





















    

