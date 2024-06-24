package com.team2.controller.utill;

public class DBImagePath {

    public static String setUploadPath(String folderName) {

        String UPLOAD_DIRECTORY = "D:/SOFTWARE ENGINEERING/my programming/Java/Java EE/N_Library/N-Library/web/DBImages/" + folderName;

        return UPLOAD_DIRECTORY;
    }
}