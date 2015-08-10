package edu.diegod.UI;

import edu.diegod.datastructures.ArrayStack;
import edu.diegod.datastructures.MLinkedList;
import edu.diegod.datastructures.MList;
import edu.diegod.datastructures.Stack;
import edu.diegod.models.Product;

import javax.swing.table.AbstractTableModel;

/**
 * Created by diego-d on 8/2/15.
 */
public class InventoryTableModel extends AbstractTableModel {

    public static String[] columnNames = {"Artítculo", "Clave", "Unidades", "Costo", "Precio"};
    private MList productsData;

    public InventoryTableModel() {
        productsData = new MLinkedList();
    }

    public InventoryTableModel(MList productsData) {
        this.productsData = productsData;
    }

    @Override
    public int getRowCount() {
        return productsData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = (Product) productsData.get(rowIndex);
        if (product != null)
            return product.getTableValueAtIndex(columnIndex);
        else return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
