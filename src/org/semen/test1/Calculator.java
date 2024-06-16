package org.semen.test1;

import java.util.Scanner;

class Calculator {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        try {
            System.out.println(Main.calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}