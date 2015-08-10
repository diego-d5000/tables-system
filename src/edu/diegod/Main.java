package edu.diegod;

import edu.diegod.UI.InventoryUI;
import edu.diegod.UI.TablesUI;
import edu.diegod.datastructures.*;
import edu.diegod.models.Product;

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
    public static MQueue tablesQueue;
    public static MList inventoryList;

    public Main() {
    }

    public static void main(String[] args) {
        dummyTablesGenerator();
        dummyInventoryGenerator();
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

    private static void setUpTablesUI() {
        tablesUI = new TablesUI(mainFrame, tablesQueue, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryUI.showView();
            }
        });
    }

    private static void setUpInventoryUI() {
        inventoryUI = new InventoryUI(mainFrame, inventoryList, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablesUI.showView();
            }
        });
    }

    private static void dummyTablesGenerator() {
        tablesQueue = new CircularQueue();
        for (int i = 0; i < 20; i++) {
            tablesQueue.enqueue(String.valueOf(i));
        }
    }

    private static void dummyInventoryGenerator(){
        inventoryList = new MLinkedList();
        for (int i = 0; i < 5; i++) {
            inventoryList.add(new Product("Filete de Cerdo",
                    "FC456AJ",
                    2,
                    100.00f,
                    140.00f));
        }
    }

}
