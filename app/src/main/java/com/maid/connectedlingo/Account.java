package com.maid.connectedlingo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Account implements Serializable {

    private String username;
    private String emailAddress;
    private String password;
    private ArrayList<HashMap<String,String>> savedTranslations;

    public Account(String username, String emailAddress, String password){
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.savedTranslations = null;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addTranslation(HashMap <String,String> translation){

        if (savedTranslations == null)
        {
            savedTranslations = new ArrayList<>();
        }

        savedTranslations.add(translation);
    }

    public ArrayList<HashMap<String,String>> getSavedTranslations()
    {
        return savedTranslations;
    }

}
