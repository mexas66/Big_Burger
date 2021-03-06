package fr.greta.java.order.persistance;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.tools.JdbcTool;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    ConnectionFactory connectionFactory = new ConnectionFactory();

    private static final String INSERT_INTO = "INSERT INTO _order (user_id, _beginning, _end, _total, _state) " +
            "VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE_STATE= "UPDATE _order SET _state = ?";

    private static final String SELECT_REQUEST = "SELECT id, user_id, _beginning, _end, _total, _state FROM _order";
    private static final String WHERE_ID = " WHERE id = ?";
    private static final String WHERE_STATE = " WHERE _state = ?";
    private static final String WHERE_USER=" WHERE user_id = ?";
    private static final String OR_STATE = " OR _state = ?";
    private static final String SELECT_STATE = "SELECT _state FROM _order";
    private static final String WHERE_STATE_DIFFERENT = " WHERE _state <> 'ENDED'";

    private static final String SELECT_REQUEST_ORDER_ITEMS = "SELECT burger_id, _quantity FROM _order_items WHERE order_id =  ?";
    private static final String INSERT_INTO_ORDER_ITEMS = "INSERT INTO _order_items (order_id, burger_id, _quantity) " +
            "VALUES(?, ?, ?)";



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
            statement.setString(5, entity.getState());
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));

                for (int burgerid : entity.getBurgersId().keySet()) {
                    statement = conn.prepareStatement(INSERT_INTO_ORDER_ITEMS);
                    statement.setInt(1, entity.getId());
                    statement.setInt(2, burgerid);
                    statement.setInt(3, entity.getBurgersId().get(burgerid));
                    statement.executeUpdate();
                }


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


    public OrderEntity findById(int order_id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = connectionFactory.create();
            statement = conn.prepareStatement(SELECT_REQUEST+WHERE_ID);
            statement.setInt(1, order_id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return toEntity(resultSet);
            } else {
                throw new RepositoryException("Erreur lors de l'execution de la requete: " + SELECT_REQUEST+WHERE_ID);
            }
        } catch (SQLException | ClassNotFoundException | RepositoryException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requete: " + SELECT_REQUEST+WHERE_ID, e);
        } finally {
            JdbcTool.close(conn, statement, resultSet);
        }
    }

    private OrderEntity toEntity(ResultSet resultSet) throws SQLException, RepositoryException {

        OrderEntity entity = new OrderEntity();
        entity.setId(resultSet.getInt("id"));
        entity.setBurgersId(getOrderItems(resultSet.getInt("id")));
        entity.setBeginning(resultSet.getTimestamp("_beginning"));
        entity.setEnd(resultSet.getTimestamp("_end"));
        entity.setUser_id(resultSet.getInt("user_id"));
        entity.setTotal(resultSet.getDouble("_total"));
        entity.setState(resultSet.getString("_state"));

        return entity;
    }


    public Map<Integer, Integer> getOrderItems(int order_id) throws RepositoryException {

        Map<Integer, Integer> burgers_id = new HashMap<Integer, Integer>();

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            conn = connectionFactory.create();
            statement = conn.prepareStatement(SELECT_REQUEST_ORDER_ITEMS);
            statement.setInt(1, order_id);
            resultSet = statement.executeQuery();


            while (resultSet.next()) {
                burgers_id.put(resultSet.getInt("burger_id"), resultSet.getInt("_quantity"));
            }

            return burgers_id;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requete: " + SELECT_REQUEST_ORDER_ITEMS, e);
        } finally {
            JdbcTool.close(conn, statement, resultSet);
        }
    }

    public List<OrderEntity> getOrderList(String role) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<OrderEntity> entities = new ArrayList<>();
        String stateToGet1 = "";
        String stateToGet2 = "";

        if(role.equals("COOKER")){
            stateToGet1 = "VALIDATED";
            stateToGet2 = "PREPARING";
        }else if(role.equals("DELIVERY")){
            stateToGet1 = "READY";
            stateToGet2 = "DELIVERING";
        }

        try{
            conn = connectionFactory.create();
            statement = conn.prepareStatement(SELECT_REQUEST+WHERE_STATE+OR_STATE);
            statement.setString(1, stateToGet1);
            statement.setString(2, stateToGet2);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                entities.add(toEntity(resultSet));
            }

            return entities;
        }catch (ClassNotFoundException | SQLException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: " + SELECT_REQUEST+WHERE_STATE+OR_STATE, e);
        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }
    }

    public OrderEntity updateOrderState(int order_id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String formerState = getState(order_id);

            conn= connectionFactory.create();
            statement = conn.prepareStatement(UPDATE_STATE+WHERE_ID);
            statement.setString(1, newState(formerState));
            statement.setInt(2, order_id);
            statement.executeUpdate();

            return findById(order_id);
        }catch (ClassNotFoundException | SQLException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+UPDATE_STATE+WHERE_ID, e);
        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }
    }



    private String getState(int order_id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            conn = connectionFactory.create();
            statement = conn.prepareStatement(SELECT_STATE+WHERE_ID);
            statement.setInt(1, order_id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return resultSet.getString("_state");
            }else{
                throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_ID);
            }
        }catch (SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_ID, e);

        }finally {
            JdbcTool.close(conn,statement,resultSet);
        }
    }

    private String newState(String formerState) throws RepositoryException {
        switch(formerState){
            case "VALIDATED":
                return "PREPARING";
            case "PREPARING":
                return "READY";
            case "READY":
                return "DELIVERING";
            case "DELIVERING":
                return "ENDED";
            default:
                throw new RepositoryException("Etat de la commande invalide");
        }
    }


    public List<OrderEntity> getNotEndedOrders() throws RepositoryException {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<OrderEntity> entities = new ArrayList();


        try{
            conn = connectionFactory.create();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(SELECT_REQUEST+WHERE_STATE_DIFFERENT);

            while(resultSet.next()){
                entities.add(toEntity(resultSet));
            }

            return entities;
        }catch(SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_STATE_DIFFERENT, e);
        }finally{
            JdbcTool.close(conn,statement,resultSet);
        }
    }

    public List<OrderEntity> getAllByUserId(int userId) throws RepositoryException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<OrderEntity> entities = new ArrayList();

        try{
            conn= connectionFactory.create();
            statement = conn.prepareStatement(SELECT_REQUEST+WHERE_USER);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                entities.add(toEntity(resultSet));
            }

            return entities;
        }catch(SQLException | ClassNotFoundException e){
            throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_USER, e);
        }
    }
}
