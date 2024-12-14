package reservation;

import bd.dataBaseConnection;
import java.sql.*;


public class ReservationDAO {

    public int ajouterReservation(Reservation reservation) {
        String requete = "INSERT INTO reservation(id_utilisateur, id_concert, date_reservation, statut) VALUES (?, ?, ?, ?)";
        try(Connection conne = dataBaseConnection.getConnection();
        PreparedStatement statement = conne.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS)){
            statement.setInt(1, reservation.getIdUtilisateur());
            statement.setInt(2, reservation.getIdConcert());
            statement.setTimestamp(3, Timestamp.valueOf(reservation.getDateReservation()));
            statement.setString(4, reservation.getStatu().toString());

            statement.executeUpdate();

            try(ResultSet generatedKeys = statement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
        }catch(SQLException e){
            System.out.println("Erreur lors de l'ajout de la reservation : " + e.getMessage());
        }

        return -1;
    }
}    