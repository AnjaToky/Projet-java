package utilisateur;

import java.time.LocalDateTime;


public class Utilisateur {

    public static int nbrBillet = 100; 
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private LocalDateTime dateInscription;


    public Utilisateur(String nom, String prenom, String email, String motDePasse, LocalDateTime dateInscription) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = dateInscription;

        nbrBillet--;
    }


    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getEmail(){
        return email;
    }

    public String getMotDePasse(){
        return motDePasse;
    }

    public LocalDateTime getDateInscription(){
        return dateInscription;
    }

    public int getNbrBillet(){
        return nbrBillet;
    }


    public void setDateInscription(LocalDateTime dateInscription){
        this.dateInscription = dateInscription;
        System.out.println(this.dateInscription);
    }



}