package application;

import java.util.ArrayList;

public class Skincare  {
    private ArrayList<String> concerns, routine;
    private ArrayList<Medicine> medication;

    public Skincare() {
        this.concerns = new ArrayList<String>();
        this.routine = new ArrayList<String>();
        this.medication = new ArrayList<Medicine>();
    }

    public void addMedication(Medicine med) {
        this.medication.add(med);
    }
}
