package fr.greta.java.order.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String INSERT_INTO="INSERT INTO _order (user_id, _beginning, _end, _total)" +
            "VALUES(?, ?, ?, ?)";
    private static final String SELECT_REQUEST="SELECT id, user_id, _beginning, _end, _total FROM _order WHERE id = ?";
    private static final String SELECT_REQUEST_ORDER_ITEMS= "SELECT burger_id, _quantity FROM _order_items WHERE order_id =  ?";


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


    public OrderEntity findById(int order_id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conn = connectionFactory.create();
            statement= conn.prepareStatement(SELECT_REQUEST);
            statement.setInt(1, order_id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return toEntity(resultSet);
            }else{
                throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST);
            }
        }catch(SQLException | ClassNotFoundException | RepositoryException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST, e);
        }
    }

    private OrderEntity toEntity(ResultSet resultSet) throws SQLException, RepositoryException {

        OrderEntity entity = new OrderEntity();
        entity.setId(resultSet.getInt("id"));
        entity.setBurgerEntities(getOrderItems(resultSet.getInt("id")));
        entity.setBeginning(resultSet.getTimestamp("_beginning"));
        entity.setEnd(resultSet.getTimestamp("_end"));
        entity.setUser_id(resultSet.getInt("user_id"));
        entity.setTotal(resultSet.getDouble("_total"));

        return entity;
    }


    public List<Integer> getOrderItems(int order_id) throws RepositoryException {

        List<Integer> burger_id = new ArrayList();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            conn = connectionFactory.create();
            statement = conn.prepareStatement(SELECT_REQUEST_ORDER_ITEMS);
            statement.setInt(1, order_id);
            resultSet = statement.executeQuery();


            while (resultSet.next()){

                for(int i=0; i < resultSet.getInt("_quantity");i++){
                    burger_id.add(resultSet.getInt("burger_id"));
                }

            }
            return burger_id;
        } catch(SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST_ORDER_ITEMS, e);
        }finally{
            JdbcTool.close(conn,statement,resultSet);
        }
    }


}
