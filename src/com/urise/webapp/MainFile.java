package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {

    public static void main(String[] args) {
        String filepath = ".\\.gitignore";

        File file = new File(filepath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        try (FileInputStream fis = new FileInputStream(filepath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getFiles("D:\\Java\\bjava\\src\\com\\urise", "");
    }

    private static void getFiles(String path, String offset) {
        File file = new File(path);
        File[] list = file.listFiles();
        if (list != null) {
            for (File data : list) {
                if (data.isDirectory()) {
                    System.out.println(offset + "Dir: " + data.getName());
                    getFiles(data.getAbsolutePath(), offset + "  ");
                } else if (data.isFile()) {
                    System.out.println(offset + "File: " + data.getName());
                }
            }
        }
    }
}
