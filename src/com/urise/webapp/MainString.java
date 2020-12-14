package com.urise.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[] {"1","2","3","4","5"};
//        String result = "";
        StringBuilder result = new StringBuilder();
        for (String str: strArray) {
            result.append(str).append(", ");
        }
        System.out.println(result.toString());
//        String str1 = "abc";
//        String str2 = "abc";
//        System.out.println(str1.equals(str2));
    }
}
