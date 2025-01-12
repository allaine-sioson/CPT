package application;

import java.util.*;

public class Skincare  {
    private ArrayList<String> concerns, routine;
    private ArrayList<Medicine> medication;
    private int routineStep;

    public Skincare() {
        this.concerns = new ArrayList<String>();
        this.routine = new ArrayList<String>();
        this.medication = new ArrayList<Medicine>();
        this.routineStep = 1;

        getJSONSkincare();
    }

    public void addMedication(Medicine med) {
        this.medication.add(med);
    }

    public void addConcern(String concern) {
        this.concerns.add(concern);
    }

    public void addStepToRoutine(String step) {
        this.concerns.add(routineStep + ". " + step);
        routineStep++;
    }

    public ArrayList<Medicine> getMedication() {
        return medication;
    }

    public ArrayList<String> getConcerns() {
        return concerns;
    }

    public ArrayList<String> getRoutine() {
        return routine;
    }

    public void getJSONSkincare() {
        String[] medJSON = Methods.getArrayData("data.json", "Skincare Medication");
        for (String med : medJSON) {
            String[] newMed = med.split(" | ");
            this.medication.add(new Medicine(newMed[0], Integer.valueOf(newMed[1])));
        }

        String[] concernsJSON = Methods.getArrayData("data.json","Skin Concerns");
        for (String concern : concernsJSON) {
            this.concerns.add(concern);
        }

        String[] routineJSON = Methods.getArrayData("data.json", "Skincare Routine");
        for (String step : routineJSON) {
            this.routine.add(step);
            routineStep++;
        }
    }
    
}
