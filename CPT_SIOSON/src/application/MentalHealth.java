package application;

import java.util.ArrayList;

public class MentalHealth {
    private ArrayList<Medicine> medication;
    private String jokeOfTheDay;

    public MentalHealth() {
       this.medication = new ArrayList<Medicine>(); 
    }

    public ArrayList<Medicine> getMedication() {
        return medication;
    }

}
