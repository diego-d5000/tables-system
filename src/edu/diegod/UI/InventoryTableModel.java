package edu.diegod.UI;

import edu.diegod.models.Product;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by diego-d on 8/2/15.
 */
public class InventoryTableModel extends AbstractTableModel {

    public static String[] columnNames = {"Artítculo", "Clave", "Unidades", "Costo", "Precio"};
    private List productsData;

    public InventoryTableModel() {
        productsData = new LinkedList<Product>();
    }

    public InventoryTableModel(List productsData) {
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
        return product.getTableValueAtIndex(columnIndex);
    }
}
