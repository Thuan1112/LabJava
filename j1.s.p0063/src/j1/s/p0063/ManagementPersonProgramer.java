package j1.s.p0063;

import java.util.ArrayList;
import java.util.Collections;
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
public class ManagementPersonProgramer {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Person> li = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static String checkString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static double checkInputNumber() {
        double num = 0;
        boolean valid;

        do {
            valid = true;
            try {
                num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    System.err.println("Salary is greater than zero");
                    System.out.print("Input again: ");
                    valid = false;
                }
            } catch (Exception e) {
                System.err.println("You must input digit");
                System.out.print("Input again: ");
                valid = false;
            }
        } while (!valid);
        return num;

    }

    public static boolean displayPersonProgramer() {
        String ans = null;
        System.out.println("====Management Person Programer====");
        do {
            System.out.println("Input information of person:");
            System.out.println("Please input name :");
            String name = checkString();
            System.out.println("Please input address :");
            String address = checkString();
            System.out.println("Please input salary :");
            double salary = checkInputNumber();
            li.add(new Person(name, address, salary));

            System.out.println("Do you want to add new person(Y/N)?");
            ans = sc.nextLine().toUpperCase();
            if (ans.equals("y")) {
                return false;
            }
            if (ans.equals("n")) {
                return true;
            }
        } while (ans.equalsIgnoreCase("y"));
        return true;
    }

    public static void sortPersonProgramer() {
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            System.out.println("Information of person you have entered:");
            System.out.println("Name: " + li.get(i).getName());
            System.out.println("Classes: " + li.get(i).getAddress());
            System.out.println("Mark: " + li.get(i).getSalary());
        }
    }

    public static void main(String[] args) {
        displayPersonProgramer();
        sortPersonProgramer();
    }

}
