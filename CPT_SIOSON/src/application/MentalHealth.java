package application;

import java.util.ArrayList;

public class MentalHealth {
    private ArrayList<String> medication, randomQuotes;
    private String jokeOfTheDay;

    public MentalHealth(ArrayList<String> medication, ArrayList<String> randomQuotes, String jokeOfTheDay) {
        this.medication = medication;
        this.randomQuotes = randomQuotes;
        this.jokeOfTheDay = jokeOfTheDay;
    }
}
