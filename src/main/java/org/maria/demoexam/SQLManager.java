package org.maria.demoexam;

import java.sql.*;
import java.util.LinkedList;

public class SQLManager {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/s3", "root", "12345");
    }

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