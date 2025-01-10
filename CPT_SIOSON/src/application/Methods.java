package application;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Methods {
    public static String getStringData(String fileName, String dataNeeded) {
        // Parser for JSON files
        JSONParser jsonParser = new JSONParser();
        // blank data
        String data = "";
        // try catch to read in JSON file -> JSON Object
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\Abbey\\Desktop\\dev\\CPT_SIOSON\\src\\application\\" + fileName));
            // get the specific information
            data = (String) jsonObject.get(dataNeeded);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
      return data;
    }

    public static String[] getArrayData(String fileName, String dataNeeded) {
        // Parser for JSON files
        JSONParser jsonParser = new JSONParser();
        // blank data
        ArrayList<String> data = new ArrayList<>();
        // try catch to read in JSON file -> JSON Object
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\Abbey\\Desktop\\dev\\CPT_SIOSON\\src\\application\\" + fileName));
            JSONArray jsonArray = (JSONArray) jsonObject.get(dataNeeded);
            // get the specific information
            if (jsonArray.size() > 0) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    data.add((String) jsonArray.get(i));
                }   
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] results = new String[data.size()];
        results = data.toArray(results);

        return results;
    }


    /**
     * Updates the data within the JSON file
     * @param fileName The name of the file
     * @param obj the data to update
     */
    public static void updateData(String fileName, JSONObject obj) {
        // update information
        String data = obj.toJSONString();
        writeFile(data, fileName);
    }

    /**
     * Reads the file
     * @param fileName The name of the file
     * @return
     */
    public static String readFile(String fileName) {
        String data = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Abbey\\Desktop\\dev\\CPT_SIOSON\\src\\application\\" + fileName));
            data = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("File not Found.");
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Writes in the file
     * @param input the data to be written
     * @param fileName name of the file
     */
    public static void writeFile(String input, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Abbey\\Desktop\\dev\\CPT_SIOSON\\src\\application\\" + fileName));
            writer.write(input);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean checkForEmpty(String[] data) {
        for (String info: data) {
            if (info == null || info.isBlank()) {
                return true;
            }
        } 
        return false;
    }
}
