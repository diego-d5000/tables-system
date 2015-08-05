package edu.diegod.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by diego-d on 8/1/15.
 */
public class InventoryUI {
    private JPanel headerPanel;
    private JPanel inventoryControlPanel;
    private JFrame mainFrame;
    private JScrollPane inventoryScrollingTable;
    private ActionListener onClickTablesButton;

    public InventoryUI(JFrame mainFrame, ActionListener nextUI) {
        this.mainFrame = mainFrame;
        this.onClickTablesButton = nextUI;
        setUpHeaderPanel();
        setUpInventoryTable();
        setUpInventoryControlPanel();
    }

    public void showView() {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().repaint();
        mainFrame.add(headerPanel);
        mainFrame.add(inventoryScrollingTable);
        mainFrame.add(inventoryControlPanel);
        mainFrame.setVisible(true);
    }

    private void setUpHeaderPanel() {
        headerPanel = new JPanel(new FlowLayout());
        JButton tablesButton = new JButton("<- Mesas");
        tablesButton.addActionListener(onClickTablesButton);
        JLabel headerLabel = new JLabel("Inventario", JLabel.RIGHT);
        headerPanel.add(tablesButton);
        headerPanel.add(headerLabel);
    }

    private void setUpInventoryTable() {
        JTable inventoryTable = new JTable(new InventoryTableModel());
        inventoryScrollingTable = new JScrollPane(inventoryTable);
    }

    private void setUpInventoryControlPanel() {
        inventoryControlPanel = new JPanel(new GridLayout(1, 2));

        JPanel manageInventoryPanel = new JPanel();
        manageInventoryPanel.setLayout(new BoxLayout(manageInventoryPanel, BoxLayout.Y_AXIS));
        JButton inputProductButton = new JButton("Entrada");
        JButton outputProductButton = new JButton("Salida");
        JButton modifyProductButton = new JButton("Modificar");
        manageInventoryPanel.add(inputProductButton);
        manageInventoryPanel.add(outputProductButton);
        manageInventoryPanel.add(modifyProductButton);

        SpringLayout springLayout = new SpringLayout();
        JPanel productFormPanel = new JPanel(springLayout);
        for (int i = 0; i < InventoryTableModel.columnNames.length; i++) {
            JLabel jLabel = new JLabel(InventoryTableModel.columnNames[i] + ": ", JLabel.TRAILING);
            productFormPanel.add(jLabel);
            JTextField jTextField = new JTextField(10);
            jLabel.setLabelFor(jTextField);
            productFormPanel.add(jTextField);
        }
        SpringUtilities.makeCompactGrid(productFormPanel,
                InventoryTableModel.columnNames.length, 2,
                6, 6,
                6, 6);

        inventoryControlPanel.add(manageInventoryPanel);
        inventoryControlPanel.add(productFormPanel);
    }
}
