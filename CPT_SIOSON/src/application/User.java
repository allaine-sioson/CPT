package application;

import java.util.*;

import org.json.simple.*;

public class User {
    private String name, gender;
    private HashMap<String,Object> hashmap = new HashMap<String,Object>();
    private JSONObject user = new JSONObject(hashmap);

    public User(String name, String gender) {
        super();
        this.name = name;
        this.gender = gender;

        updateUser();
    }

    public void setName(String name) {
        this.name = name;
        updateUser();
    }

    public void setGender(String gender) {
        this.gender = gender;
        updateUser();
    }

    @SuppressWarnings("unchecked")
    public void updateUser() {
        user.put("Name", name);
        user.put("Gender", gender);

        Methods.updateData("data.json", this.user);
    }

    
}
