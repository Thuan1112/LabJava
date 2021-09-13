/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author asus
 */
import java.util.ArrayList;
import java.util.Scanner;

public class checkValid {
    
    private final static Scanner sc = new Scanner(System.in);
    
    public int checkInteger(int minNum, int maxNum) {
        int num = 0;
        boolean valid ;
        
        do {
            valid = true;
            try {
                num = Integer.parseInt(sc.nextLine());
                if(num < minNum || num > maxNum){
                    System.out.println("Invalid input!");
                    System.out.print("Input again: ");
                    valid = false;
                }
            } catch (Exception e) {
                System.out.println("Please input number in rage [" + minNum + ", " + maxNum + "]");
                System.out.print("Input again: ");
                valid = false;
            }
        } while (!valid);
        return num;

    }
    
    public String checkInputString() {
        //loop until user input correct
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
    
//    public boolean checkIdExist(ArrayList<Student> li, String id, String name) {
//        for (Student student : li) {
//            if (id.equalsIgnoreCase(student.getID()) && !name.equalsIgnoreCase(student.getStudentName())) {
//                return false;
//            }
//        }
//        return true;
//    }
        
    public boolean checkStudentExist(ArrayList<Student> ls, String id, String studentName, String semester, String courseName) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getID())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }
}
