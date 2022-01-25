package util;

import lombok.AllArgsConstructor;
import org.maria.demoexam.ClientEntity;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class CustomTableModel extends AbstractTableModel {
    private Class<ClientEntity> cls;
    private String[] columnNames;
    private LinkedList<ClientEntity> rows;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cls.getDeclaredFields().length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Field field = cls.getDeclaredFields()[columnIndex];
        field.setAccessible(true);
        try {
            return field.get(rows.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
