package Student;

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
public class Menu {

    public static void main(String[] args) {
        StudentList s = new StudentList();
        checkValid check = new checkValid();
        Scanner sc = new Scanner(System.in);
        int choice;
        int choose;

        do {
            System.out.println("-----------------------");
            System.out.println("1. Create student");
            System.out.println("2. Find/sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println("-----------------------");
            System.out.print("Input a menu choice:");
            choice = check.checkInteger(1, 5);

            switch (choice) {
                case 1:
                    s.CreateStudentList();
                    break;
                case 2:
                    s.findandsortStudent();                    
                    break;

                case 3:

                    do {
                        System.out.println("-------------------");
                        System.out.println("1- Update          ");
                        System.out.println("2- Remove          ");
                        System.out.println("3- Exit            ");
                        System.out.println("-------------------");
                        System.out.print("Menu choice: ");
                        choice = check.checkInteger(1, 3);

                        switch (choice) {
                            case 1:
                                do {
                                    System.out.println("--------------------------------");
                                    System.out.println("1- Update name                  ");
                                    System.out.println("2- Add new course               ");
                                    System.out.println("3- Remove a course              ");
                                    System.out.println("4- Update a course              ");
                                    System.out.println("5- Go back to meu Update/Delete ");
                                    System.out.println("--------------------------------");
                                    System.out.print("Menu choice: ");
                                    choose = check.checkInteger(1, 5);
                                    switch (choose) {
                                        case 1:
                                            s.updateName();
                                            break;
                                        case 2:
                                            s.addNewCourse();
                                            break;
                                        case 3:
                                            s.deleteCourse();
                                            break;
                                        case 4:
                                            s.updateCourse();
                                            break;
                                    }
                                } while (choose > 0 && choose < 5);
                                break;
                            case 2:
                                s.removeAll();
                                break;
                        }

                    } while (choice > 0 && choice < 3);
                    break;

                case 4:
                    s.report();
                    break;

            }
        } while (choice > 0 && choice < 5);
    }
}
