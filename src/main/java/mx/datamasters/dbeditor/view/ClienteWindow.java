package mx.datamasters.dbeditor.view;

import mx.datamasters.dbeditor.control.ClienteControl;
import mx.datamasters.dbeditor.data.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteWindow extends JFrame implements ActionListener {
    private JFrame fParent;
    private PanelButtons pButtons;
    public ClienteWindow(JFrame fParent) {
        this.fParent = fParent;
        this.fParent.setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Operaciones clientes");
        this.setVisible(true);

        pButtons = new PanelButtons();
        this.add(pButtons);

        pButtons.bCreate.addActionListener(this);
        pButtons.bRead.addActionListener(this);
        pButtons.bUpdate.addActionListener(this);
        pButtons.bDelete.addActionListener(this);
        pButtons.bReadAll.addActionListener(this);

        this.pack();
    }
    @Override
    public void dispose(){
        this.fParent.setVisible(true);
        super.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.pButtons.bCreate)){
            Cliente cliente = new Cliente();
            cliente.setRut(askData("RUT"));
            cliente.setNombre(askData("Nombre"));
            cliente.setApellido1(askData("Apellido paterno"));
            cliente.setApellido2(askData("Apellido materno"));
            cliente.setDomicilio(askData("Domicilio"));
            cliente.setTelefono(askData("Teléfono"));

            new ClienteControl().createCliente(cliente);
        } else if (actionEvent.getSource().equals(this.pButtons.bRead)) {
            Cliente cliente = new Cliente();
            cliente.setRut(askData("RUT"));

            this.pButtons.taResult.setText(new ClienteControl().readCliente(cliente));
        } else if (actionEvent.getSource().equals(this.pButtons.bUpdate)) {
            // TODO: Better management of update value
            Cliente cliente = new Cliente();
            cliente.setRut(askData("RUT"));
            String attribute = "";
            int attributeCons = JOptionPane.showOptionDialog(
                    getParent(),
                    "Selecciona el atributo a actualizar",
                    "Escoje una opción",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Nombre", "Apellido Paterno", "Apellido Paterno", "Domicilio", "Teléfono"},
                    "Nombre"
                    );
            switch (attributeCons){
                case 0 -> {
                    cliente.setNombre(askData("Nombre"));
                    attribute = "nombre";
                }
                case 1 -> {
                    cliente.setApellido1(askData("Apellido paterno"));
                    attribute = "apellido1";
                }
                case 2 -> {
                    cliente.setApellido2(askData("Apellido materno"));
                    attribute = "apellido2";
                }
                case 3 -> {
                    cliente.setDomicilio(askData("Domicilio"));
                    attribute = "domicilio";
                }
                case 4 -> {
                    cliente.setTelefono(askData("Teléfono"));
                    attribute = "telefono";
                }
            }

            new ClienteControl().updateCliente(cliente, attribute);
        } else if (actionEvent.getSource().equals(this.pButtons.bDelete)) {
            Cliente cliente = new Cliente();
            cliente.setRut(askData("RUT"));

            new ClienteControl().deleteCliente(cliente);
        } else if (actionEvent.getSource().equals(this.pButtons.bReadAll)) {
            // TODO: Implement logic of consult all
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
