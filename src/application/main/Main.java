package application.main;

import java.util.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Main File
 */

/**
 * Main class that serves as the entry point for the application
 */
public class Main {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner input = new Scanner(System.in);
        // create the user
        User user;

        // get data from JSON data file
        String name = Methods.getStringData("main\\data.json", "Name");
        String gender = Methods.getStringData("main\\data.json", "Gender");
        String diet = Methods.getStringData("main\\data.json", "Diet");
        String religion = Methods.getStringData("main\\data.json", "Religion");

        // place the data in an array to check if it's empty
        String[] data = {name, gender, diet, religion};

        // if the data is empty
        if (Methods.checkForEmpty(data)) {
            System.out.println("\n· · ─ · · ─ · ·\n");
            System.out.println("Hi! You must be new here!\n");
            // ask user for their name
            System.out.print("Please enter your name: ");
            name = input.nextLine();
            System.out.println("\n· · ─ · · ─ · ·\n");
            // ask user for their gender
            System.out.print("Please enter your gender: ");
            gender = input.nextLine();
            System.out.println("\n· · ─ · · ─ · ·\n");
            // ask user for their diet 
            System.out.println("NOTE: If your diet isn't listed and it has dietary restrictions, please manually add your dietary restrictions in the allergies section. ");
            System.out.println("[Vegan, Vegetarian, Pescatarian]");
            System.out.print("Please enter your type of diet: ");
            diet = input.nextLine();
            System.out.println("\n· · ─ · · ─ · ·\n");
            // ask user for their religion
            System.out.println("NOTE: If your religion isn't listed and it has dietary restrictions,\nplease manually add your dietary restrictions in the allergies section. ");
            System.out.println("[Jewish, Hindu, Muslim, Sikhism]");
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
        String choice = displayMainMenu(input);
        
        do {
            // if the user chose "1" (view profile section)
            if (choice.equals("1")) {
                choice = displayProfileMenu(input, user);
            // if the user chose "2" (view Nutrition section)
            } else if (choice.equals("2")) {
                choice = displayNutritionMenu(input, user);
            // if the user chose "3" (view skincare section)
            } else if (choice.equals("3")) {
                choice = displaySkincareMenu(input, user);
            // if the user chose "4" (view mental health section)
            } else if (choice.equals("4")) {
                choice = displayMentalHealthMenu(input, user);
            // if the user chose "Q" (quit)
            } else if (choice.equals("Q")) {
                // break out of loop
                break;
            }
            // repeat question
            System.out.println("\n· · ─ · · ─ · ·\n");
            if (!choice.equals("Q")) {
                choice = displayMainMenu(input);
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
     * @return the choice the user made
     */
    public static String displayMainMenu(Scanner input) {
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
     * @return the choice the user made
     */
    public static String displayProfileMenu(Scanner input, User user) {
        // initialize a default choice
        String choice = "";

        do {
            do {
                // print divider
                System.out.println("\n· · ─ · · ─ · ·");
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

            // if user chose option 1, display user info.
            switch (choice) {
                // if user chose option 1, display user info.
                case "1":
                    // print divider
                    System.out.println("\n· · ─ · · ─ · ·");
                    System.out.println("\n" + user);
                    break;
                // if user chose option 2, display change user info. menu
                case "2":
                    changeUserInfo(input, user);
                    break;
                // if user chose option 3, reset all user info and quit program
                case "3":
                    // print divider
                    System.out.println("\n· · ─ · · ─ · ·");
                    // reset user info
                    user.resetUser();
                    // print success message
                    System.out.println("\nYour user information has been successfully cleared!\nQuitting Program...");
                    // quit program
                    choice = "Q";
                    break;
                case "4":
                    choice = "";
                    break;
            }
        // repeat until user's choice is one of the given options
        } while (!choice.equals("") && !choice.equals("Q"));

        // return the user's choice
        return choice;
    }

    /**
     * Displays "changing user info" menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     */
    public static void changeUserInfo(Scanner input, User user) {
        String choice = "";
        
        do {
            // print divider
            System.out.println("\n· · ─ · · ─ · ·");
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
                String name = input.nextLine();
                // set the new name  
                user.setName(name);
                break;
            // if the user chooses option 2 (change gender)
            case "2":
                // ask user to input gender
                System.out.print("New gender: ");
                String gender = input.nextLine();
                // set the new gender  
                user.setGender(gender);
                break;
            // if the user chooses option 3 (change diet)
            case "3":
                // ask user to input diet
                System.out.print("New diet: ");
                String diet = input.nextLine();
                // set the new diet  
                user.setDiet(diet);
                break;
            // if the user chooses option 4 (change religion)
            case "4":
                // ask user to input religion
                System.out.print("New religion: ");
                String religion = input.nextLine();
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
            do {
                // print divider
                System.out.println("\n· · ─ · · ─ · ·");
                // display "Nutrition Menu" text
                System.out.println("\nFeeling Hungry? :3\n");
                System.out.println("· · ─ · · ─ · ·\n");
                System.out.println("[1] Edit Meal Plan");
                System.out.println("[2] Add Nutritional Medication");
                System.out.println("[3] \"Is this food okay for me?\"");
                System.out.println("[4] Allergies");
                System.out.println("[5] Go back\n");
    
               // ask user to input choice
               System.out.print("Input here: ");
               // ensure that the user's choice is in uppercase
               choice = input.nextLine().toUpperCase();
            // repeat until the choice is one of the given options  
            } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5"));

            switch (choice) {
                case "1":
                    // if user chose option 1, edit meal plan
                    editMealPlan(input, user);
                    break;
                case "2":
                    // divider
                    System.out.println("\n· · ─ · · ─ · ·");
                    // if user chose option 2, allow user to add new med
                    Medicine medication = Medicine.newMedicine(input);
                    user.addNutritionMedication(medication);
                    break;
                case "3":
                    // divider
                    System.out.println("\n· · ─ · · ─ · ·");
                    /// if user chose option 3, check if food is okay for user
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
                    break;  
                case "4":
                    // if user chose option 4, edit allergies
                    editAllergies(input, user);
                    break;
                case "5":
                    choice = "";
                    break;
            }
        // repeat until user's choice is one of the given options
        } while (!choice.equals(""));

        // return the user's choice
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
            do {
                // divider
                System.out.println("\n· · ─ · · ─ · ·");
                // display the "meal plan" menu
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
                    System.out.println("\n" + user.getMealPlan());
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
        } while (!choice.equals("5"));
    }

    /**
     * Displays allergies menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     */
    public static void editAllergies(Scanner input, User user) {
        String choice = "";
        
        do {
            do {
                // print divider
                System.out.println("\n· · ─ · · ─ · ·");
                // display the "allergies" menu
                System.out.println("\nWhat would you like to do?\n");
                System.out.println("[1] View Allergies");
                System.out.println("[2] Add to Allergies");
                System.out.println("[3] Reset Allergies");
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
                // if the user chooses option 1 (print allergies)
                case "1":
                    System.out.println(user.getAllergies());
                    break;
                // if the user chooses option 2 (add to allergies)
                case "2":
                    // ask user to input new step
                    System.out.print("New allergy: ");
                    String allergy = input.nextLine();
                    // set the new step  
                    user.addAllergy(allergy);
                    break;
                // if the user chooses option 3 (reset allergies)
                case "3":
                    // reset the allergies
                    user.resetAllergies();
                    System.out.println("Successfully reset allergies!");
                    break;
                // if the user chooses option 4 (cancel action)
                case "4":
                    break;
            } 
        } while (!choice.equals("4"));
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
            do {
                // divider
                System.out.println("\n· · ─ · · ─ · ·");
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
 
            switch (choice) {
                case "1":
                    // if user chose option 1, edit skincare routine
                    editSkincareRoutine(input, user);
                    break;
                case "2":
                    // divider
                    System.out.println("\n· · ─ · · ─ · ·");
                    // if user chose option 2, allow user to add new med
                    Medicine medication = Medicine.newMedicine(input);
                    user.addSkincareMedication(medication);
                    break;
                case "3":
                    // if user chose option 3, edit skin concerns
                    editSkinConcerns(input, user);
                    break;
                case "4":
                    choice = "";
                    break;
            }
        // repeat until user's choice is one of the given options
        } while (!choice.equals(""));

        // return the user's choice
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
            do {
                // divider
                System.out.println("\n· · ─ · · ─ · ·");
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
                    System.out.println("Successfully reset skincare routine!");
                    break;
                // if the user chooses option 4 (cancel action)
                case "4":
                    break;
            } 
        } while (!choice.equals("4"));
    }

    /**
     * Displays skin concerns menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     */
    public static void editSkinConcerns(Scanner input, User user) {
        String choice = "";
        
        do {
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
                    System.out.println("Successfully reset skin concerns!");
                    break;
                // if the user chooses option 4 (cancel action)
                case "4":
                    break;
            } 
        } while (!choice.equals("4"));
    }

    /**
     * Displays the mental health menu text and allows the user to input a choice
     * @param input Scanner to allow user input
     * @param user The user
     * @return the choice the user made
     */
    public static String displayMentalHealthMenu(Scanner input, User user) {
        // initialize a default choice
        String choice = "";

        do {
            do {
                // print divider
                System.out.println("\n· · ─ · · ─ · ·");
                // display "Mental Health Menu" text
                System.out.println("\nNeed to relax? (0 - V -)\n");
                System.out.println("· · ─ · · ─ · ·\n");
                System.out.println("[1] View daily challenge");
                System.out.println("[2] View previous challenges");
                System.out.println("[3] Add Mental Health Medication");
                System.out.println("[4] Reminders");
                System.out.println("[5] Go back\n");
    
                // ask user to input choice
                System.out.print("Input here: ");
                // ensure that the user's choice is in uppercase
                choice = input.nextLine().toUpperCase();
            // repeat until the choice is one of the given options  
            } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5"));
    
            // print divider
            System.out.println("\n· · ─ · · ─ · ·");

            switch (choice) {
                case "1":
                    // if user chose option 1, view daily challenge
                    System.out.println("\nDaily Challenge: " + user.getDailyChallenge());
                    break;
                case "2":
                    // if user chose option 2, view previous daily challenges
                    user.viewPreviousChallenges(input);
                    break;
                case "3":
                    // if user chose option 3, allow user to add new med
                    Medicine medication = Medicine.newMedicine(input);
                    user.addMentalHealthMedication(medication);
                    break;
                case "4":
                    // if user chose option 4, edit reminders
                    editReminders(input, user);
                    break;
                case "5":
                    choice = "";
                    break;
            }
        // repeat until user's choice is one of the given options
        } while (!choice.equals(""));

        // return the user's choice
        return choice;
    }

    
    /**
     * Displays mental health reminders menu and allows the user to change their information
     * @param input Scanner to allow user input
     * @param user The user's information
     */
    public static void editReminders(Scanner input, User user) {
        String choice = "";
        
        do {
            do {
                // display the "Reminders" menu
                System.out.println("\nWhat would you like to do?\n");
                System.out.println("[1] View Reminders");
                System.out.println("[2] Add to Reminders");
                System.out.println("[3] Reset Reminders");
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
                // if the user chooses option 1 (print reminders)
                case "1":
                    System.out.println(user.getReminders());
                    break;
                // if the user chooses option 2 (add to reminders)
                case "2":
                    // ask user to input new step
                    System.out.print("New reminder: ");
                    String reminder = input.nextLine();
                    // set the new step  
                    user.addMentalHealthReminder(reminder);
                    break;
                // if the user chooses option 3 (reset reminders)
                case "3":
                    // reset the concerns
                    user.resetReminders();
                    break;
                // if the user chooses option 4 (cancel action)
                case "4":
                    break;
            } 
        } while (!choice.equals("4"));
    }
}