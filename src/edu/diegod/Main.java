package edu.diegod;

import edu.diegod.UI.InventoryUI;
import edu.diegod.UI.TablesUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static JFrame mainFrame;
    public static TablesUI tablesUI;
    public static InventoryUI inventoryUI;

    public Main() {
    }

    public static void main(String[] args) {
        createMainFrame();
        setUpTablesUI();
        setUpInventoryUI();
        tablesUI.showView();
    }

    private static void createMainFrame() {
        mainFrame = new JFrame("Sistema Restaurante");
        mainFrame.setSize(1024, 600);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private static void setUpTablesUI(){
        tablesUI = new TablesUI(mainFrame, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryUI.showView();
            }
        });
    }

    private static void setUpInventoryUI(){
        inventoryUI = new InventoryUI(mainFrame, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablesUI.showView();
            }
        });
    }

}
