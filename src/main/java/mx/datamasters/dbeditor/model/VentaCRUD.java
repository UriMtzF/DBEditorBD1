package mx.datamasters.dbeditor.model;

import mx.datamasters.dbeditor.data.Venta;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class VentaCRUD {
    public void createVenta(Connection conn, Venta venta){
        CallableStatement cs = null;

        try {
            //TODO: Change procedure name
            String plSQL = "PROCEDIMIENTO";
            cs = conn.prepareCall(plSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String readVenta(Connection conn, Venta venta){
        CallableStatement cs = null;
        String ventaValue = "";

        try {
            String plSQL = "{? = call mostrar_venta_especifica(?)}";
            cs = conn.prepareCall(plSQL);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2,venta.getFactura());

            cs.execute();

            ventaValue = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ventaValue;
    }
    public void updateVenta(Connection conn, Venta venta){
        //TODO: Change procedure name
    }
    public void deleteVenta(Connection conn, Venta venta){
        //TODO: Change procedure name
    }
    public String readAllVenta(Connection conn){
        //TODO: Change procedure name
        return "";
    }
}
