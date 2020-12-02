package fr.greta.java.user.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;
import fr.greta.java.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String INSERT_INTO = "INSERT into _user(_email, _firstname, _lastname, _phone, address_id)"+
            " VALUES (?, ?, ?, ?, ?)";

    public UserEntity findById(int user_id) {
        //TODO
        return null;
    }


    public UserEntity create(UserEntity userEntity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = connectionFactory.create();
            statement = conn.prepareStatement(INSERT_INTO, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, userEntity.getEmail());
            statement.setString(2, userEntity.getFirstname());
            statement.setString(3, userEntity.getLastname());
            statement.setString(4, userEntity.getPhone());
            statement.setInt(5, userEntity.getAddress_id());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                userEntity.setId(resultSet.getInt(1));
                return userEntity;
            }else{
                throw new RepositoryException("Erreur lors de l'execution de la requete: "+INSERT_INTO);
            }

        }catch (ClassNotFoundException | SQLException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+INSERT_INTO, e);
        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }

    }
}
