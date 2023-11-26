package mx.datamasters.dbeditor.control;

import mx.datamasters.dbeditor.data.Factura;
import mx.datamasters.dbeditor.model.DBConnection;
import mx.datamasters.dbeditor.model.FacturaCRUD;

import java.sql.Connection;

public class FacturaControl {
    public void createFactura(Factura factura){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
        new FacturaCRUD().createFactura(conn, factura);

        dbConnection.closeConnection(conn);
    }

    public String readFactura(Factura factura){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();
        String facturaContent = new FacturaCRUD().readFactura(conn, factura.getNumero());

        dbConnection.closeConnection(conn);

        return facturaContent;
    }

    public void updateFactura(Factura factura){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        // TODO: Implement updateFactura logic

        dbConnection.closeConnection(conn);
    }

    public void deleteFactura(Factura factura){
        Connection conn = null;
        DBConnection dbConnection = new DBConnection();

        conn = dbConnection.openConnection();

        new FacturaCRUD().deleteFactura(conn, factura.getNumero());

        dbConnection.closeConnection(conn);
    }
}
