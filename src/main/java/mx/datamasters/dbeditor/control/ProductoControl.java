package mx.datamasters.dbeditor.control;

import mx.datamasters.dbeditor.data.Producto;
import mx.datamasters.dbeditor.model.DBConnection;
import mx.datamasters.dbeditor.model.ProductoCRUD;

import java.sql.Connection;

public class ProductoControl {
    public void createProducto(Producto producto){
        Connection conn;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
        new ProductoCRUD().createProducto(conn, producto);

        dbConnection.closeConnection(conn);
    }

    public String readProducto(Producto producto){
        Connection conn;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        String productoContent = new ProductoCRUD().readProducto(conn, producto);

        dbConnection.closeConnection(conn);

        return productoContent;
    }

    public void updateProducto(Producto producto){
        Connection conn;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        new ProductoCRUD().updateProducto(conn, producto);

        dbConnection.closeConnection(conn);
    }

    public void deleteProducto(Producto producto){
        Connection conn;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        new ProductoCRUD().deleteProducto(conn, producto);

        dbConnection.closeConnection(conn);
    }

    public String readAllProducto(){
        Connection conn;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        String productos = new ProductoCRUD().readAllProducto(conn);

        dbConnection.closeConnection(conn);

        return productos;
    }
}
