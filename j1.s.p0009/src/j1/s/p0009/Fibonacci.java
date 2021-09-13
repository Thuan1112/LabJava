package j1.s.p0009;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class Fibonacci {
    static Scanner sc = new Scanner(System.in);
    public static int checkInputNumber() {
        int num = 0;
        boolean valid;
        do {
            valid = true;
            try {
                num = Integer.parseInt(sc.nextLine().trim());
                if (num <= 0) {
                    System.out.println("Invalid input!");
                    System.out.print("Input again: ");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
                valid = false;
            }
        } while (!valid);
        return num;
    }
    
    public static void main(String args[]) {
        int a = 0, b = 0, c = 1; 
        System.out.print("Enter value of n:");
        int n = checkInputNumber();
        System.out.println("The "+n+" sequence fibonacci:");
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a + " ");
        }
    }
}
