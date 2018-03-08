package com.zadanie0;

import java.sql.Connection;

public class Item {
    Connection myConn;
    private String productName;
    private double price;
    private int quantity;

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
}
