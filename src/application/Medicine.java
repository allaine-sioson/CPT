package application;

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
        newMedicine(name);
    }

    @Override
    public String toString() {
        return "\"" + name + " | " + doses + "x\"";
    }

    /**
     * Creates new Medicine file
     * @param medicine the Medicine to be added to the list of medicines
     */
    public static void newMedicine(String medicine) {
        String input = "package application.medicines;\r\n" + 
                        "import application.Medicine;\r\n" + 
                        "\r\n" + 
                        "public class " + medicine.replace(" ","") + " extends Medicine {\r\n" + 
                        "    public " + medicine.replace(" ","") + "(String brand, int doses) {\r\n" + 
                        "        super(brand + \": \" + \"" + medicine + "\", doses);\r\n" + 
                        "    }\r\n" + 
                        "}";

        Methods.writeFile(input, "medicines\\" + medicine.replace(" ","") + ".java");
    }
}