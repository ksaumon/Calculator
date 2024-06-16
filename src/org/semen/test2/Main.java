package org.semen.test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(System.in);
            String exp = scn.nextLine();
            Calculator calculator = new Calculator();
            String result = calculator.calculate(exp);
            StringUtils.printInQuotes(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
