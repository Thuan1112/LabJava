/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0068;

import java.util.Comparator;

/**
 *
 * @author asus
 */
public class Student implements Comparable<Student>{
    String name;
    String classes;
    float mark;

    public Student(String name, String classes, float mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student o) {
        return  this.name.compareTo(o.name);
    }
    
    
}
