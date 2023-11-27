package mx.datamasters.dbeditor.model;

import mx.datamasters.dbeditor.data.Venta;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class VentaCRUD {
    public void createVenta(Connection conn, Venta venta){
        CallableStatement cs;

        try {
            String plSQL = "{call = call crear_venta(?,?,?,?)}";
            cs = conn.prepareCall(plSQL);
            cs.setInt(1, venta.getCantidad());
            cs.setString(2, venta.getFactura());
            cs.setString(3, venta.getProducto());
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String readVenta(Connection conn, Venta venta){
        CallableStatement cs;
        String ventaValue;

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
        CallableStatement cs;

        try {
            String plSQL = "{call actualizar_venta()}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, venta.getFactura());
            cs.setString(2, venta.getProducto());
            cs.setInt(3, venta.getCantidad());

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteVenta(Connection conn, Venta venta){
        CallableStatement cs;

        try {
            String plSQL = "{call eliminar_venta(?,?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, venta.getFactura());
            cs.setString(2, venta.getProducto());

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String readAllVenta(Connection conn){
        CallableStatement cs;
        String ventas;

        try {
            String plSQL = "{? = call obtener_ventas}";
            cs = conn.prepareCall(plSQL);
            cs.registerOutParameter(1,Types.VARCHAR);

            ventas = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ventas;
    }
}
