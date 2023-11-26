package mx.datamasters.dbeditor.control;

import mx.datamasters.dbeditor.data.Venta;
import mx.datamasters.dbeditor.model.DBConnection;
import mx.datamasters.dbeditor.model.FacturaCRUD;
import mx.datamasters.dbeditor.model.VentaCRUD;

import java.sql.Connection;

public class VentaControl {
    public void createVenta(Venta venta){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
    }
    public String readVenta(Venta venta){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        String ventaContent = new VentaCRUD().readVenta(conn, venta);

        dbConnection.closeConnection(conn);

        return ventaContent;
    }
    public void updateVenta(Venta venta){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
    }
    public void deleteVenta(Venta venta){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
    }
    public String readAllVenta(){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
    }
}