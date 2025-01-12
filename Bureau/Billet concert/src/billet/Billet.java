package billet;

public class Billet {
    private int idReservation;
    private String codeBIllet;
    private BilletStatue statu;

    public enum BilletStatue {
        VALIDE,
        UTILISER,
        ANNULE
    }

    public Billet(int idReservation, String codeBIllet, BilletStatue statu) {
        this.idReservation = idReservation;
        this.codeBIllet = codeBIllet;
        this.statu = statu;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public String getCodeBIllet() {
        return codeBIllet;
    }

    public BilletStatue getStatu() {
        return statu;
    }
}