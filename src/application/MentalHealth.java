package application;

import java.util.ArrayList;

public class MentalHealth {
    private ArrayList<Medicine> medication;
    private String dailyChallenge;

    public MentalHealth() {
       this.medication = new ArrayList<Medicine>(); 
       this.dailyChallenge = findDailyChallenge();
    }

    public ArrayList<Medicine> getMedication() {
        return medication;
    }

    public String getDailyChallenge() {
        return this.dailyChallenge;
    }

    public String findDailyChallenge() {
        String[] challenges = Methods.readFile("challenges.txt").split("\\.");
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

        return challenges[dayOfYear-1];
    }

}
