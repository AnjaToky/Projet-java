package concert;
import bd.dataBaseConnection;
import java.sql.*;

public class concertGetId {

    public int getId() {
        String requete = "SELECT id_concert FROM concert";
        try(Connection connection = dataBaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS)){
            try(ResultSet generatedKeys = statement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
        }catch(SQLException e){
            System.out.println("Erreur lors de la récupération de l'ID : " + e.getMessage());
        }
        return -1;
    }
    
}