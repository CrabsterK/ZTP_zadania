import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String INPUT_PATH = "input.txt";
        final String OUTPUT_PATH = "output.txt";
        String fullText = readFile(INPUT_PATH);
        Scanner scanner = new Scanner(fullText);
        String fullScript = "";
        FileOutputStream errOut = null;

        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split("\\s+");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");
            }
            try {
                String line = transformLine(words);
                System.out.println(line);
                fullScript += line + "\n";
            } catch(Exception e){
                try {
                    if(errOut == null) {
                        errOut = new FileOutputStream("log.err");   // Zapis do dziennika
                    }
                    System.setErr(new PrintStream(errOut));
                    String errLine = "";
                    for (int i = 0; i < words.length; i++) {
                        errLine += words[i] + " ";
                    }
                    System.err.println("Exception in row: '" + errLine + "' : " + e);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }
        scanner.close();
        saveToFile(OUTPUT_PATH, fullScript);
    }




    public static String readFile(String path){
        String wholeText = "";
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            wholeText = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wholeText;
    }

    public static String transformLine(String[] words){
        List add = new ArrayList();// Obsługa wyjątków przez użycie wartości domyślnych - nie do końca.
        add.add("add");
        add.add("ad");
        add.add("addd");
        List del = new ArrayList();
        del.add("del");
        del.add("delet");
        del.add("delete");
        List addCol = new ArrayList();
        addCol.add("addto");
        addCol.add("addTo");
        addCol.add("addToo");
        addCol.add("addtoo");
        List delCol = new ArrayList();
        delCol.add("deleteFrom");
        delCol.add("deletefrom");
        List addPrim = new ArrayList();
        addPrim.add("addPrim");
        addPrim.add("addPrimary");
        addPrim.add("addprim");
        addPrim.add("addprimary");

        String value = "";
        if (add.contains(words[0])){
            value += "CREATE TABLE " + "'" + words[2] + "'" + ";";
        }
        else if (del.contains(words[0])){
            value += "DROP TABLE " + "'" + words[2] + "'" + ";";
        }
        else if (addCol.contains(words[0])){
            value += "ALTER TABLE " + "'" + words[1] + "'" + " ADD " + words[3] + " " + words[4] + ";";
        }
        else if (delCol.contains(words[0])){
            value += "ALTER TABLE " + "'" + words[1] + "'" + " DROP COLUMN " + words[3] + ";";
        }
        else if (addPrim.contains(words[0])){
            value += "ALTER TABLE " + "'" + words[3] + "'" + " ADD PRIMARY KEY " + "(" + words[1] + ")" + ";";
        }
        else{
            throw new IllegalArgumentException("Wrong input line");
        }
        return value;
    }

    public static void saveToFile(String path, String line){

        try {
            PrintStream out = new PrintStream(path);
            out.println(line);
        } catch (FileNotFoundException e) {
            saveToFile("output2.txt", line); // Wywołanie operacji alternatywnej
        }
    }
}
