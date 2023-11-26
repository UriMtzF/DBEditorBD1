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
            String plSQL = "{call pr_alta_cliente(?,?,?,?,?,?)}";
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
        String cliente = "";

        try {
            String plSQL = "{? = call pr_generar_cliente(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, uid);
            cs.registerOutParameter(1, Types.VARCHAR);

            cs.execute();

            cliente = cs.getNString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public void updateCliente(Connection conn, String attribute, String value){
        //TODO: Implement update logic
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
}
