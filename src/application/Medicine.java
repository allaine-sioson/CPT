package application;

import java.util.Scanner;

import application.medicines.*;

/**
 * author: Allaine
 * date: 15/01/2025
 * Medicine datatype
 */

public class Medicine {
    private String name;
    private int doses;

    public Medicine(String name, int doses) {
        this.name = name;
        this.doses = doses;
    }

    public static Medicine newMedicine(Scanner input) {
        String medName = "";
        String typeOfMed = "";
        int doses = 0;
    
        do {
            System.out.print("What is the name of your medication?: ");
            medName = input.nextLine();
        } while (medName.equals(""));

        System.out.println("\n· · ─ · · ─ · ·\n");

        do {
            System.out.print("How many doses?: ");
            doses = input.nextInt();
        } while (doses <= 0);

        System.out.println("\n· · ─ · · ─ · ·\n");
        input.nextLine();

        do {
            System.out.print("Is it a cream, pill, serum or syrup?: ");
            typeOfMed = input.nextLine();
        } while (!typeOfMed.equalsIgnoreCase("cream") && !typeOfMed.equalsIgnoreCase("pill") && !typeOfMed.equalsIgnoreCase("serum") && !typeOfMed.equalsIgnoreCase("syrup"));

        switch (typeOfMed.toLowerCase()) {
            case "cream":
                return new Cream(medName, doses);
            case "pill":
                return new Pill(medName, doses);
            case "serum":
                return new Serum(medName, doses);
            case "syrup":
                return new Syrup(medName, doses);
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "\"" + name + " | " + doses + "x\"";
    }
}