/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0051;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class CheckValidtion {

    static Scanner in = new Scanner(System.in);

    public int checkInputChoice(int min, int max) {
        int num = 0;
        boolean valid;

        do {
            valid = true;
            try {
                num = Integer.parseInt(in.nextLine());
                if (num < min || num > max) {
                    System.out.println("Invalid input!");
                    System.out.print("Input again: ");
                    valid = false;
                }
            } catch (Exception e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Input again: ");
                valid = false;
            }
        } while (!valid);
        return num;
    }

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("you must be input double or integer number");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputOperator() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equalsIgnoreCase("+") || result.equalsIgnoreCase("-")
                    || result.equalsIgnoreCase("*") || result.equalsIgnoreCase("/")
                    || result.equalsIgnoreCase("^") || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }
}
