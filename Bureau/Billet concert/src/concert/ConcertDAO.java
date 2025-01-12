package concert;

import bd.dataBaseConnection;
import java.sql.*;


public class ConcertDAO {
    public void afficheConcert(){
        String requete = "SELECT * FROM concert";
        try (Connection connection = dataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete)){


            while (resultSet.next()){
                System.out.println();
                System.out.println("Id concert : " + resultSet.getInt("id_concert")+"\n"+
                "Tritre : "+ resultSet.getString("titre")+"\n"+
                "Artiste : "+ resultSet.getString("artiste")+"\n"+
                "Date de concert  : "+ resultSet.getTimestamp("date_concert")+"\n"+
                "Lieu : "+ resultSet.getString("lieu")+"\n"+
                "Prix : "+ resultSet.getDouble("prix_par_billet")+" Ariary\n"+
                "Numbre de places : " + resultSet.getInt("nombre_places"));
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------------------");
            }
        }catch(SQLException e){
            System.out.println("Erreur lors de l'affichage du concert : " + e.getMessage());
        }

    }
}