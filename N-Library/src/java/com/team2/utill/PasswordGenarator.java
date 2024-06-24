package com.team2.utill;

public class PasswordGenarator {

    public static String generatePassword(String firstName, String nic) {
        String nicDigits = null;
        if (nic.length() >= 3) {
            // Extract the last 3 characters
             nicDigits = nic.substring(nic.length() - 3);
        } else {
            System.out.println("Input string is too short.");
        }

        // Generate and return password
        return firstName + nicDigits;
    }

}
