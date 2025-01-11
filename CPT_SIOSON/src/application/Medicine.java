package application;

public class Medicine {
    private String name;
    private int doses;

    public Medicine(String name, int doses) {
        this.name = name;
        this.doses = doses;
    }

    @Override
    public String toString() {
        return name + " | " + doses;
    }

    /**
     * Creates new Medicine file
     * @param medicine the Medicine to be added to the list of medicines
     */
    public static void newMedicine(String medicine) {
        String input = "package application.medicines;\r\n" + 
                        "import application.Medicine;\r\n" + 
                        "\r\n" + 
                        "public class " + medicine.strip() + " extends Medicine {\r\n" + 
                        "    public " + medicine.strip() + "(String brand, int doses) {\r\n" + 
                        "        super(brand + \": \" + \"" + medicine + "\", doses);\r\n" + 
                        "    }\r\n" + 
                        "}";

        Methods.writeFile(input, "medicines\\" + medicine.strip() + ".java");
    }
}