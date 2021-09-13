package j1.s.p0068;

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
public class CollectionSortProgram {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);
    private static final ArrayList<Student> li = new ArrayList<>();

    public static float checkInputNumber() {
        float num = 0;
        boolean valid;

        do {
            valid = true;
            try {
                num = Float.parseFloat(sc.nextLine());
                if (num < 0) {
                    System.out.println("Please input number > 0");
                    System.out.print("Input again: ");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must input digit");
                System.out.print("Input again: ");
                valid = false;
            }
        } while (!valid);
        return num;

    }

    public static String checkInputString() {
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

    public static boolean displayProgram() {
        String answer = null;
        System.out.println("====Collection sort program====");
        do {
            System.out.print("Enter name: ");
            sc = new Scanner(System.in);
            String name = checkInputString();
            System.out.print("Enter classes: ");
            String classes = checkInputString();
            System.out.print("Enter mark: ");
            float mark = checkInputNumber();
            li.add(new Student(name, classes, mark));
            System.out.println("Do you want to add new student?(Y/N)");
            answer = sc.next().toUpperCase();
            
            if (answer.equals("y")) {
                return true;
            } else if (answer.equals("n")) {
                return false;
            }
        } while (answer.equalsIgnoreCase("y"));
        return true;
    }

    public static void studentSort(){
        Collections.sort(li);
        for (int i = 0; i < li.size(); i++) {
            System.out.println("--------Student " + (i+1) + "--------");
            System.out.println("Name: " + li.get(i).getName());
            System.out.println("Classes: " + li.get(i).getClasses());
            System.out.println("Mark: " + li.get(i).getMark());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        displayProgram();
        studentSort();
    }

}
