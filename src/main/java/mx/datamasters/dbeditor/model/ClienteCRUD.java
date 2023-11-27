package mx.datamasters.dbeditor.model;

import mx.datamasters.dbeditor.data.Cliente;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ClienteCRUD {
    public void createCliente(Connection conn, Cliente cliente){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_insertar_cliente(?,?,?,?,?,?)}";
            cs = conn.prepareCall(plSQL);

            cs.setString(1, cliente.getRut());
            cs.setString(2, cliente.getNombre());
            cs.setString(3, cliente.getApellido1());
            cs.setString(4, cliente.getApellido2());
            cs.setString(5, cliente.getDomicilio());
            cs.setString(6, cliente.getTelefono());

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String readCliente(Connection conn, String uid){
        CallableStatement cs = null;
        String clienteValue = "";

        try {
            String plSQL = "{? = call fn_consulta_cliente(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, uid);
            cs.registerOutParameter(1, Types.VARCHAR);

            cs.execute();

            clienteValue = cs.getNString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clienteValue;
    }

    public void updateCliente(Connection conn, Cliente cliente, String attribute){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_actualizar_cliente(?,?,?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1,cliente.getRut());
            cs.setString(2,attribute);
            cs.setString(3,getClienteAttributeValue(cliente, attribute));
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getClienteAttributeValue(Cliente cliente, String attribute){
        return switch (attribute) {
            case "nombre" -> cliente.getNombre();
            case "apellido1" -> cliente.getApellido1();
            case "apellido2" -> cliente.getApellido2();
            case "domicilio" -> cliente.getDomicilio();
            case "telefono" -> cliente.getTelefono();
            default -> "";
        };
    }

    public void deleteCliente(Connection conn, String uid){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_eliminar_cliente(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1,uid);
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String readAllCliente(Connection conn){
        CallableStatement cs = null;
        String clientes = "";

        try {
            String plSQL = "{? = call pr obtener_datos_clientes}";
            cs = conn.prepareCall(plSQL);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.execute();

            clientes = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
}
