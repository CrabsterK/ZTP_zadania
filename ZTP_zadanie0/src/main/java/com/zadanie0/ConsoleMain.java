package com.zadanie0;

import java.sql.Connection;
import java.sql.DriverManager;
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
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        menu.showMenu();
        String command = sc.next();
        while(!command.equals("0")){
            if(command.equals("1")){//Dodaj fakturę
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

            if(command.equals("2")){//Dodaj pozycję
                System.out.println("DODAWANIE POZYCJI");
                Invoice inv = new Invoice(myConn);
                if(inv.tableEmpty()){//pusta
                    System.out.println("~Najpierw musisz dodać fakturę!~");
                }
                else{               //nie pusta
                    System.out.println("Do której faktury dodać pozycję?");
                    inv.showInvoices();
                    System.out.println("ID faktury:");
                    int idFaktury = sc.nextInt();
                    if(inv.validID(idFaktury)){
                        System.out.println("Nazwa produktu:");
                        // Skip the newline
                        sc.nextLine();
                        String productName = sc.nextLine();
                        System.out.println("Cena produktu:");
                        int price = sc.nextInt();
                        System.out.println("Ilość:");
                        int quantity = sc.nextInt();

                        Item item = new Item(myConn);
                        item.tableInsert(productName, price, quantity, idFaktury);
                        System.out.println("~pozycja dodana~");
                    }
                    else{
                        System.out.println("~Błędne ID faktury~");
                    }
                }
            }

            if(command.equals("3")){//Wyświetl fakturę
                System.out.println("WYSWIETLANIE FAKTURY");
                Invoice inv = new Invoice(myConn);
                if(inv.tableEmpty()){//pusta
                    System.out.println("~Brak faktur!~");
                }
                else{               //nie pusta
                    System.out.println("Którą fakturę wyświetlić?");
                    inv.showInvoices();
                    System.out.println("ID faktury:");
                    int idFaktury = sc.nextInt();
                    if(inv.validID(idFaktury)){
                        inv.printInvoice(idFaktury);
                        Item item = new Item(myConn);
                        System.out.println("~faktura wyświetlona~");
                    }
                    else{
                        System.out.println("~Błędne ID faktury~");
                    }
                }
            }
            if(command.equals("4")){//Wyświetl pozycję
                System.out.println("WYSWIETLANIE POZYCJI");
                Invoice inv = new Invoice(myConn);
                Item item = new Item(myConn);
                if(inv.tableEmpty()){//pusta
                    System.out.println("~Brak faktur!~");
                }
                else{               //nie pusta
                    System.out.println("O którą fakturę chodzi?");
                    inv.showInvoices();
                    System.out.println("ID faktury:");
                    int idFaktury = sc.nextInt();
                    if(inv.validID(idFaktury)) {
                        System.out.println("O którą pozycję chodzi?");
                        item.showItems(idFaktury);
                        System.out.println("ID pozycji:");
                        int idPozycji = sc.nextInt();
                        item.printOneItem(idFaktury, idPozycji);
                        System.out.println("~pozycja wyświetlona~");
                    }
                    else{
                        System.out.println("~Błędne ID faktury~");
                    }
                }
            }
            if(command.equals("5")){//Aktualizuj fakturę

            }
            if(command.equals("6")){//Aktualizuj pozycję

            }
            if(command.equals("7")){//Usuń fakturę                      //NA RAZIE USUWA TYLKO TE PUSTE
                System.out.println("USUWANIE FAKTURY");
                Invoice inv = new Invoice(myConn);
                if(inv.tableEmpty()){//pusta
                    System.out.println("~Brak faktur!~");
                }
                else{               //nie pusta
                    System.out.println("Którą fakturę usunąć");
                    inv.showInvoices();
                    System.out.println("ID faktury:");
                    int idFaktury = sc.nextInt();
                    if(inv.validID(idFaktury)){
                        inv.deleteInvoiceAndItems(idFaktury);
                        System.out.println("~faktura usunięta~");
                    }
                    else{
                        System.out.println("~Błędne ID faktury~");
                    }
                }
            }
            if(command.equals("8")){//Usuń pozycję
                System.out.println("USUWANIE POZYCJI");
                Item item = new Item(myConn);
                System.out.println("O którą pozycję chodzi?");
                item.showAllItems();
                System.out.println("ID pozycji:");
                int idPozycji = sc.nextInt();
                item.deleteOneItems(idPozycji);
                System.out.println("~pozycja usunięta~");
            }
            command = sc.next();
        }//while(!command.equals("0")){
    }
}
