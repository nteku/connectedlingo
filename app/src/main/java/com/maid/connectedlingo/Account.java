package com.maid.connectedlingo;

public class Account {

    private String username;
    private String emailAddress;
    private String password;


    public Account(String username, String emailAddress, String password){
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
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

}
