package com.zadanie0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Item {
    Connection myConn;
    private String productName;
    private double price;
    private int quantity;
    PreparedStatement statement = null;
    String sql = null;

    public Item(Connection myConn) {
        this.myConn = myConn;
    }

    public Item(Connection myConn, String productName, double price, int quantity) {
        this.myConn = myConn;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }



    public void tableInsert(String productName, int price, int quantity, int IdInvoice) {
        statement = null;
        sql = "INSERT INTO Item (productName, price, quantity, IdInvoice) VALUES (?, ?, ?, ?);";
        try {
            statement = myConn.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setInt(2, price);
            statement.setInt(3, quantity);
            statement.setInt(4, IdInvoice);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
