package ui;

import org.maria.demoexam.ClientEntity;
import org.maria.demoexam.SQLManager;
import util.CustomTableModel;
import util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ServiceTableForm extends JFrame {
    private JPanel mainPanel;
    private JTable table;

    private CustomTableModel model;

    public ServiceTableForm() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 600));
        setLocation(10, 10);
        setTitle("Школа языков Леарн");
        setContentPane(mainPanel);
        initTable();
        setVisible(true);
    }

    private void initTable() {
        try {
            model = new CustomTableModel(
                    ClientEntity.class,
                    new String[] { "ID", "Имя", "Фамилия", "Отчество", "Дата рождения", "Регистрация", "Email", "Телефон", "Пол", "Картинка" },
                    SQLManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError("Ошибка получения данных: " + e.getMessage());
        }
    }
}