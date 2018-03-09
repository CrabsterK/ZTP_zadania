package com.zadanie0;

import java.sql.*;

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




    public void printAllItems(int IdInvoice){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select productName, price, quantity, IdInvoice from Item";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            int lp = 1;
            while (rs.next()) {
                if(rs.getInt("idInvoice") == IdInvoice) {
                    String productName = rs.getString("productName");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    System.out.println("=============================================================================");
                    System.out.format("%5d%32s%15d%10d", lp, productName, price, quantity);
                    System.out.println();
                    lp++;
                }
            }

            //drukuj pozycje faktury
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void showItems(int IdInvoice){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdItem, productName, IdInvoice from Item ";// + "SALES, TOTAL " + "from " + dbName + ".COFFEES";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt("idInvoice") == IdInvoice) {
                    int IdItem = rs.getInt("IdItem");
                    String productName = rs.getString("productName");
                    System.out.println("ID" + "\t" + "Nazwa produktu");
                    System.out.println(IdItem + "\t" + productName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void printOneItem(int IdInvoice, int IdItem){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdItem, productName, price, quantity, IdInvoice from Item";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            int lp = 1;
            while (rs.next()) {
                if(rs.getInt("idInvoice") == IdInvoice && rs.getInt("IdItem") == IdItem) {
                    String productName = rs.getString("productName");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    System.out.println("=============================================================================");
                    System.out.format("%5s%32s%15s%10s", "Lp.", "Nazwa produktu", "Cena [zł]", "Ilość");
                    System.out.println();
                    System.out.println("=============================================================================");
                    System.out.format("%5d%32s%15d%10d", lp, productName, price, quantity);
                    System.out.println();
                    System.out.println("=============================================================================");
                    lp++;
                }
            }

            //drukuj pozycje faktury
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




}
