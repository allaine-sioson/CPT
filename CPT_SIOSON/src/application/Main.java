package application;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner input = new Scanner(System.in);
        // create the user
        User user;

        // get data from JSON data file
        String name = Methods.getStringData("data.json", "Name");
        String gender = Methods.getStringData("data.json", "Gender");
        String diet = Methods.getStringData("data.json", "Diet");
        String religion = Methods.getStringData("data.json", "Religion");

        // place the data in an array to check if it's empty
        String[] data = {name, gender, diet, religion};

        // if the data is empty
        if (Methods.checkForEmpty(data)) {
            System.out.println("\n· · ─ · · ─ · ·\n");
            System.out.println("Hi! You must be new here!\n");
            // ask user for their name
            System.out.print("Please enter your name: ");
            name = input.nextLine();
            // ask user for their gender
            System.out.print("Please enter your biological gender: ");
            gender = input.nextLine();
            // ask user for their diet 
            System.out.print("Please enter your type of diet: ");
            diet = input.nextLine();
            // ask user for their religion
            System.out.print("Please enter your religion: ");
            religion = input.nextLine();
            // create user with the given data
            user = new User(name, gender, diet, religion);
        } else { // if the data isn't empty
            // create the user with the given data from the JSON data file
            user = new User(name, gender, diet, religion);
        }
        // divider
        System.out.println("\n· · ─ · · ─ · ·\n");
        // greeting
        System.out.println("Hello " + name + "! :3");
        // display the main menu
        String choice = displayMainMenu(input);
        
        do {
            // divider
            System.out.println("\n· · ─ · · ─ · ·\n");
            // if the user chose "W" (view profile section)
            if (choice.equals("W")) {
                choice = displayProfileMenu(input, user, name, gender, diet, religion);
            // if the user chose "A" (view Nutrition section)
            } else if (choice.equals("A")) {
                System.out.println("hello! \n");
            // if the user chose "S" (view skincare section)
            } else if (choice.equals("S")) {
                System.out.println("hello! \n");
            // if the user chose "D" (view mental health section)
            } else if (choice.equals("D")) {
                System.out.println("hello! \n");
            // if the user chose "Q" (quit)
            } else if (choice.equals("Q")) {
                // break out of loop
                break;
            }
            // repeat question
            choice = displayMainMenu(input);
        // while the user hasn't chosen to quit
        } while (!choice.equals("Q"));

        // close the input
        input.close();

        // display quit text
        System.out.println("\n· · ─ · · ─ · ·\n");
        System.out.println("Bye Bye! (0'v')/");
        System.out.println("\n· · ─ · · ─ · ·\n");
        // quit program
        System.exit(0);

    }

    public static String displayMainMenu(Scanner input) {
        // initialize a default choice
        String choice = "";
        do {
            // display "Main Menu" text
            System.out.println("\n· · ─ · · ─ · ·\n");
            System.out.println("What would you like to do today?\n");
            System.out.println("· · ─ · · ─ · ·\n");
            System.out.println("[W] Profile");
            System.out.println("[A] Nutrition");
            System.out.println("[S] Skincare");
            System.out.println("[D] Mental Health");
            System.out.println("[Q] Quit\n");

            // ask user to input choice
            System.out.print("Input here: ");
            // ensure that the user's choice is in uppercase
            choice = input.nextLine().toUpperCase();
        // repeat until the choice is one of the given options  
        } while (!choice.equals("W") && !choice.equals("A") && !choice.equals("S") && !choice.equals("D") && !choice.equals("Q"));
        // return the choice
        return choice;
    }

    public static String displayProfileMenu(Scanner input, User user, String name, String gender, String diet, String religion) {
        // initialize a default choice
        String choice = "";

        do {
            // display "Profile Menu" text
            System.out.println("\n· · ─ · · ─ · ·\n");
            System.out.println("Welcome to your profile!\n");
            System.out.println("· · ─ · · ─ · ·\n");
            System.out.println("[W] View information");
            System.out.println("[A] Change Information");
            System.out.println("[S] Reset User");
            System.out.println("[D] Go back\n");

           // ask user to input choice
           System.out.print("Input here: ");
           // ensure that the user's choice is in uppercase
           choice = input.nextLine().toUpperCase();
        // repeat until the choice is one of the given options  
        } while (!choice.equals("W") && !choice.equals("A") && !choice.equals("S") && !choice.equals("D"));
        // 
        if (!choice.equals("D")) {
            choice = displaySubProfileMenu(input, choice, user, name, gender, diet, religion);
        } else {
            choice = "";
        }

        return choice;
    }

    public static String displaySubProfileMenu(Scanner input, String choice, User user, String name, String gender, String diet, String religion) {
        System.out.println("\n· · ─ · · ─ · ·\n");

        do {
            if (choice.equals("W")) {
                System.out.println(user);
            } else if (choice.equals("A")) {
                System.out.println("TBA");
            } else if (choice.equals("S")) {
                user = new User("", "", "", "");
                refreshData(name, gender, diet, religion);
                System.out.println("Your user information has been successfully cleared");
            }

            choice = displayProfileMenu(input, user, name, gender, diet, religion);
        } while (!choice.equals(""));

        return choice;
    }

    public static void refreshData(String name, String gender, String diet, String religion) {
        // refresh current data with data from JSON data file
        name = Methods.getStringData("data.json", "Name");
        gender = Methods.getStringData("data.json", "Gender");
        diet = Methods.getStringData("data.json", "Diet");
        religion = Methods.getStringData("data.json", "Religion");
    }
}
