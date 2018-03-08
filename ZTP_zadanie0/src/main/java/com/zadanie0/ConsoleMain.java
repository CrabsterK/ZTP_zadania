package com.zadanie0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ConsoleMain {
    private static String url = "jdbc:mysql://localhost:3306/ztpZad0";
    private static String user = "root";
    private static String password = "root";




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);
            //System.out.println("Initiation OK");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        menu.showMenu();
        String command = sc.next();
        while(!command.equals("0")){
            if(command.equals("1")){
                System.out.println("DODAWANIE FAKTURY");
                System.out.println("Nazwa firmy:");

                // Skip the newline
                sc.nextLine();
                String firma = sc.nextLine();

                System.out.println("Miasto sprzedawcy:");
                String miasto = sc.nextLine();
                System.out.println("NIP sprzedawcy:");
                String NIP = sc.nextLine();
                System.out.println("Numer ID klienta:");

                String ID = sc.nextLine();
                System.out.println("Miasto klienta:");
                String miasto2 = sc.nextLine();
                System.out.println("NIP klienta:");
                String NIP2 = sc.nextLine();

                System.out.println("Nazwa faktury:");
                String invoiceName = sc.nextLine();

                Dealer dealer = new Dealer(myConn);
                dealer.tableInsert(firma, miasto, NIP);

                Invoice inv = new Invoice(myConn);
                inv.tableInsert(invoiceName);


                Client client = new Client(myConn);
                client.tableInsert(ID, miasto2, NIP2);
                inv.updateClientId();

                System.out.println("~faktura dodana~");
            }

            if(command.equals("2")){
                System.out.println("DODAWANIE POZYCJI");
                Invoice inv = new Invoice(myConn);
                if(inv.tableEmpty()){//pusta
                    System.out.println("Najpierw musisz dodać fakturę!");
                }
                else{               //nie pusta
                    System.out.println("Do której faktury dodać pozycję?");
                    inv.showInvoices();
                    System.out.println("ID faktury:");
                    int idFaktury = sc.nextInt();

                }


            }

            if(command.equals("3")){


            }
            if(command.equals("4")){

            }
            if(command.equals("5")){

            }
            if(command.equals("6")){

            }
            if(command.equals("7")){

            }
            if(command.equals("8")){

            }
            command = sc.next();
        }//while(!command.equals("0")){

}
}
