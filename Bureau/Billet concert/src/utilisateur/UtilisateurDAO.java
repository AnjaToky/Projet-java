package utilisateur;
import bd.dataBaseConnection;
import java.sql.*;



public class UtilisateurDAO {
    public int  ajouterUtilisateur(Utilisateur utilisateur) {
        String requete = "INSERT INTO utilisateur (nom, prenom, email, mot_de_Passe, date_inscription) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.setString(3, utilisateur.getEmail());
            statement.setString(4, utilisateur.getMotDePasse());
            statement.setTimestamp(5, Timestamp.valueOf(utilisateur.getDateInscription()));
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            } 

        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return -1;
    }


    public void afficherUtilisateur() {
        String requete = "SELECT * FROM utilisateur";

        try(Connection connection  = dataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete)) {
            while (resultSet.next()) {
                System.err.println("ID : " + resultSet.getInt("id_utilisateur")+"\n"+
                "Nom " + resultSet.getString("nom")+"\n" +
                "Prenom : " + resultSet.getString("prenom") + "\n" + 
                "Email : " + resultSet.getString("email") + "\n" +
                "Date d'inscription  : " + resultSet.getTimestamp("date_inscription")
                );

                /*System.out.println("ID : " + resultSet.getInt("id_concert")+"\n"+
                "Titre du concert: " + resultSet.getString("titre")+"\n"+
                "Artiste : " + resultSet.getString("artiste") + "\n" +
                "Date : " + resultSet.getTimestamp("date_concert") + "\n" +
                "Lieu : " + resultSet.getString("lieu") + "\n");*/

                System.out.println("----------------------------------------------------------");
                System.out.println();
            }

        }
        catch(SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }

    }
}