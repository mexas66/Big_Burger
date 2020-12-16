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
    private static final String SELECT_REQUEST = "SELECT id, _firstname, _lastname, _phone, _role, _email, _password FROM _employee";
    private static final String UPDATE_REQUEST = "UPDATE _employee SET _status = ?";
    
    private static final String WHERE_ID = " WHERE id = ?";
    private static final String WHERE_EMAIL= " WHERE _email = ? AND _password = ?";

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

	public EmployeeEntity findEmployee(String email, String password) throws RepositoryException {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			conn = connectionFactory.create();
			statement = conn.prepareStatement(SELECT_REQUEST+WHERE_EMAIL);
			statement.setString(1, email);
			statement.setString(2, password);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				return toEntity(resultSet);
			}else {
				throw new RepositoryException("Employe non trouve");
			}
		}catch(SQLException | ClassNotFoundException e) {
			throw new RepositoryException("Erreur lors de l'execution de la requete: "+SELECT_REQUEST+WHERE_EMAIL, e);
		}finally {
			JdbcTool.close(conn, statement, resultSet);
		}
	}

	private EmployeeEntity toEntity(ResultSet resultSet) throws SQLException {
		EmployeeEntity entity = new EmployeeEntity();
		
		entity.setId(resultSet.getInt("id"));
		entity.setFirstname(resultSet.getString("_firstname"));
		entity.setLastname(resultSet.getString("_lastname"));
		entity.setEmail(resultSet.getString("_email"));
		entity.setPassword(resultSet.getString("_password"));
		entity.setPhone(resultSet.getString("_phone"));
		entity.setRole(resultSet.getString("_role"));
		
		return entity;
	}

	public void setEmployeeOn(int id) throws RepositoryException {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try{
			conn = connectionFactory.create();
			statement = conn.prepareStatement(UPDATE_REQUEST+WHERE_ID);
			statement.setString(1, "ONLINE");
			statement.setInt(2, id);
			statement.executeUpdate();
		}catch(SQLException | ClassNotFoundException e) {
			throw new RepositoryException("Erreur lors de l'execution de la requete "+ UPDATE_REQUEST+WHERE_ID, e);
		}finally {
			JdbcTool.close(conn, statement, resultSet);
		}
		
		
	}

	public void setEmployeeOff(int id) throws RepositoryException {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try{
			conn = connectionFactory.create();
			statement = conn.prepareStatement(UPDATE_REQUEST+WHERE_ID);
			statement.setString(1, "OFFLINE");
			statement.setInt(2, id);
			statement.executeUpdate();
		}catch(SQLException | ClassNotFoundException e) {
			throw new RepositoryException("Erreur lors de l'execution de la requete "+ UPDATE_REQUEST+WHERE_ID, e);
		}finally {
			JdbcTool.close(conn, statement, resultSet);
		}
	}
}
