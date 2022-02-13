package org.maria.demoexam;

import java.sql.*;
import java.util.LinkedList;

/**
 * Класс для работы с базой данных
 */
public class SQLManager {

    /**
     * Создание соединения с базой данных
     * @return возвращает SQL соединение
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/s3", "root", "12345");
    }

    /**
     * Выбор из базы данных всех клиентов
     * @return возвращает список клиентов
     * @throws SQLException
     */
    public static LinkedList<ClientEntity> SelectAll() throws SQLException {
        LinkedList<ClientEntity> list = new LinkedList<ClientEntity>();
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet client = st.executeQuery("SELECT * FROM product");

        while (client.next()) {
            ClientEntity e = new ClientEntity(
                    client.getInt("ID"),
                    client.getString("Title"),
                    client.getString("ProductTypeID"),
                    client.getString("ArticleNumber"),
                    client.getString("Description"),
                    client.getString("Image"),
                    client.getInt("ProductionPersonCount"),
                    client.getInt("ProductionWorkshopNumber"),
                    client.getDouble("MinCostForAgent")
                    );
            list.add(e);
        }
        return list;
    }
}