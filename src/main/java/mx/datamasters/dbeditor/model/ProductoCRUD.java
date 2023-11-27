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
            String plSQL = "{call agregar_producto(?,?,?)}";
            cs = conn.prepareCall(plSQL);

            cs.setString(1, producto.getCodigo());
            cs.setString(2, producto.getDescripcion());
            cs.setDouble(3, producto.getPrecioUnitario());

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String readProducto(Connection conn, Producto producto){
        CallableStatement cs = null;
        String productoValue = "";

        try {
            String plSQL = "{? = call mostrar_producto_info(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, producto.getCodigo());
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();

            productoValue = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productoValue;
    }

    public void updateProducto(Connection conn, Producto producto){
        CallableStatement cs = null;

        try {
            // TODO: Change the name of procedure to pr_modificar_producto
            String plSQL = "{call modificar_producto(?,?,?)}";

            cs = conn.prepareCall(plSQL);
            cs.setString(1, producto.getCodigo());
            cs.setString(2, producto.getDescripcion());
            cs.setDouble(3, producto.getPrecioUnitario());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProducto(Connection conn, Producto producto){
        CallableStatement cs = null;

        try {
            String plSQL = "{call eliminar_producto(?)}";
            cs = conn.prepareCall(plSQL);
            cs.setString(1, producto.getCodigo());
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String readAllProducto(Connection conn){
        CallableStatement cs = null;
        String productos = "";

        try {
            String plSQL = "{? = call obtener_productos()}";
            cs = conn.prepareCall(plSQL);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.execute();

            productos = cs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }
}
