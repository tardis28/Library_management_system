package com.example.my_app;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {
    private ArrayList<user> usertable = new ArrayList<>();
    private HashMap<String, String> wordstore = new HashMap<String, String>();

    public DB() {
        usertable.add(new user(1, 23, "Manu"));
        usertable.add(new user(2, 22, "Trisa"));
        wordstore.put("sachin", "kya mast khelta tha");
        wordstore.put("manu", "bohot achha ladka hai");
    }

    public String search(String word) {
        return wordstore.get(word);
    }

    public user getAUser(int id) {
        for (user user : usertable) {
            if (user.getId() == id) return user;
        }
        System.out.println("user nahi mila");
        return null;
    }

    public List<user> getAllUsers() {
        return usertable;
    }

    public boolean addUser(user userdata) {
        usertable.add(userdata);
        return true;
    }

    public boolean deleteUser(int id) {
        for (user user : usertable) {
            if (user.getId() == id) {
                usertable.remove(user);
                return true;
            }
        }
        System.out.println("user nahi mila");
        return false;
    }

}
