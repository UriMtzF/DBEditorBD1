package mx.datamasters.dbeditor.model;

import mx.datamasters.dbeditor.data.Producto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ProductoCRUD {
    public void createProducto(Connection conn, Producto producto){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_alta_producto(?,?,?)}";
            cs = conn.prepareCall(plSQL);

            cs.setString(1, producto.getCodigo());
            cs.setString(2, producto.getDescripcion());
            cs.setDouble(3, producto.getPrecioUnitario());

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String readProducto(Connection conn, String uid){
        CallableStatement cs = null;
        String producto = "";

        try {
            String plSQL = "{? = call pr_generar_producto(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1,uid);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();

            producto = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }

    public void updateProducto(Connection conn, String attribute, String value){
        // TODO: Implement update logic
    }

    public void deleteProducto(Connection conn, String uid){
        CallableStatement cs = null;

        try {
            String plSQL = "{call pr_eliminar_producto(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1,uid);
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
