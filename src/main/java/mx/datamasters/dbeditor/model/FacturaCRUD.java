package mx.datamasters.dbeditor.model;

import mx.datamasters.dbeditor.data.Factura;

import java.sql.*;

public class FacturaCRUD {
    public void createFactura(Connection conn, Factura factura){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_alta_factura(?,?)}";
            cs = conn.prepareCall(plSQL);

            cs.setString(1, factura.getNumero());
            // TODO: Change logic to manage dates correctly
            cs.setString(2, factura.getFecha());

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFactura(Connection conn, String uid){
        CallableStatement cs = null;
        String factura = "";

        try {
            String plSQL = "{? = call pr_obtener_datos_factura(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1,uid);
            cs.registerOutParameter(1,Types.VARCHAR);

            cs.execute();

            factura = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return factura;
    }

    public void updateFactura(Connection conn, String attribute, String value){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_actualizar_factura(?,?,?)}";
            // rut, atributo, valor
            cs = conn.prepareCall(plSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFactura(Connection conn, String uid){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_eliminar_factura(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1,uid);
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
