package mx.datamasters.dbeditor.view;

import mx.datamasters.dbeditor.control.ProductoControl;
import mx.datamasters.dbeditor.data.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoWindow extends JFrame implements ActionListener {
    private final JFrame fParent;
    private final PanelButtons pButtons;
    public ProductoWindow(JFrame fParent) throws HeadlessException {
        this.fParent = fParent;
        this.fParent.setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Operaciones productos");
        this.setVisible(true);

        pButtons = new PanelButtons();
        this.add(pButtons);

        this.pButtons.bCreate.addActionListener(this);
        this.pButtons.bRead.addActionListener(this);
        this.pButtons.bUpdate.addActionListener(this);
        this.pButtons.bDelete.addActionListener(this);
        this.pButtons.bReadAll.addActionListener(this);

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
            Producto producto = new Producto();
            producto.setCodigo(askData("Código de producto"));
            producto.setDescripcion(askData("Descripción del producto"));
            producto.setPrecioUnitario(Double.parseDouble(askData("Precio por unidad")));

            new ProductoControl().createProducto(producto);
        } else if (actionEvent.getSource().equals(this.pButtons.bRead)) {
            Producto producto = new Producto();
            producto.setCodigo(askData("Código de producto"));

            this.pButtons.taResult.setText(new ProductoControl().readProducto(producto));
        } else if (actionEvent.getSource().equals(this.pButtons.bUpdate)) {
            Producto producto = new Producto();
            producto.setCodigo(askData("Código de producto"));
            producto.setDescripcion(askData("Descripción del producto"));
            producto.setPrecioUnitario(Double.parseDouble(askData("Precio por unidad")));

            new ProductoControl().updateProducto(producto);
        } else if (actionEvent.getSource().equals(this.pButtons.bDelete)) {
            Producto producto = new Producto();
            producto.setCodigo(askData("Código de producto"));

            new ProductoControl().deleteProducto(producto);
        } else if (actionEvent.getSource().equals(this.pButtons.bReadAll)) {
            this.pButtons.taResult.setText(new ProductoControl().readAllProducto());
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
