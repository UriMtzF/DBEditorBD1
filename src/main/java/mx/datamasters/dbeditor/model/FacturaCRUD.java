package mx.datamasters.dbeditor.model;

import mx.datamasters.dbeditor.data.Cliente;
import mx.datamasters.dbeditor.data.Factura;

import java.sql.*;

public class FacturaCRUD {
    public void createFactura(Connection conn, Factura factura){
        CallableStatement cs = null;

        try {
            String plSQL = "{call create_factura(?,?)}";
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
            String plSQL = "{? = call crear_factura(?)}";
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

    public void updateFactura(Connection conn, Factura factura){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_actualizar_factura(?,?,?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, factura.getNumero());
            cs.setString(2, factura.getFecha());
            cs.setString(3, factura.getRutCliente());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFactura(Connection conn, Factura factura){
        CallableStatement cs = null;

        try {
            String plSQL = "{call eliminar_factura(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, factura.getNumero());
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String readAllFactura(Connection conn){
        CallableStatement cs = null;
        String facturas = "";

        try {
            String plSQL = "{? = call generar_facturas_return}";
            cs = conn.prepareCall(plSQL);
            cs.registerOutParameter(1, Types.VARCHAR);

            facturas = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return facturas;
    }
}
