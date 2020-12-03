package fr.greta.java.user.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String INSERT_REQUEST = "INSERT into _user(_email, _ password, _firstname, _lastname, _phone, address_id)"+
            " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_REQUEST = "SELECT id, _email, _firstname, _lastname, _phone, address_id";
    private static final String WHERE_ID = " WHERE id = ?";

    public UserEntity findById(int user_id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conn = connectionFactory.create();
            statement = conn.prepareStatement(SELECT_REQUEST+WHERE_ID);
            statement.setInt(1, user_id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return toEntity(resultSet);
            }else{
                throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_ID);
            }
        }catch(SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_ID, e);
        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }

    }



    public UserEntity create(UserEntity userEntity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = connectionFactory.create();
            statement = conn.prepareStatement(INSERT_REQUEST, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, userEntity.getEmail());
            statement.setString(2, userEntity.getPassword());
            statement.setString(3, userEntity.getFirstname());
            statement.setString(4, userEntity.getLastname());
            statement.setString(5, userEntity.getPhone());
            statement.setInt(6, userEntity.getAddress_id());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                userEntity.setId(resultSet.getInt(1));
                return userEntity;
            }else{
                throw new RepositoryException("Erreur lors de l'execution de la requete: "+ INSERT_REQUEST);
            }

        }catch (ClassNotFoundException | SQLException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+ INSERT_REQUEST, e);
        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }

    }



    private UserEntity toEntity(ResultSet resultSet) throws SQLException {
        UserEntity entity = new UserEntity();

        entity.setId(resultSet.getInt("id"));
        entity.setEmail(resultSet.getString("_email"));
        entity.setPassword(resultSet.getString("_password"));
        entity.setFirstname(resultSet.getString("_firsname"));
        entity.setLastname(resultSet.getString("_lastname"));
        entity.setPhone(resultSet.getString("_phone"));
        entity.setAddress_id(resultSet.getInt("address_id"));

        return entity;
    }

}
