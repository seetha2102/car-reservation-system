package oop_assignment;
// Class to manage the username

public class UserName {

    private static String userName; // Private static variable to hold the user's name
    
// Method to set the username
    public static void setUserName(String name) {
        userName = name;
    }
// Method to get the username
    public static String getUserName() {
        return userName;
    }

}
