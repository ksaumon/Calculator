package org.semen.test2;

public class StringUtils {
    public static void printInQuotes(String text) {
        if (text.length() > 40) {
            System.out.println(text.substring(0, 40) + "...");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
}
