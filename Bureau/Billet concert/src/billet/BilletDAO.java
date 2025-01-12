package billet;
import bd.dataBaseConnection;
import java.sql.*;

public class BilletDAO {
    public void ajouterBillet(Billet billet) {
        String requete = "INSERT INTO billet (id_reservation, code_billet, statut) VALUES (?, ?, ?)";
        try(Connection conne = dataBaseConnection.getConnection();
        PreparedStatement statement = conne.prepareStatement(requete)){

            statement.setInt(1, billet.getIdReservation());
            statement.setString(2, billet.getCodeBIllet());
            statement.setString(3, billet.getStatu().name());
            statement.executeUpdate();

            statement.close();

        }catch(SQLException e){
            System.out.println("Erreur lors de l'ajout du billet : " + e.getMessage());
        }
    }
}