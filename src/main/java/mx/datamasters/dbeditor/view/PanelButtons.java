package mx.datamasters.dbeditor.view;

import javax.swing.*;
import java.awt.*;

public class PanelButtons extends JPanel {
    protected JTextArea taResult;
    protected JButton bCreate, bRead, bUpdate, bDelete, bReadAll;
    protected JPanel pButtons,pLeft,pRight;

    public PanelButtons() {
        this.setLayout(new GridLayout(2,1));
        pButtons = new JPanel(new GridLayout(1,2));
        bCreate = new JButton("Crear nuevo registro");
        bRead = new JButton("Consultar registro");
        bUpdate = new JButton("Actualizar un registro");
        bDelete = new JButton("Eliminar un registro");
        bReadAll = new JButton("Mostrar todos los registros");

        pLeft = new JPanel(new GridLayout(5,1));
        pRight = new JPanel(new GridLayout(5,1));
        
        this.taResult = new JTextArea();
        this.taResult.setEditable(false);

        pLeft.add(bCreate);
        pLeft.add(bRead);
        pLeft.add(bUpdate);
        pLeft.add(bDelete);
        pLeft.add(bReadAll);

        pButtons.add(pLeft);
        pButtons.add(pRight);

        this.add(taResult);
        this.add(pButtons);
    }
}
