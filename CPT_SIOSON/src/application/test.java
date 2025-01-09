package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

    LocalTime myObj = LocalTime.now();  // Create a date object
    LocalTime check = LocalTime.of(1, 0);
    System.out.println(myObj);  // Display the current date
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh:mm");
    String formattedDate = myObj.format(myFormatObj);
    System.out.println(formattedDate);

    if (myObj.isAfter(check)) {
        Methods.writeFile("cheese", "data.json");
    }
  }  

  public static String readFile(String name) {
        String filename = name + ".txt";
        File readFile = new File(filename);

        String data = "";

        try (Scanner myReader = new Scanner(readFile)) {
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
            e.printStackTrace();
        }

        return data;
    }
}


