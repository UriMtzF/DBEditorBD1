package mx.datamasters.dbeditor.view;

import mx.datamasters.dbeditor.control.ClienteControl;
import mx.datamasters.dbeditor.data.Cliente;
import mx.datamasters.dbeditor.model.ClienteCRUD;

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
            // TODO: Implement logic of update
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
