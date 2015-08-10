package edu.diegod.UI;

import edu.diegod.datastructures.MList;
import edu.diegod.models.Product;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by diego-d on 8/1/15.
 */
public class InventoryUI {
    private JPanel headerPanel;
    private JPanel inventoryControlPanel;
    private JFrame mainFrame;
    private JTable inventoryTable;
    private InventoryTableModel inventoryTableModel;
    private JScrollPane inventoryScrollingTable;
    private ActionListener onClickTablesButton;
    private MList inventoryList;
    private JTextField[] formFieldsArray;

    public InventoryUI(JFrame mainFrame, MList inventoryList, ActionListener nextUI) {
        this.mainFrame = mainFrame;
        this.onClickTablesButton = nextUI;
        this.formFieldsArray = new JTextField[InventoryTableModel.columnNames.length];
        this.inventoryList = inventoryList;
        this.inventoryTableModel = new InventoryTableModel(this.inventoryList);
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
        inventoryTable = new JTable();
        inventoryTable.setModel(inventoryTableModel);
        inventoryScrollingTable = new JScrollPane(inventoryTable);
    }

    private void setUpInventoryControlPanel() {
        inventoryControlPanel = new JPanel(new GridLayout(1, 2));

        JPanel manageInventoryPanel = new JPanel();
        manageInventoryPanel.setLayout(new BoxLayout(manageInventoryPanel, BoxLayout.Y_AXIS));
        JButton inputProductButton = new JButton("Entrada");
        JButton outputProductButton = new JButton("Salida");
        manageInventoryPanel.add(inputProductButton);
        manageInventoryPanel.add(outputProductButton);

        SpringLayout springLayout = new SpringLayout();
        JPanel productFormPanel = new JPanel(springLayout);
        for (int i = 0; i < InventoryTableModel.columnNames.length; i++) {
            JLabel jLabel = new JLabel(InventoryTableModel.columnNames[i] + ": ", JLabel.TRAILING);
            productFormPanel.add(jLabel);
            JTextField jTextField = new JTextField(10);
            formFieldsArray[i] = jTextField;
            jLabel.setLabelFor(jTextField);
            productFormPanel.add(jTextField);
        }
        SpringUtilities.makeCompactGrid(productFormPanel,
                InventoryTableModel.columnNames.length, 2,
                6, 6,
                6, 6);

        inventoryControlPanel.add(manageInventoryPanel);
        inventoryControlPanel.add(productFormPanel);

        inputProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product inputProduct = new Product(formFieldsArray[0].getText(),
                        formFieldsArray[1].getText(),
                        Integer.valueOf(formFieldsArray[2].getText()),
                        Float.valueOf(formFieldsArray[3].getText()),
                        Float.valueOf(formFieldsArray[4].getText()));
                inventoryList.add(inputProduct);
                inventoryTable.revalidate();
                inventoryTable.repaint();
            }
        });
        outputProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = (Product) inventoryList.get(inventoryTable.getSelectedRow());
                product.setQuantity(product.getQuantity() - 1);
                if(product.getQuantity() == 0)
                    inventoryList.remove(inventoryTable.getSelectedRow());

                inventoryTable.revalidate();
                inventoryTable.repaint();
            }
        });
    }
}
