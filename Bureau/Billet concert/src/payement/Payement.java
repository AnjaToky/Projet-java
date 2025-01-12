package payement;

import java.time.LocalDateTime;

public class Payement {
    private int idReservation;
    private double montant;
    private LocalDateTime datePaiement;
    private MethodePayement methode;
    private StatuPayement statu;

    public enum MethodePayement {
        CARTE,
        PAYPAL,
        VIREMENT
    }

    public enum StatuPayement {
        SUCCES,
        ECHEC,
    }

    public Payement(int idReservation, double montant, LocalDateTime datePaiement, MethodePayement methode, StatuPayement statu) {
        this.idReservation = idReservation;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.methode = methode;
        this.statu = statu;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public double getMontant() {
        return montant;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public MethodePayement getMethode() {
        return methode;
    }

    public StatuPayement getStatu() {
        return statu;
    }

}    