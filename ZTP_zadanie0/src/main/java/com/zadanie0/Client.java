package com.zadanie0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {
    Connection myConn;
    private String id;
    private String city;
    private String NIP;
    PreparedStatement statement = null;
    String sql = null;

    public Client(Connection myConn) {
        this.myConn = myConn;
    }

    public Client(String id, String city, String NIP) {
        this.id = id;
        this.city = city;
        this.NIP = NIP;
    }

    public void tableInsert(String id, String city, String NIP) {
        statement = null;
        sql = "INSERT INTO Client (id, city, NIP) VALUES (?, ?, ?);";
        try {
            statement = myConn.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, city);
            statement.setString(3, NIP);
            statement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
