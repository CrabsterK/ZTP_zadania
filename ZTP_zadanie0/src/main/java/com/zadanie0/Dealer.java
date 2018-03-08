package com.zadanie0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dealer {
    Connection myConn;
    private String companyName;
    private String city;
    private String NIP;
    PreparedStatement statement = null;
    String sql = null;


    public Dealer(Connection myConn) {
        this.myConn = myConn;
    }


    public void tableInsert(String companyName, String city, String NIP) {
        statement = null;
        sql = "INSERT INTO Dealer (companyName, city, NIP) VALUES (?, ?, ?);";
        try {
            statement = myConn.prepareStatement(sql);
            statement.setString(1, companyName);
            statement.setString(2, city);
            statement.setString(3, NIP);
            statement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
