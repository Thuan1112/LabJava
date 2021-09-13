package Student;

import java.util.Comparator;

public class Student implements Comparator<Student> {

    String ID, studentName, semester, courseName;

    public Student(String ID, String studentName, String semester, String courseName) {
        this.ID = ID;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" + "ID=" + ID + ", studentName=" + studentName + ", semester=" + semester + ", courseName=" + courseName + '}';
    }

//    @Override
//    public int compareTo(Student o) {
//        return this.getStudentName().compareTo(((Student) o).getStudentName());
//    }
    public static Comparator<Student> byName = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getStudentName().compareTo(o2.getStudentName()) > 0) {
                return 1;
            } else if (o1.getStudentName().compareTo(o2.getStudentName()) < 0) {
                return -1;
            }
            return 0;
        }
    };

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getStudentName().compareTo(o2.getStudentName()) > 0) {
            return 1;
        } else if (o1.getStudentName().compareTo(o2.getStudentName()) < 0) {
            return -1;
        }
        return 0;
    }

}
