package org.maria.demoexam;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.LinkedList;

public class SQLManager {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam", "root", "12345");
    }

    public static LinkedList<ClientEntity> selectAll() throws SQLException {
        LinkedList<ClientEntity> list = new LinkedList<ClientEntity>();
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet client = st.executeQuery("SELECT * FROM client");

        while (client.next()) {
            ClientEntity e = new ClientEntity(
                    client.getInt("ID"),
                    client.getString("FirstName"),
                    client.getString("LastName"),
                    client.getString("Patronymic"),
                    client.getDate("Birthday"),
                    client.getDate("RegistrationDate"),
                    client.getString("Email"),
                    client.getString("Phone"),
                    client.getString("GenderCode"),
                    client.getString("PhotoPath"));
            list.add(e);
        }

        return list;
    }
}
