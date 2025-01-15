package application;

import java.util.*;

public class MentalHealth {
    private ArrayList<Medicine> medication;
    private String dailyChallenge;
    private Queue<String> previousChallenges;

    public MentalHealth() {
       this.medication = new ArrayList<Medicine>(); 
       this.dailyChallenge = findDailyChallenge();
       this.previousChallenges = new Queue<>();
    }

    public ArrayList<Medicine> getMedication() {
        return medication;
    }

    public String getDailyChallenge() {
        return this.dailyChallenge;
    }

    public Queue<String> getPreviousChallenges() {
        return this.previousChallenges;
    }

    public void viewPreviousChallenges(Scanner input) {
        String[] challenges = Methods.readFile("challenges.txt").split("\\.");
        for (int i = 0; i < getDayOfYear()-2; i++) {
            this.previousChallenges.enqueue(challenges[i]);
        }

        String choice = "";
        String challengesHead = this.previousChallenges.dequeue();

        do {
            if (this.previousChallenges.isEmpty()) {
                for (int i = 0; i < getDayOfYear()-2; i++) {
                    this.previousChallenges.enqueue(challenges[i]);
                }
            }
            System.out.println(challengesHead);
            System.out.println("\nCheck previous?\n");
            System.out.print("Y/N: ");
            choice = input.nextLine().toUpperCase();

            if (choice.equals("Y")) {
                challengesHead = this.previousChallenges.dequeue();
            }
        } while (!choice.equals("N"));
    }

    public String findDailyChallenge() {
        String[] challenges = Methods.readFile("challenges.txt").split("\\.");
        int dayOfYear = getDayOfYear();

        return challenges[dayOfYear-1];
    }

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

}
