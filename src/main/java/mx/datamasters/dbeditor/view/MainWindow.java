package mx.datamasters.dbeditor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    JPanel pButtons, pLower;
    JButton bFactura, bCliente, bProducto;
    public MainWindow() throws HeadlessException {
        this.setTitle("Editor base de datos");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setLayout(new GridLayout(2,1));

        this.add(new JLabel("Selecciona una opción"));

        // Instantiate panel of buttons
        pButtons = new JPanel(new GridLayout(2,1));
        // Instantiate buttons
        bFactura = new JButton("Factura");
        bFactura.addActionListener(this);
        bCliente = new JButton("Cliente");
        bCliente.addActionListener(this);
        bProducto = new JButton("Producto");
        bProducto.addActionListener(this);

        this.pLower = new JPanel(new GridLayout(1,2));
        this.pLower.add(bCliente);
        this.pLower.add(bProducto);
        // Add buttons to panel
        this.pButtons.add(bFactura);
        this.pButtons.add(pLower);

        this.add(pButtons);

        // pack method at the end to calculate the size correctly
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(bProducto)){
            ProductoWindow productoWindow = new ProductoWindow(this);
        } else if (actionEvent.getSource().equals(bCliente)) {
            this.setVisible(false);
            new ClienteWindow(this);
        } else if (actionEvent.getSource().equals(bFactura)) {
            FacturaView facturaView = new FacturaView(this);
        }
    }
}
