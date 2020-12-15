package fr.greta.java.burger.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BurgerRepository {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String SELECT_REQUEST="SELECT id, _label, _price FROM _burger";
    private static final String WHERE_ID=" WHERE id = ?";

    public BurgerEntity findById(int id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conn= connectionFactory.create();
            statement = conn.prepareStatement(SELECT_REQUEST+WHERE_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return toEntity(resultSet);
            }else{
                throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_ID);
            }

        }catch(SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_ID, e);
        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }

    }




    private BurgerEntity toEntity(ResultSet resultSet) throws SQLException {
        BurgerEntity entity = new BurgerEntity();

        entity.setId(resultSet.getInt("id"));
        entity.setLabel(resultSet.getString("_label"));
        entity.setPrice(resultSet.getFloat("_price"));

        return entity;
    }


    public List<BurgerEntity> getAll() throws RepositoryException {
        List<BurgerEntity> entities = new ArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            conn = connectionFactory.create();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(SELECT_REQUEST);

            while(resultSet.next()){
                entities.add(toEntity(resultSet));
            }

            return entities;
        }catch (SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST, e);
        }finally{
            JdbcTool.close(conn,statement,resultSet);
        }
    }
}
