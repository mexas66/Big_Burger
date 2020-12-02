package fr.greta.java.order.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String INSERT_INTO="INSERT INTO _order (user_id, _beginning, _end, _total)" +
            "VALUES(?, ?, ?, ?)";

    public OrderEntity create(OrderEntity entity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = connectionFactory.create();
            statement = conn.prepareStatement(INSERT_INTO, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.getUser_id());
            statement.setTimestamp(2, entity.getBeginning());
            statement.setTimestamp(3, entity.getEnd());
            statement.setDouble(4, entity.getTotal());
            statement.executeUpdate();

            resultSet= statement.getGeneratedKeys();

            if(resultSet.next()){
                entity.setId(resultSet.getInt(1));
                return entity;
            }else{
                throw new RepositoryException("Erreur lors de l'execution de la requete: "+INSERT_INTO);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+INSERT_INTO, e);
        }finally{
            JdbcTool.close(conn, statement, resultSet);
        }
    }
}
