package mx.datamasters.dbeditor.view;

import mx.datamasters.dbeditor.control.ProductoControl;
import mx.datamasters.dbeditor.data.Producto;

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

        } else if (actionEvent.getSource().equals(this.pButtons.bRead)) {

        } else if (actionEvent.getSource().equals(this.pButtons.bUpdate)) {
            // TODO: Implement logic of update
        } else if (actionEvent.getSource().equals(this.pButtons.bDelete)) {

        } else if (actionEvent.getSource().equals(this.pButtons.bReadAll)) {
            // TODO: Implement logic of consult all
        }
    }
}
