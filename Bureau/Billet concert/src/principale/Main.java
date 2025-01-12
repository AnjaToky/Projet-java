package principale;

import billet.Billet;
import billet.BilletDAO;
import concert.ConcertDAO;
import java.time.LocalDateTime;
import java.util.Scanner;
import payement.Payement;
import payement.PayementDAO;
import reservation.Reservation;
import reservation.ReservationDAO;
import utilisateur.Utilisateur;
import utilisateur.UtilisateurDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("============Bienvenue sur le site de réservation de billets de concert==============");
        Utilisateur utilisateur;
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

        Reservation reservation;
        ReservationDAO reservationDAO = new ReservationDAO();
       
        Billet billet;
        BilletDAO billetDAO = new BilletDAO();

        ConcertDAO concertsDAO = new ConcertDAO();
        int idConcert;

        Payement payement;
        PayementDAO payementDAO = new PayementDAO();

        Scanner scanner = new Scanner(System.in);
        int choix;

        do { 

            System.out.println("1. Voire les concerts disponibles");
            System.out.println("2. Réserver un billet");
            System.out.println("3. Afficher les informations de l'utilisateur");
            System.out.println("4. Quitter");
            System.out.print("Faite votre choix : ");
            choix = scanner.nextInt();

            switch(choix){
                case 1:
                    System.out.println();
                    System.out.println("=================Voici les concerts disponibles=============== ");
                    concertsDAO.afficheConcert();
                    break;
                case 2:
                    System.out.print("Nom : ");
                    String nom = scanner.next();
                    System.out.print("Prenom : ");
                    String prenom = scanner.next();
                    System.out.print("Email : ");
                    String email = scanner.next();
                    System.out.print("Mot de passe : ");
                    String motDePasse = scanner.next();  
                    LocalDateTime dateInscription = LocalDateTime.now();

                    utilisateur = new Utilisateur(nom, prenom, email, motDePasse, dateInscription);
                    int idUtilisateur = utilisateurDAO.ajouterUtilisateur(utilisateur);

                    System.out.println("Entrer le id du concert que vous voulez réserver : ");
                    idConcert = scanner.nextInt();
                    LocalDateTime dateReservation = LocalDateTime.now();
                    
                    Reservation.StatuConfirmation statu = Reservation.StatuConfirmation.CONFIRMEE;
                    reservation = new Reservation(idUtilisateur, idConcert, dateReservation,statu);
                    int idReservation = reservationDAO.ajouterReservation(reservation);

                    System.out.println("Votre reservation est "+ statu);
                    System.out.println("Achat du billet");
                    System.out.print("Entrer le code du billet : ");
                    String codeBillet = scanner.next();
                        
                    billet = new Billet(idReservation, codeBillet, Billet.BilletStatue.VALIDE);
                    billetDAO.ajouterBillet(billet);

                    System.out.print("Veuillez entrer le montant du billet : ");
                    double montant = scanner.nextDouble();

                    LocalDateTime datePaiement = LocalDateTime.now();
                    Payement.StatuPayement statutp = Payement.StatuPayement.SUCCES;

                    System.out.println("Veuillez choisir le mode de paiement : ");
                    for (Payement.MethodePayement methode : Payement.MethodePayement.values()) {
                        System.out.println(" "+methode);
                    }
                    
                    Payement.MethodePayement choixMethode = null;
                    while (choixMethode == null) {
                        System.out.println("Veuillez choisir le mode de paiement : ");
                        String input = scanner.next().toUpperCase();
                        try{
                            choixMethode = Payement.MethodePayement.valueOf(input);
                        }catch (IllegalArgumentException e) {
                            System.out.println("Methode de paiement invalide. Veuillez réessayer.");
                        }
                    }

                    System.out.println("Votre paiement est une "+ statutp);    
                    payement = new Payement(idReservation, montant, datePaiement, choixMethode, statutp);
                    payementDAO.ajouterPayement(payement);
                    break;

                    case 3:
                        System.out.println();
                        System.out.println("=================Voici vos informations=============== ");
                        utilisateurDAO.afficherUtilisateur();
                        break;



                default:
                    if(choix > 4){
                        System.err.println();
                        System.out.println("==============Choix invalide. Veuillez réessayer=================");
                    }else{
                        continue;
                    }
                
            }

        } while (choix != 4);

        System.out.println("===============Merci d'avoir utiliser notre application================");
        
    }
}    