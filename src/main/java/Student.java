
import java.lang.*;
import java.util.*;

public class Student extends User {
    private int semester;
    private int am;
    private ArrayList<Course> courses ;
    private ArrayList<Integer> degree ;
    private Map<Course, Integer> Grades;

    public Student(String name, String surname, String username, String password, int semester, int am) {
        super(name, surname, username, password);
        this.semester = semester;
        this.am = am;
        this.courses= new ArrayList<Course>();
        this.degree= new ArrayList<Integer>();
        this.Grades=new HashMap<Course, Integer>();


    }


    public int getAm() {
        return am;
    }

    public int getSemester() {
        return semester;
    }


    public void setAm(int am) {
        this.am = am;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }


    public ArrayList<Course> getCourses() {
        return courses;
    }





    public Integer getDegree(Course course) {
        return this.Grades.get(course);
    }

    public void addDegree(Course course, Integer degree) {
            this.degree.add(this.courses.indexOf(course), degree);
            this.Grades.replace(course, degree);

    }

    public void addSCourse(Course course) {
        this.courses.add(course);
        this.degree.add(null);
        this.Grades.put(course,null);
    }


    @Override
    public String toString() {
        return "Student{" +
                "semester=" + semester +
                ", am=" + am +
                ", courses=" + courses +
                '}';
    }
}