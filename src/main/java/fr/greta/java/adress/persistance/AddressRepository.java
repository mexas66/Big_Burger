package fr.greta.java.adress.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddressRepository {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String INSERT_INTO = "INSERT INTO _address (_number, _street, _zipcode, _city)" +
            "VALUES(?, ?, ?, ?)";

    public AddressEntity create(AddressEntity entity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = connectionFactory.create();
            statement = conn.prepareStatement(INSERT_INTO, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getNumber());
            statement.setString(2, entity.getStreet());
            statement.setString(3, entity.getZipCode());
            statement.setString(4, entity.getCity());
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
                return entity;
            } else {
                throw new RepositoryException("Erreur lors de l'execution de la requete: " + INSERT_INTO);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requete: " + INSERT_INTO, e);
        } finally {
            JdbcTool.close(conn, statement, resultSet);
        }

    }
}