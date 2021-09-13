package Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asus
 */
public class StudentList {

    ArrayList<Student> li = new ArrayList<Student>();
    checkValid check = new checkValid();
    int count;

    Scanner sc = new Scanner(System.in);

    public Student findID(String aID) {
        ArrayList<Student> ListId = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            if (aID.equalsIgnoreCase(li.get(i).getID())) {
                ListId.add(li.get(i));
                return li.get(i);
            }
        }
        return null;

    }

    public int findID(String id, String course) {
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).getID().equalsIgnoreCase(id) && li.get(i).getCourseName().equalsIgnoreCase(course)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateName() {
        String id = null;
        System.out.print("Enter Id for search: ");
        sc = new Scanner(System.in);
        id = check.checkInputString();
        Student pos = findID(id);
        
        if (pos == null) {
            System.out.println("Not Found!!!");
            return false;
        } else {
            System.out.println("");
            System.out.println("Update student name:");
            String Newname = check.checkInputString();
            pos.setStudentName(Newname);
            System.out.println("Update Successfull");
        }
        return true;
    }

    public boolean updateCourse() {
        String id = null;
        System.out.print("Enter Id for search: ");
        sc = new Scanner(System.in);
        id = check.checkInputString();
        Student pos = findID(id);
        
        if (pos == null) {
            System.out.println("Not Found!!!");
            return false;
        } else {
            System.out.println("");
            System.out.println("Update course name:");
            String NewCourse = check.checkInputString();
            pos.setCourseName(NewCourse);
            System.out.println("Update Successfull");
        }
        return true;
    }

    public void addNewCourse() {
    
        String id ;
        String newCourse ;
        String newSemester ;
        System.out.println("Enter id for search: ");
        sc = new Scanner(System.in);
        id = check.checkInputString();
        Student pos = findID(id);

        if (pos == null) {
            System.out.println("Not Found!!!");
            return;
        } else {
            System.out.println("");
            System.out.println("Add new course :");
            newCourse = check.checkInputString();
            System.out.println("Add new semester :");
            newSemester = check.checkInputString();

            if (newCourse.equalsIgnoreCase(pos.getCourseName()) && newSemester.equalsIgnoreCase(pos.getSemester())) {
                System.err.println("Have already course!!!");
                return;
            } else {
                li.add(new Student(id, pos.getStudentName(), newSemester, newCourse));
                System.out.println("Add Succesfull");
            }
        }
    }

    public void deleteCourse() {
        String id = null;
        String courseName = null;
        System.out.println("Enter id for search: ");
        sc = new Scanner(System.in);
        id = check.checkInputString();
        System.out.println("Enter course for delete: ");
        sc = new Scanner(System.in);
        courseName = check.checkInputString();
        int index = findID(id, courseName);
        
        if (index >= 0) {
            li.remove(index);
            System.out.println("Delete successful.");
        } else {
            System.out.println("Not Found");
        }
    }

    public boolean removeAll() {
        String id = null;
        System.out.println("Enter id for search: ");
        sc = new Scanner(System.in);
        id = check.checkInputString();
        Student pos = findID(id);

        if (pos != null) {
            li.remove(pos);
            System.out.println("Delete all success.");
        } else {
            System.out.println("Not Found!!!");
            return false;
        }
        return true;
    }

    public boolean CreateStudentList() {
        if (count == 20) {
            System.out.println("List is full");
            return false;
        } else {
            int choice = 0;
            String answer;
            String newID = null;
            String newCourse = null;
            String newSemester = null;
            String newStudentName = null;
            boolean ans = false;

            do {
                do {
                    System.out.print("Create new ID:");
                    sc = new Scanner(System.in);
                    newID = check.checkInputString();

                    System.out.print("Create new Student Name:");
                    sc = new Scanner(System.in);
                    newStudentName = check.checkInputString();
//                    if (newStudentName.matches("[a-zA-Z] +")) {
//                        newStudentName = newStudentName.toUpperCase();
//                        ans = true;
//                    } else {
//                        ans = false;
//                    }

                    for (Student s : li) {
                        if (newID.equalsIgnoreCase(s.getID())) {
                            System.err.println("Id has exist student. Pleas re-input.");
                            ans = true;
                        } else {
                            ans = false;
                        }
                    }
//                    if (!check.checkIdExist(li, newID, newStudentName)) {
//                        System.err.println("Id has exist student. Pleas re-input.");
//                        ans = true;
//                    } else {
//                        ans = false;
//                    }
                } while (ans == true);

               
                    System.out.println("1 - Java");
                    System.out.println("2 - .Net");
                    System.out.println("3 - C/C++");
                    System.out.print("Choice course:");
                    choice = check.checkInteger(1, 3);
                    switch (choice) {
                        case 1:
                            newCourse = "Java";
                            break;
                        case 2:
                            newCourse = ".Net";
                            break;
                        case 3:
                            newCourse = "C/C++";
                            break;
                    }


                    System.out.println("1 - Fall");
                    System.out.println("2 - Spring");
                    System.out.println("3 - Summer");
                    System.out.print("Choice semester:");
                    choice = check.checkInteger(1, 3);
                    switch (choice) {
                        case 1:
                            newSemester = "Fall";
                            break;
                        case 2:
                            newSemester = "Spring";
                            break;
                        case 3:
                            newSemester = "Summer";
                            break;
                    }

                if (check.checkStudentExist(li, newID, newStudentName, newSemester, newCourse)) {
                    li.add(new Student(newID, newStudentName, newSemester, newCourse));
                    System.out.println("New person have been added");
                }

                System.out.println("Do you want to add new person?(Y/N):");
                answer = sc.next().toUpperCase();

                if (answer.equals("y")) {
                    return true;
                } else if (answer.equals("n")) {
                    return false;
                }

            } while (answer.equalsIgnoreCase("y"));
        }
        return true;
    }

    public String findandsortStudent() {
        String StudentForFind = null;
        
        System.out.println("Enter student name for search:");
        StudentForFind = check.checkInputString();
        
        Collections.sort(li, Student.byName);
        for (Student student : li) {
            if(student.getStudentName().contains(StudentForFind)){
                System.out.println(student.toString());
            }
            else{
                return StudentForFind;
            }
        }
        return null;
    
    }

//    public void DisplayAll() {
//        System.out.println("LIST OF STUDENT:");
//        for (Student sv : li) {
//            System.out.println(sv.toString());
//        }
//    }

    public void report() {
        Hashtable<String, Integer> rep = new Hashtable<>();

        Vector<String> course = new Vector<>();

        course.add("Java");
        course.add(".Net");
        course.add("C/C++");

        for (int i = 0; i < course.size(); i++) {
            for (int j = 0; j < li.size(); j++) {
                if (li.get(j).getCourseName().equalsIgnoreCase(course.get(i))) {
                    if (!rep.containsKey(li.get(j).getStudentName())) {
                        rep.put(li.get(j).getStudentName(), 1);
                    } 
                    else {
                        rep.replace(li.get(j).getStudentName(), rep.get(li.get(j).getStudentName()) + 1);
                    }
                }
            }

            Iterator it = rep.keySet().iterator();
            while (it.hasNext()) {
                String name = (String) it.next();
                int values = rep.get(name);
                System.out.println(name + " | " + course.get(i) + " | " + values);
            }

            rep.clear();
        }
    }
}
