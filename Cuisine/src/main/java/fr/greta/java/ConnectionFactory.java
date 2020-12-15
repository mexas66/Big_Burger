package fr.greta.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL="jdbc:postgresql://localhost:5432/big_burger";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="kingdomhell66";

    public Connection create() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
