package application;

/**
 * author: Allaine
 * date: 15/01/2025
 * Main File
 */

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
        System.out.println("Daily Challenge: " + user.getDailyChallenge());
        // display the main menu
        String choice = displayMainMenu(input, name, gender, diet, religion);
        
        do {
            // divider
            System.out.println("\n· · ─ · · ─ · ·");
            // if the user chose "1" (view profile section)
            if (choice.equals("1")) {
                choice = displayProfileMenu(input, user, name, gender, diet, religion);
            // if the user chose "2" (view Nutrition section)
            } else if (choice.equals("2")) {
                choice = displayNutritionMenu(input, user);
            // if the user chose "3" (view skincare section)
            } else if (choice.equals("3")) {
                choice = displaySkincareMenu(input, user);
            // if the user chose "4" (view mental health section)
            } else if (choice.equals("4")) {
                System.out.println("hello! \n");
            // if the user chose "Q" (quit)
            } else if (choice.equals("Q")) {
                // break out of loop
                break;
            }
            // repeat question
            System.out.println("\n· · ─ · · ─ · ·\n");
            if (!choice.equals("Q")) {
                choice = displayMainMenu(input, name, gender, diet, religion);
            }
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

    /**
     * Displays the main menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param name Name of user
     * @param gender Gender of user
     * @param diet Diet of User
     * @param religion Religion of User
     * @return the choice the user made
     */
    public static String displayMainMenu(Scanner input, String name, String gender, String diet, String religion) {
        // initialize a default choice
        String choice = "";
        do {
            // display "Main Menu" text
            System.out.println("What would you like to do today?");
            System.out.println("\n· · ─ · · ─ · ·\n");
            System.out.println("[1] Profile");
            System.out.println("[2] Nutrition");
            System.out.println("[3] Skincare");
            System.out.println("[4] Mental Health");
            System.out.println("[Q] Quit\n");

            // ask user to input choice
            System.out.print("Input here: ");
            // ensure that the user's choice is in uppercase
            choice = input.nextLine().toUpperCase();
        // repeat until the choice is one of the given options  
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("Q"));
        // return the choice
        return choice;
    }

    /**
     * Displays the profile menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param user The user
     * @param name Name of user
     * @param gender Gender of user
     * @param diet Diet of User
     * @param religion Religion of User
     * @return the choice the user made
     */
    public static String displayProfileMenu(Scanner input, User user, String name, String gender, String diet, String religion) {
        // initialize a default choice
        String choice = "";

        do {
            // display "Profile Menu" text
            System.out.println("\nWelcome to your profile!\n");
            System.out.println("· · ─ · · ─ · ·\n");
            System.out.println("[1] View information");
            System.out.println("[2] Change Information");
            System.out.println("[3] Reset User");
            System.out.println("[4] Go back\n");

           // ask user to input choice
           System.out.print("Input here: ");
           // ensure that the user's choice is in uppercase
           choice = input.nextLine().toUpperCase();
        // repeat until the choice is one of the given options  
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));

        // if the choice isn't 4
        if (!choice.equals("4")) {
            // display the "Sub Profile Menu" based on what choice the user made
            choice = displayProfileMenuResults(input, choice, user, name, gender, diet, religion);
        // if the choice also isn't "Q"
        } else if (!choice.equals("Q")) {
            // make the choice blank
            choice = "";
        }

        // return the user's choice
        return choice;
    }

    /**
     * Displays the profile menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param choice The previous choice the user made
     * @param user The user's information
     * @param name Name of user
     * @param gender Gender of user
     * @param diet Diet of User
     * @param religion Religion of User
     * @return the new choice the user made
     */
    public static String displayProfileMenuResults(Scanner input, String choice, User user, String name, String gender, String diet, String religion) {
        // print divider
        System.out.println("\n· · ─ · · ─ · ·");

        do {
            // if user chose option 1, display user info.
            if (choice.equals("1")) {
                System.out.println("\n" + user);
            // if user chose option 2, display change user info. menu
            } else if (choice.equals("2")) {
                changeUserInfo(input, user, name, gender, diet, religion);
            // if user chose option 3, set user info to blank and quit program
            } else if (choice.equals("3")) {
                user = new User("", "", "", "");
                user.resetNutrition();
                user.resetSkincare();
                System.out.println("\nYour user information has been successfully cleared!\nQuitting Program.");
                choice = "Q";
                break;
            }
            // print divider
            System.out.println("\n· · ─ · · ─ · ·");

            // display profile menu text
            choice = displayProfileMenu(input, user, name, gender, diet, religion);
        // repeat until user's choice is one of the given options
        } while (!choice.equals("") && !choice.equals("Q"));

        return choice;
    }

    /**
     * Displays "changing user info" menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     * @param name Name of user
     * @param gender Gender of user
     * @param diet Diet of User
     * @param religion Religion of User
     */
    public static void changeUserInfo(Scanner input, User user, String name, String gender, String diet, String religion) {
        String choice = "";
        
        do {
            // display the "changing user info" menu
            System.out.println("\nWhat would you like to change?\n");
            System.out.println("[1] Name");
            System.out.println("[2] Gender");
            System.out.println("[3] Diet");
            System.out.println("[4] Religion");
            System.out.println("[5] Cancel\n");

            // ask user to input choice
            System.out.print("Input here: ");
            // ensure that the user's choice is in uppercase
            choice = input.nextLine().toUpperCase();

        // repeat until the choice is one of the given options     
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5"));

        // divider
        System.out.println("\n· · ─ · · ─ · ·");

        // check which choice the user made
        switch (choice) {
            // if the user chooses option 1 (change name)
            case "1":
                // ask user to input name
                System.out.print("New name: ");
                name = input.nextLine();
                // set the new name  
                user.setName(name);
                break;
            // if the user chooses option 2 (change gender)
            case "2":
                // ask user to input gender
                System.out.print("New gender: ");
                gender = input.nextLine();
                // set the new gender  
                user.setGender(gender);
                break;
            // if the user chooses option 3 (change diet)
            case "3":
                // ask user to input diet
                System.out.print("New diet: ");
                diet = input.nextLine();
                // set the new diet  
                user.setDiet(diet);
                break;
            // if the user chooses option 4 (change religion)
            case "4":
                // ask user to input religion
                System.out.print("New religion: ");
                religion = input.nextLine();
                // set the new religion  
                user.setReligion(religion);
                break;
            // if the user chooses option 5 (cancel action)
            case "5":
                break;
        } 
    }

    /**
     * Displays the nutrition menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param user The user
     * @return the choice the user made
     */
    public static String displayNutritionMenu(Scanner input, User user) {
        // initialize a default choice
        String choice = "";

        do {
            // display "Nutrition Menu" text
            System.out.println("\nFeeling Hungry? :3\n");
            System.out.println("· · ─ · · ─ · ·\n");
            System.out.println("[1] Edit Meal Plan");
            System.out.println("[2] Add Nutritional Medication");
            System.out.println("[3] \"Is this food okay for me?\"");
            System.out.println("[4] Go back\n");

           // ask user to input choice
           System.out.print("Input here: ");
           // ensure that the user's choice is in uppercase
           choice = input.nextLine().toUpperCase();
        // repeat until the choice is one of the given options  
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));

        // if the choice isn't 4
        if (!choice.equals("4")) {
            // display the "Sub Nutrition Menu" based on what choice the user made
            choice = displayNutritionMenuResults(input, choice, user);
        } else {
            // make the choice blank
            choice = "";
        }

        // return the user's choice
        return choice;
    }

    /**
     * Displays the nutrition menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param choice The previous choice the user made
     * @param user The user's information
     * @return the new choice the user made
     */
    public static String displayNutritionMenuResults(Scanner input, String choice, User user) {
        // print divider
        System.out.println("\n· · ─ · · ─ · ·");

        do {
            // if user chose option 1, edit meal plan
            if (choice.equals("1")) {
                editMealPlan(input, user);
            // if user chose option 2, allow user to add new med
            } else if (choice.equals("2")) {
                String medName = "";
                String brand = "";
                int doses = 0;
            
                do {
                    System.out.print("What is the name of your medication?: ");
                    medName = input.nextLine();
                } while (medName.equals(""));

                System.out.println("\n· · ─ · · ─ · ·\n");

                do {
                    System.out.print("How many doses?: ");
                    doses = input.nextInt();
                } while (doses <= 0);

                System.out.println("\n· · ─ · · ─ · ·\n");
                input.nextLine();

                do {
                    System.out.print("What brand?: ");
                    brand = input.nextLine();
                } while (brand.equals(""));
 
                Medicine medication = new Medicine(medName, doses);
                medication = Medicine.getSpecificMedicine(medName, brand, doses);

                user.addNutritionMedication(medication);
                break;
            // if user chose option 3, check if food is okay for user
            } else if (choice.equals("3")) {
                System.out.print("What is the name of your food?: ");
                String food = input.nextLine();

                System.out.println("\n· · ─ · · ─ · ·\n");

                boolean result = user.isOkayForMe(input, food);

                System.out.println("\n· · ─ · · ─ · ·\n");

                if (result == true) {
                    System.out.println(food + " is okay for your diet!");
                } else {
                    System.out.println(food + " is NOT okay for your diet.");
                }
            }
            // print divider
            System.out.println("\n· · ─ · · ─ · ·");

            // display nutrition menu text
            choice = displayNutritionMenu(input, user);
        // repeat until user's choice is one of the given options
        } while (!choice.equals(""));

        return choice;
    }

    /**
     * Displays meal plan menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     */
    public static void editMealPlan(Scanner input, User user) {
        String choice = "";
        
        do {
            // display the "changing user info" menu
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("[1] View Meal Plan");
            System.out.println("[2] Edit Breakfast");
            System.out.println("[3] Edit Lunch");
            System.out.println("[4] Edit Dinner");
            System.out.println("[5] Cancel\n");

            // ask user to input choice
            System.out.print("Input here: ");
            // ensure that the user's choice is in uppercase
            choice = input.nextLine().toUpperCase();

        // repeat until the choice is one of the given options     
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5"));

        // divider
        System.out.println("\n· · ─ · · ─ · ·");

        // check which choice the user made
        switch (choice) {
            // if the user chooses option 1 (print meal plan)
            case "1":
                System.out.println(user.getMealPlan());
                break;
            // if the user chooses option 2 (edit breakfast)
            case "2":
                // ask user to input breakfast
                System.out.print("Change breakfast: ");
                String breakfast = input.nextLine();
                // set the new breakfast  
                user.setBreakfast(breakfast);
                break;
            // if the user chooses option 3 (edit lunch)
            case "3":
                // ask user to input lunch
                System.out.print("Change lunch: ");
                String lunch = input.nextLine();
                // set the new lunch  
                user.setLunch(lunch);
                break;
            // if the user chooses option 4 (edit dinner)
            case "4":
                // ask user to input dinner
                System.out.print("Change dinner: ");
                String dinner = input.nextLine();
                // set the new dinner  
                user.setDinner(dinner);
                break;
            // if the user chooses option 5 (cancel action)
            case "5":
                break;
        } 
    }

    /**
     * Displays the skincare menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param user The user
     * @return the choice the user made
     */
    public static String displaySkincareMenu(Scanner input, User user) {
        // initialize a default choice
        String choice = "";

        do {
            // display "Skincare Menu" text
            System.out.println("\nRejuvenating Time! :D\n");
            System.out.println("· · ─ · · ─ · ·\n");
            System.out.println("[1] Skincare Routine");
            System.out.println("[2] Add Skincare Medication");
            System.out.println("[3] Skin Concerns");
            System.out.println("[4] Go back\n");

           // ask user to input choice
           System.out.print("Input here: ");
           // ensure that the user's choice is in uppercase
           choice = input.nextLine().toUpperCase();
        // repeat until the choice is one of the given options  
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));

        // if the choice isn't 4
        if (!choice.equals("4")) {
            // display the "Skincare Menu Results" based on what choice the user made
            choice = displaySkincareMenuResults(input, choice, user);
        } else {
            // make the choice blank
            choice = "";
        }

        // return the user's choice
        return choice;
    }

    /**
     * Displays the skincare menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param choice The previous choice the user made
     * @param user The user's information
     * @return the new choice the user made
     */
    public static String displaySkincareMenuResults(Scanner input, String choice, User user) {
        // print divider
        System.out.println("\n· · ─ · · ─ · ·");

        do {
            // if user chose option 1, add to skincare routine
            if (choice.equals("1")) {
                editSkincareRoutine(input, user);
            // if user chose option 2, allow user to add new med
            } else if (choice.equals("2")) {
                String medName = "";
                String brand = "";
                int doses = 0;
            
                do {
                    System.out.print("What is the name of your medication?: ");
                    medName = input.nextLine();
                } while (medName.equals(""));

                System.out.println("\n· · ─ · · ─ · ·\n");

                do {
                    System.out.print("How many doses?: ");
                    doses = input.nextInt();
                } while (doses <= 0);

                System.out.println("\n· · ─ · · ─ · ·\n");
                input.nextLine();

                do {
                    System.out.print("What brand?: ");
                    brand = input.nextLine();
                } while (brand.equals(""));
 

                Medicine medication = new Medicine(medName, doses);
                medication = Medicine.getSpecificMedicine(medName, brand, doses);
                user.addSkincareMedication(medication);
                break;
            // if user chose option 3, edit skin concerns
            } else if (choice.equals("3")) {
                editSkinConcerns(input, user);
            }
            // print divider
            System.out.println("\n· · ─ · · ─ · ·");

            // display profile menu text
            choice = displaySkincareMenu(input, user);
        // repeat until user's choice is one of the given options
        } while (!choice.equals(""));

        return choice;
    }

    /**
     * Displays skincare routine menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     */
    public static void editSkincareRoutine(Scanner input, User user) {
        String choice = "";
        
        do {
            // display the "skincare routine" menu
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("[1] View Routine");
            System.out.println("[2] Add to routine");
            System.out.println("[3] Reset Routine");
            System.out.println("[4] Cancel\n");

            // ask user to input choice
            System.out.print("Input here: ");
            // ensure that the user's choice is in uppercase
            choice = input.nextLine().toUpperCase();

        // repeat until the choice is one of the given options     
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));

        // divider
        System.out.println("\n· · ─ · · ─ · ·");

        // check which choice the user made
        switch (choice) {
            // if the user chooses option 1 (print routine)
            case "1":
                System.out.println(user.getSkincareRoutine());
                break;
            // if the user chooses option 2 (add to routine)
            case "2":
                // ask user to input new step
                System.out.print("New step: ");
                String step = input.nextLine();
                // set the new step  
                user.addToSkincareRoutine(step);
                break;
            // if the user chooses option 3 (reset routine)
            case "3":
                // reset the routine
                user.resetSkincareRoutine();
                break;
            // if the user chooses option 4 (cancel action)
            case "4":
                break;
        } 
    }

    /**
     * Displays skincare routine menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     */
    public static void editSkinConcerns(Scanner input, User user) {
        String choice = "";
        
        do {
            // display the "skin concerns" menu
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("[1] View Concerns");
            System.out.println("[2] Add to concerns");
            System.out.println("[3] Reset Concerns");
            System.out.println("[4] Cancel\n");

            // ask user to input choice
            System.out.print("Input here: ");
            // ensure that the user's choice is in uppercase
            choice = input.nextLine().toUpperCase();

        // repeat until the choice is one of the given options     
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));

        // divider
        System.out.println("\n· · ─ · · ─ · ·");

        // check which choice the user made
        switch (choice) {
            // if the user chooses option 1 (print concerns)
            case "1":
                System.out.println(user.getSkinConcerns());
                break;
            // if the user chooses option 2 (add to concerns)
            case "2":
                // ask user to input new step
                System.out.print("New concern: ");
                String concern = input.nextLine();
                // set the new step  
                user.addToSkinConcerns(concern);
                break;
            // if the user chooses option 3 (reset concerns)
            case "3":
                // reset the concerns
                user.resetSkinConcerns();
                break;
            // if the user chooses option 4 (cancel action)
            case "4":
                break;
        } 
    }

    /**
     * Displays the profile menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param user The user
     * @param name Name of user
     * @param gender Gender of user
     * @param diet Diet of User
     * @param religion Religion of User
     * @return the choice the user made
     */
    public static String displayMentalMenu(Scanner input, User user, String name, String gender, String diet, String religion) {
        // initialize a default choice
        String choice = "";

        do {
            // display "Profile Menu" text
            System.out.println("\nWelcome to your profile!\n");
            System.out.println("· · ─ · · ─ · ·\n");
            System.out.println("[1] View information");
            System.out.println("[2] Change Information");
            System.out.println("[3] Reset User");
            System.out.println("[4] Go back\n");

           // ask user to input choice
           System.out.print("Input here: ");
           // ensure that the user's choice is in uppercase
           choice = input.nextLine().toUpperCase();
        // repeat until the choice is one of the given options  
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));

        // if the choice isn't 4
        if (!choice.equals("4")) {
            // display the "Sub Profile Menu" based on what choice the user made
            choice = displayProfileMenuResults(input, choice, user, name, gender, diet, religion);
        // if the choice also isn't "Q"
        } else if (!choice.equals("Q")) {
            // make the choice blank
            choice = "";
        }

        // return the user's choice
        return choice;
    }

    
}