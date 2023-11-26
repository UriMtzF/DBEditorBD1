package mx.datamasters.dbeditor.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xepdb1","user","pass");
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    public void closeConnection(Connection conn){
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
