package mx.datamasters.dbeditor.control;

import mx.datamasters.dbeditor.data.Cliente;
import mx.datamasters.dbeditor.model.ClienteCRUD;
import mx.datamasters.dbeditor.model.DBConnection;

import java.sql.Connection;

public class ClienteControl {
    public void createCliente(Cliente cliente){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
        new ClienteCRUD().createCliente(conn, cliente);

        dbConnection.closeConnection(conn);
    }

    public String readCliente(Cliente cliente){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
        String clienteContent = new ClienteCRUD().readCliente(conn, cliente.getRut());

        dbConnection.closeConnection(conn);

        return clienteContent;
    }

    public void updateCliente(Cliente cliente, String attribute){
        Connection conn = null;

        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        new ClienteCRUD().updateCliente(conn, cliente, attribute);

        dbConnection.closeConnection(conn);
    }

    public void deleteCliente(Cliente cliente){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        new ClienteCRUD().deleteCliente(conn, cliente.getRut());

        dbConnection.closeConnection(conn);
    }
}
