package com.zadanie0;

import java.sql.*;

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


    public void printDealer(int IdDealer){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdDealer, companyName, city, NIP from Dealer";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt("IdDealer") == IdDealer) {
                    String companyName = rs.getString("companyName");
                    String city = rs.getString("city");
                    String NIP = rs.getString("NIP");
                    System.out.println("\tFirma: " + companyName);
                    System.out.println("\tMiasto: " + city);
                    System.out.println("\tNIP: " + NIP);
                }
            }
            //drukuj pozycje faktury
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
