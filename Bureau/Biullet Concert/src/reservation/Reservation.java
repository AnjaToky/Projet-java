package reservation;

import java.time.LocalDateTime;

public  class Reservation {


    private int idUtilisateur;
    private int idConcert;
    private LocalDateTime dateReservation;
    private StatuConfirmation statu;

    public enum StatuConfirmation {
        CONFIRMEE,
        ANNULEE
    }

    public Reservation(int idUtilisateur, int idConcert, LocalDateTime dateReservation, StatuConfirmation statu) {
        this.idUtilisateur = idUtilisateur;
        this.idConcert = idConcert;
        this.dateReservation = dateReservation;
        this.statu = statu;
    }


    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdConcert() {
        return idConcert;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public StatuConfirmation getStatu() {
        return statu;
    }

}