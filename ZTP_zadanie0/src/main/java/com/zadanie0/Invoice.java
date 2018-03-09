package com.zadanie0;

import java.sql.*;
import java.util.ArrayList;

public class Invoice {
    Connection myConn;
    private String invoiceName;
    private Dealer dealer;
    private Client client;
    private double fullPrice;
    ArrayList<Item> itemList;
    PreparedStatement statement = null;
    String sql = null;

    /*public Invoice(Connection myConn, String companyName, String city, String NIP, String id, String cityClient, String NIPClient) {
        this.myConn = myConn;
       // this.dealer = createDealer(companyName, city, NIP);
        //this.client = createClient(id, cityClient, NIPClient);
        this.fullPrice = 0;
        itemList = new ArrayList<Item>();
    }*/
    public Invoice(Connection myConn){
        this.myConn = myConn;
    }


    public void addItem(String productName, double price, int quantity){
        Item item = new Item(productName, price, quantity);
        itemList.add(item);
    }

    /*private Dealer createDealer(String companyName, String city, String NIP) {
        return new Dealer(companyName, city, NIP);
    }

    private Client createClient(String id, String city, String NIP) {
        return new Client(id, city, NIP);
    }*/






    public void updateClientId() {
        statement = null;
        sql = "UPDATE Invoice SET IdClient = LAST_INSERT_ID();";
        try {
            statement = myConn.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public boolean tableEmpty(){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdInvoice, invoiceName from Invoice ";// + "SALES, TOTAL " + "from " + dbName + ".COFFEES";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            if (!rs.next() ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void showInvoices(){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdInvoice, invoiceName from Invoice ";// + "SALES, TOTAL " + "from " + dbName + ".COFFEES";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("IdInvoice");
                    String name = rs.getString("invoiceName");
                    System.out.println("ID" + "\t" + "Nazwa");
                    System.out.println(id + "\t" + name);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validID(int id){
        ArrayList<Integer> pissibleID = new ArrayList<Integer>();
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdInvoice from Invoice ";// + "SALES, TOTAL " + "from " + dbName + ".COFFEES";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int i = rs.getInt("IdInvoice");
                pissibleID.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(pissibleID.contains(id)){
            return true;
        }
        return false;
    }




    public void tableInsert(String invoiceName) {
        statement = null;
        sql = "INSERT INTO Invoice (IdDealer, IdClient, invoiceName) VALUES (LAST_INSERT_ID(), null, ?);";
        try {
            statement = myConn.prepareStatement(sql);
            statement.setString(1, invoiceName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void printInvoice(int idInvoice){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdInvoice, IdDealer, IdClient, invoiceName from Invoice";
        //String sql1 = "select id, city, NIP from Client ";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            int idDealer;
            int idClient;
            while (rs.next()) {
                if(rs.getInt("idInvoice") == idInvoice) {
                    idDealer = rs.getInt("IdDealer");
                    idClient = rs.getInt("IdClient");
                    String invoiceName = rs.getString("invoiceName");

                    System.out.println("=============================================================================");
                    System.out.println("=============================================================================");
                    System.out.format("%32s%20s%20s", invoiceName, "", "SUPER FAKTURA SYSTEM\n");
                    //System.out.println("\t\t\t" + invoiceName + "\t\t\t\t\t\t" + "SUPER FAKTURA SYSTEM" );
                    System.out.println("=============================================================================");

                    //Drukowanie firmy
                    System.out.println("Wystawiający fakturę:");
                    Dealer dl = new Dealer(myConn);
                    dl.printDealer(idDealer);
                    System.out.println();


                    //Drukownie klienta
                    System.out.println("Dane klienta:");
                    Client cl = new Client(myConn);
                    cl.printClient(idClient);
                }
            }
            System.out.format("%5s%32s%15s%10s", "Lp.", "Nazwa produktu", "Cena [zł]", "Ilość");
            System.out.println();
            //drukuj wszystkie pozycje faktury
            Item item = new Item(myConn);
            item.printAllItems(idInvoice);


            //zakończenie
            System.out.println("=============================================================================");
            System.out.println("=============================================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    public void deleteEmptyInvoice(int idInvoice){
        Statement stmt = null;
        ResultSet rs = null;
        String id = String.valueOf(idInvoice);
        String query = "DELETE FROM invoice WHERE IdInvoice = '" + id +"'";

        try {
            stmt = myConn.createStatement();
            stmt.executeUpdate(query);
          /*
            rs = stmt.executeQuery(query);*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }









}
