import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String INPUT_PATH = "input.txt";
        final String OUTPUT_PATH = "output.txt";
        String fullText = readFile(INPUT_PATH);
        Scanner scanner = new Scanner(fullText);
        String fullScript = "";

        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split("\\s+");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");
            }
            String line = transformLine(words);
            System.out.println(line);
            fullScript += line + "\n";
        }
        scanner.close();
        saveToFile(OUTPUT_PATH, fullScript);
    }




    public static String readFile(String path){
        String allText = "";
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            allText = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allText;
    }

    public static String transformLine(String[] words){
        String value = "";
        if (words[0].equalsIgnoreCase("add")){
            value += "CREATE TABLE " + "'" + words[2] + "'" + ";";
        }
        if (words[0].equalsIgnoreCase("delete")){
            value += "DROP TABLE " + "'" + words[2] + "'" + ";";
        }
        if (words[0].equalsIgnoreCase("addTo")){
            value += "ALTER TABLE " + "'" + words[1] + "'" + " ADD " + words[3] + " " + words[4] + ";";
        }
        if (words[0].equalsIgnoreCase("deleteFrom")){
            value += "ALTER TABLE " + "'" + words[1] + "'" + " DROP COLUMN " + words[3] + ";";
        }
        if (words[0].equalsIgnoreCase("addPrim")){
            value += "ALTER TABLE " + "'" + words[3] + "'" + " ADD PRIMARY KEY " + "(" + words[1] + ")" + ";";
        }
        return value;
    }

    public static void saveToFile(String path, String line){
        try {
            PrintStream out = new PrintStream("output.txt");
            out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
