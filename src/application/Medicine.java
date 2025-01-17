package application;

import java.lang.reflect.Constructor;

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

    public static Medicine getSpecificMedicine(String name, String brand, int doses) {
        try {
            Class<?> clazz = Class.forName("application.medicines." + name.replace(" ",""));
            Constructor<?> ctor = clazz.getConstructor(String.class, int.class);
            return (Medicine) ctor.newInstance(brand, doses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates new Medicine file
     * @param medicine the Medicine to be added to the list of medicines
     */
    public static void newMedicine(String medicine) {
        String medName = medicine.replace(" ","");
        if (medName.contains(":")) {
            String[] splitName = medName.split("\\:");
            medName = splitName[1];
        }
        String input = "package application.medicines;\r\n" + 
                        "import application.Medicine;\r\n" + 
                        "\r\n" + 
                        "public class " + medName + " extends Medicine {\r\n" + 
                        "    public " + medName + "(String brand, int doses) {\r\n" + 
                        "        super(brand + \": \" + \"" + medicine + "\", doses);\r\n" + 
                        "    }\r\n" + 
                        "}";

        Methods.writeFile(input, "medicines\\" + medName + ".java");
    }

    @Override
    public String toString() {
        return "\"" + name + " | " + doses + "x\"";
    }
}