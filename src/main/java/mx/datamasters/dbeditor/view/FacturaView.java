package mx.datamasters.dbeditor.view;

import mx.datamasters.dbeditor.control.FacturaControl;
import mx.datamasters.dbeditor.control.ProductoControl;
import mx.datamasters.dbeditor.control.VentaControl;
import mx.datamasters.dbeditor.data.Factura;
import mx.datamasters.dbeditor.data.Producto;
import mx.datamasters.dbeditor.data.Venta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturaView extends JFrame implements ActionListener {
    private JFrame fParent;
    private PanelButtons pButtons;
    private JButton bCreateVenta, bReadVenta, bUpdateVenta, bDeleteVenta, bReadAll;
    public FacturaView(JFrame fParent) throws HeadlessException {
        this.fParent = fParent;
        this.fParent.setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Operaciones factura");
        this.setVisible(true);

        pButtons = new PanelButtons();

        JPanel pButtonsRight = new JPanel(new GridLayout(5,1));
        bCreateVenta = new JButton("Agregar venta");
        bReadVenta = new JButton("Visualizar venta");
        bUpdateVenta = new JButton("Actualizar venta");
        bDeleteVenta = new JButton("Eliminar venta");
        bReadAll = new JButton("Mostrar todas las ventas");

        this.pButtons.pRight.add(bCreateVenta);
        this.pButtons.pRight.add(bReadVenta);
        this.pButtons.pRight.add(bUpdateVenta);
        this.pButtons.pRight.add(bDeleteVenta);
        this.pButtons.pRight.add(bReadAll);

        this.add(pButtons);

        this.pack();
    }
    @Override
    public void dispose() {
        this.fParent.setVisible(true);
        super.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.pButtons.bCreate)){
            // TODO: Implement logic of creating
        } else if (actionEvent.getSource().equals(this.pButtons.bRead)) {
            Factura factura = new Factura();
            factura.setNumero(askData("Número de factura"));

            this.pButtons.taResult.setText(new FacturaControl().readFactura(factura));
        } else if (actionEvent.getSource().equals(this.pButtons.bUpdate)) {
            Factura factura = new Factura();
            factura.setNumero((askData("Número de factura")));
            factura.setFecha(askData("Fecha de factura"));
            factura.setRutCliente(askData("RUT del cliente"));

            new FacturaControl().updateFactura(factura);
        } else if (actionEvent.getSource().equals(this.pButtons.bDelete)) {
            Factura factura = new Factura();
            factura.setNumero(askData("Número de factura"));

            new FacturaControl().deleteFactura(factura);
        } else if (actionEvent.getSource().equals(this.pButtons.bReadAll)) {
            this.pButtons.taResult.setText(new FacturaControl().readAllFactura());
            // Buttons from Venta
        } else if (actionEvent.getSource().equals(this.bReadVenta)) {
            Venta venta = new Venta();
            venta.setFactura(askData("Número de factura"));

            this.pButtons.taResult.setText(new VentaControl().readVenta(venta));
        } else if (actionEvent.getSource().equals(this.bUpdateVenta)) {
            Venta venta = new Venta();
            venta.setFactura(askData("Número de factura"));
            venta.setProducto(askData("ID del producto"));
            // TODO: Improve management of integers
            venta.setCantidad(Integer.parseInt(askData("Número de productos")));

            new VentaControl().updateVenta(venta);
        } else if (actionEvent.getSource().equals(this.bReadAll)){
            this.pButtons.taResult.setText(new VentaControl().readAllVenta());
        } else if (actionEvent.getSource().equals(this.bCreateVenta)) {
            Venta venta = new Venta();
            venta.setFactura(askData("Número de factura"));
            venta.setProducto(askData("ID del producto"));
            // TODO: Improve management of integers
            venta.setCantidad(Integer.parseInt(askData("Cantidad de productos")));

            new VentaControl().createVenta(venta);
        } else if (actionEvent.getSource().equals(this.bDeleteVenta)) {
            Venta venta = new Venta();
            venta.setFactura(askData("Número de factura"));
            venta.setProducto(askData("ID del producto"));

            new VentaControl().deleteVenta(venta);
        }
    }

    public String askData(String attribute){
        return JOptionPane.showInputDialog(
                getParent(),
                attribute,
                "Escribe el valor",
                JOptionPane.QUESTION_MESSAGE
        );
    }
}
