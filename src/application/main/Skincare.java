package application.main;
import java.util.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Skincare datatype
 */

public class Skincare  {
    private ArrayList<String> concerns, routine;
    private ArrayList<Medicine> medication;
    private int routineStep;

    /**
     * constructor for the skincare class
     */
    public Skincare() {
        this.concerns = new ArrayList<String>();
        this.routine = new ArrayList<String>();
        this.medication = new ArrayList<Medicine>();
        this.routineStep = 1;

        getJSONSkincare();
    }

    /**
     * adds a new medication to the list of medications
     * @param med the new medicine to be added
     */
    public void addMedication(Medicine med) {
        this.medication.add(med);
    }

    /**
     * adds a new concern to the list of skin concerns
     * @param concern the new concern to be added
     */
    public void addConcern(String concern) {
        this.concerns.add(concern);
    }

    /**
     * adds a new step to the skincare routine
     * @param step the new step to be added
     */
    public void addStepToRoutine(String step) {
        this.routine.add(routineStep + ". " + step);
        this.routineStep++;
    }

    /**
     * gets the user's skin medication list
     * @return the skin medication of the user
     */
    public ArrayList<Medicine> getMedication() {
        return this.medication;
    }

    /**
     * gets the user's skin concerns list
     * @return the skin concerns of the user
     */
    public ArrayList<String> getConcerns() {
        return this.concerns;
    }

    /**
     * gets the user's skincare routine
     * @return the skincare routine of the user
     */
    public ArrayList<String> getRoutine() {
        return this.routine;
    }

    /**
     * resets the user's skincare routine
     */
    public void resetRoutine() {
        this.routine.clear();
        this.routineStep = 1;
    }

    /**
     * resets the user's skin concerns
     */
    public void resetConcerns() {
        this.concerns.clear();
    }

    /**
     * resets the user's skin medication
     */
    public void resetMedication() {
        this.medication.clear();
    }

    /**
     * gets the user's skincare information from the data.json file
     */
    public void getJSONSkincare() {
        String[] medJSON = Methods.getArrayData("main\\data.json", "Skincare Medication");
        for (String med : medJSON) {
            String[] newMed = med.split("\\|");
            int doses = Integer.parseInt(newMed[1].replace("x", "").trim());

            this.medication.add(new Medicine(newMed[0].trim(), doses));
        }

        String[] concernsJSON = Methods.getArrayData("main\\data.json","Skin Concerns");
        for (String concern : concernsJSON) {
            this.concerns.add(concern);
        }

        String[] routineJSON = Methods.getArrayData("main\\data.json", "Skincare Routine");
        for (String step : routineJSON) {
            this.routine.add(step);
            routineStep++;
        }
    }
    
}
