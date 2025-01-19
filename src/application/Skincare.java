package application;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Skincare datatype
 */

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
        this.routine.add(routineStep + ". " + step);
        this.routineStep++;
    }

    public ArrayList<Medicine> getMedication() {
        return this.medication;
    }

    public ArrayList<String> getConcerns() {
        return this.concerns;
    }

    public ArrayList<String> getRoutine() {
        return this.routine;
    }

    public void resetRoutine() {
        this.routine.clear();
        this.routineStep = 1;
    }

    public void resetConcerns() {
        this.concerns.clear();
    }

    public void resetMedication() {
        this.medication.clear();
    }

    public void getJSONSkincare() {
        String[] medJSON = Methods.getArrayData("data.json", "Skincare Medication");
        for (String med : medJSON) {
            String[] newMed = med.split("\\|");
            int doses = Integer.parseInt(newMed[1].replace("x", "").trim());

            this.medication.add(new Medicine(newMed[0].trim(), doses));
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
