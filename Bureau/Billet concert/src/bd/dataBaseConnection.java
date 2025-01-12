package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_concerts";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
            return null;
        }
    }
}