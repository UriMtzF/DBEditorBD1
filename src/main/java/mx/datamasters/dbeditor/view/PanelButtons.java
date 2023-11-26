package mx.datamasters.dbeditor.view;

import javax.swing.*;
import java.awt.*;

public class PanelButtons extends JPanel {
    protected JTextArea taResult;
    protected JButton bCreate, bRead, bUpdate, bDelete, bReadAll;

    public PanelButtons() {
        this.setLayout(new GridLayout(2,1));
        JPanel pButtons = new JPanel(new GridLayout(6,1));
        bCreate = new JButton("Crear nuevo registro");
        bRead = new JButton("Consultar registro");
        bUpdate = new JButton("Actualizar un registro");
        bDelete = new JButton("Eliminar un registro");
        bReadAll = new JButton("Mostrar todos los registros");

        this.taResult = new JTextArea();
        this.taResult.setEditable(false);

        pButtons.add(bCreate);
        pButtons.add(bRead);
        pButtons.add(bUpdate);
        pButtons.add(bDelete);
        pButtons.add(bReadAll);

        this.add(taResult);
        this.add(pButtons);
    }
}
