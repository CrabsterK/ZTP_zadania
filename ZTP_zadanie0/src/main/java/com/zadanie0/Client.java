package com.zadanie0;

import java.sql.*;

public class Client {
    Connection myConn;
    PreparedStatement statement = null;
    String sql = null;

    public Client(Connection myConn) {
        this.myConn = myConn;
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


    public void printClient(int IdClient){
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select IdClient, id, city, NIP from Client";
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getInt("IdClient") == IdClient) {
                    String id = rs.getString("id");
                    String city = rs.getString("city");
                    String NIP = rs.getString("NIP");
                    System.out.println("\t\tId: " + id);
                    System.out.println("\t\tMiasto: " + city);
                    System.out.println("\t\tNIP: " + NIP);
                }
            }
            //drukuj pozycje faktury
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
