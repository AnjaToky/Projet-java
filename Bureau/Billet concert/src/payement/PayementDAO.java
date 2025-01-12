package payement;

import bd.dataBaseConnection;   
import java.sql.*;

public class PayementDAO{

    public void ajouterPayement(Payement payement) {
        String requete = "INSERT INTO payement (id_reservation, montant, date_payement, methode, statut) VALUES (?, ?, ?, ?, ?)";
        try(Connection conne = dataBaseConnection.getConnection();
        PreparedStatement statement = conne.prepareStatement(requete)){

            statement.setInt(1, payement.getIdReservation());
            statement.setDouble(2, payement.getMontant());
            statement.setTimestamp(3, Timestamp.valueOf(payement.getDatePaiement()));
            statement.setString(4, payement.getMethode().name());
            statement.setString(5, payement.getStatu().name());
            statement.executeUpdate();

        }catch(SQLException e){
            System.out.println("Erreur lors de l'ajout du payement : " + e.getMessage());
        }
    }
}