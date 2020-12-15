package fr.greta.java.employee.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository {
    ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String INSERT_REQUEST = "INSERT INTO _employee (_firstname, _lastname, _phone, _role)" +
            "VALUES (?, ?, ?, ?)";

    public EmployeeEntity create(EmployeeEntity entity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conn = connectionFactory.create();
            statement = conn.prepareStatement(INSERT_REQUEST,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getFirstname());
            statement.setString(2, entity.getLastname());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getRole());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if(resultSet.next()){
                entity.setId(resultSet.getInt(1));
            }

            return entity;
        }catch (ClassNotFoundException | SQLException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+INSERT_REQUEST,e);
        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }
    }
}
