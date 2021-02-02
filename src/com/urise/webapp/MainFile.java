package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFile {

    public static void main(String[] args) {
//        String filepath = ".\\.gitignore";
//
//        File file = new File(filepath);
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException e) {
//            throw new RuntimeException("Error", e);
//        }
//
//        try (FileInputStream fis = new FileInputStream(filepath)) {
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        getFiles("D:\\Java\\bjava\\src\\com\\urise");
    }

    private static void getFiles(String path) {
        File file = new File(path);
        File[] list = file.listFiles();
        if (list != null) {
            for (File data : list) {
                if (data.isDirectory()) {
                    System.out.println("Dir: " + data.getName());
                    getFiles(data.getAbsolutePath());
                }
                if (data.isFile()) {
                    System.out.println(data.getName());
                }
            }
        }
    }
}
