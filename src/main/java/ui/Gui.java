package ui;

import org.maria.demoexam.ClientEntity;
import org.maria.demoexam.SQLManager;
import util.CustomTableModel;
import util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Gui extends JFrame {

    private JPanel Panel;
    private JTable table;
    private JScrollPane mainPanel;

    private CustomTableModel model;

    public Gui() {
        setContentPane(Panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(10, 10);
        setTitle("Название компании");
        setVisible(true);
        setMinimumSize(new Dimension(1000, 600));
        initTable();
    }

    private void initTable() {
        try {
            model = new CustomTableModel(
                    ClientEntity.class,
                    new String[] {
                           "1", "2", "3", "4", "5", "6", "7", "8", "9"
                    },
                    SQLManager.SelectAll());

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError("Ошибка получения данных" + e.getMessage());
        }
    }
}