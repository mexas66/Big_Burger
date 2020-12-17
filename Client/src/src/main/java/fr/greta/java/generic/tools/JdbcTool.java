package fr.greta.java.generic.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTool {
    public static void close(Connection conn, Statement statement, ResultSet resultSet) {
        close(conn);
        close(statement);
        close(resultSet);
    }

    private static void close(ResultSet resultSet) {
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
            }
        }
    }

    private static void close(Statement statement) {
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
            }
        }
    }

    private static void close(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
            }
        }
    }
}
