package com.team2.controller.utill;

import java.util.Random;

public class RamdomBookIdGenarator {

    public static String generateBookId(String bookCategory, int categoryId) {
        Random random = new Random();
        // Generate a random 5-digit number
        int randomNumber = 10000 + random.nextInt(90000);

        // Format the categoryId to two digits
        String formattedCategoryId = String.format("%02d", categoryId);
        
        String categoryShort = getShortForm(bookCategory);

        // Combine bookCategory, formattedCategoryId, and randomNumber to form the bookId
        String bookId = categoryShort + formattedCategoryId + randomNumber;

        return bookId;
    }

    public static String getShortForm(String word) {
        // Check if the word is less than 3 letters
        if (word.length() < 3) {
            throw new IllegalArgumentException("Word must be at least 3 characters long");
        }

        // Get the first, middle, and last letters
        char firstLetter = word.charAt(0);
        char middleLetter = word.charAt(word.length() / 2);
        char lastLetter = word.charAt(word.length() - 1);

        // Concatenate and convert to uppercase
        String shortForm = "" + firstLetter + middleLetter + lastLetter;
        return shortForm.toUpperCase();
    }

}
