package application.main;

import java.util.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Mental Health datatype
 */

 /**
  * The MentalHealth class represents a user's mental health data, including medication and reminders
  */
public class MentalHealth {
    private ArrayList<Medicine> medication;
    private ArrayList<String> reminders;
    private String dailyChallenge;
    private Queue<String> previousChallenges;

    /**
     * constructor for mental health class
     */
    public MentalHealth() {
       this.medication = new ArrayList<Medicine>(); 
       this.reminders = new ArrayList<String>();
       this.dailyChallenge = findDailyChallenge();
       this.previousChallenges = new Queue<>();

       getJSONMentalHealth();
    }

    /**
     * gets the user's mental health medication list
     * @return the user's mental health medication list
     */
    public ArrayList<Medicine> getMedication() {
        return medication;
    }

    /**
     * gets the daily challenge
     * @return the daily challenge
     */
    public String getDailyChallenge() {
        return this.dailyChallenge;
    }

    /**
     * gets the user's reminders
     * @return the user's reminders
     */
    public ArrayList<String> getReminders() {
        return this.reminders;
    }

    /**
     * gets the previous daily challenges
     * @return the previous daily challenges
     */
    public Queue<String> getPreviousChallenges() {
        return this.previousChallenges;
    }

    /**
     * adds a new medicine to the list of mental health medication
     * @param med the new medicine to be added
     */
    public void addMedication(Medicine med) {
        this.medication.add(med);
    }

    /**
     * adds a new reminder to the list of reminders
     * @param reminder the new reminder to be added
     */
    public void addReminder(String reminder) {
        this.reminders.add(reminder);
    }

    /**
     * resets the user's reminders
     */
    public void resetReminders() {
        this.reminders.clear();
    }

    /**
     * resets the user's mental health medication
     */
    public void resetMedication() {
        this.medication.clear();
    }

    /**
     * allows the user to go through the previous daily challenges
     * @param input scanner to allow user input
     */
    public void viewPreviousChallenges(Scanner input) {
        String[] challenges = Methods.readFile("assets\\challenges.txt").split("\\.");
        for (int i = 0; i < getDayOfYear(); i++) {
            this.previousChallenges.enqueue(challenges[i]);
        }

        int challengeDate = 1;
        String choice = "";
        String challengesHead = this.previousChallenges.dequeue();

        do {
            if (this.previousChallenges.isEmpty()) {
                System.out.println("No more challenges left. Resetting...");
                for (int i = 0; i < getDayOfYear(); i++) {
                    this.previousChallenges.enqueue(challenges[i]);
                    challengeDate = 1;
                }
            }
            System.out.println("Day " + challengeDate + ": " + challengesHead);
            System.out.println("\nCheck next?");
            System.out.print("Y/N: ");
            choice = input.nextLine().toUpperCase() + "\n";

            if (choice.equals("Y\n")) {
                challengesHead = this.previousChallenges.dequeue();
                challengeDate++;
            }
        } while (!choice.equals("N\n"));
    }

    /**
     * find the daily challenge in the list of daily challenges
     * @return
     */
    public String findDailyChallenge() {
        String[] challenges = Methods.readFile("assets\\challenges.txt").split("\\.");
        int dayOfYear = getDayOfYear();
        
        return challenges[dayOfYear-1];
    }
    
    /**
     * gets the current (ordinal) day of the year 
     * @return
     */
    public int getDayOfYear() {
        String[] currentDate = Methods.getCurrentDate().split("/");
        int days = 0;

        switch (currentDate[0]) {
            case "01":
                days += 0;
                break;
            case "02":
                days += 31;
                break;
            case "03":
                days += 59;
                break;
            case "04":
                days += 90;
                break;
            case "05":
                days += 120;
                break;
            case "06":
                days += 151;
                break;
            case "07":
                days += 181;
                break;
            case "08":
                days += 212;
                break;
            case "09":
                days += 243;
                break;
            case "10":
                days += 273;
                break;
            case "11":
                days += 304;
                break;
            case "12":
                days += 334;
                break;
        
            default:
                break;
        }

        int currentDay = Integer.parseInt(currentDate[1]);

        int dayOfYear = days + currentDay;

        return dayOfYear;
    }

    /**
     * gets the user's mental health information from the data.json file
     */
    public void getJSONMentalHealth() {
        String[] medJSON = Methods.getArrayData("main\\data.json", "Mental Health Medication");
        for (String med : medJSON) {
            String[] newMed = med.split("\\|");
            int doses = Integer.parseInt(newMed[1].replace("x", "").trim());

            this.medication.add(new Medicine(newMed[0].trim(), doses));
        }

        String[] remindersJSON = Methods.getArrayData("main\\data.json","Reminders");
        for (String reminder : remindersJSON) {
            this.reminders.add(reminder);
        }
    }

}
