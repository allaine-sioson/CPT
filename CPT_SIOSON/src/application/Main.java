package application;

import java.util.*;


 
// Program for print data in JSON format.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = Methods.getData("data.json", "Name");
        String gender = Methods.getData("data.json", "Gender");
        

        if (name == null || gender == null) {
            System.out.println("\n· · ─ · · ─ · ·\n");
            System.out.println("Hi! You must be new here!\n");

            System.out.print("Please enter your name: ");
            name = input.nextLine();

            System.out.print("Please enter your biological gender: ");
            gender = input.nextLine();

            new User(name, gender);
        } else {
            new User(name, gender);
        }

        System.out.println("\n· · ─ · · ─ · ·\n");
        
        System.out.println("Hello " + name + "! :3");

        String choice = null;

        do {
            System.out.println("What would you like to do today?\n");
            System.out.println("· · ─ · · ─ · ·\n");
            System.out.println("[W] Profile");
            System.out.println("[A] Nutrition");
            System.out.println("[S] Skincare");
            System.out.println("[D] Mental Health");
            System.out.println("[Q] Quit\n");

            System.out.print("Input here: ");
            choice = input.nextLine().toUpperCase();
            
        } while (!choice.equals("W") && !choice.equals("A") && !choice.equals("S") && !choice.equals("D") && !choice.equals("Q"));

        System.out.println("\n· · ─ · · ─ · ·\n");
        
        if (choice.equals("Q")) {
            System.out.println("Bye Bye! (0'v')/");
            System.exit(0);
        } else if (choice.equals("S")) {
            System.out.println("Bye Bye! (0'v')/");
            System.exit(0);
        }

        input.close();
    }
}
