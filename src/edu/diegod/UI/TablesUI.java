package edu.diegod.UI;

import edu.diegod.datastructures.MQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by diego-d on 8/1/15.
 */

public class TablesUI {
    private JFrame mainFrame;
    private JPanel headerPanel;
    private JPanel tablesIndicatorPanel;
    private JLabel nextTableLabel;
    private JPanel buttonsPanel;
    private MQueue tablesQueue;
    private ActionListener onClickInventoryButton;

    public TablesUI(JFrame mainFrame, MQueue tablesQueue, ActionListener nextUI) {
        this.mainFrame = mainFrame;
        this.tablesQueue = tablesQueue;
        this.onClickInventoryButton = nextUI;
        setUpHeaderPanel();
        setUpTablesIndicatorPanel();
        setUpNextButton();
    }

    public void showView() {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().repaint();
        mainFrame.add(headerPanel);
        mainFrame.add(tablesIndicatorPanel);
        mainFrame.add(buttonsPanel);
        mainFrame.setVisible(true);
    }

    private void setUpNextButton() {
        buttonsPanel = new JPanel(new FlowLayout());
        JButton nextButton = new JButton("Siguiente mesa");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablesQueue.enqueue(nextTableLabel.getText());
                String nextTable = (String) tablesQueue.dequeue();
                nextTableLabel.setText(nextTable);
            }
        });
        buttonsPanel.add(nextButton);
    }

    private void setUpHeaderPanel() {
        headerPanel = new JPanel(new FlowLayout());
        JLabel headerLabel = new JLabel("Mesas", JLabel.CENTER);
        JButton inventoryButton = new JButton("Inventario ->");
        inventoryButton.addActionListener(onClickInventoryButton);
        headerPanel.add(headerLabel);
        headerPanel.add(inventoryButton);
    }

    private void setUpTablesIndicatorPanel() {
        String nextTable = (String) tablesQueue.dequeue();
        tablesIndicatorPanel = new JPanel(new FlowLayout());
        JLabel jLabel = new JLabel("Siguiente mesa Disponible: ");
        nextTableLabel = new JLabel(nextTable);
        tablesIndicatorPanel.add(jLabel);
        tablesIndicatorPanel.add(nextTableLabel);
    }
}
