import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Course {
    private static ArrayList<Course> courses = new ArrayList<Course>();
    private int course_id;
    private String title;
    private int ects;
    private int semester;
    private ArrayList<Student> students = new ArrayList<Student>();


    public Course(String title, int ects, int semester, int course_id) {
        this.course_id = course_id;
        this.title = title;
        this.ects = ects;
        this.semester = semester;

    }


    public int getCourse_id() {
        return course_id;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public int getEcts() {
        return ects;
    }

    public String getTitle() {
        return title;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }


    public static Course getCourse(int id) {
        for (Course course : Course.courses) {
            if (id == course.getCourse_id()) {
                return course;
            }
        }
        return null;
    }

    public static void addCourse(Course course) {
        Course.courses.add(course);
    }


    public void addStudenttoCourse(Student student) {
        this.students.add(student);
    }


    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", points=" + ects +
                ", semester=" + semester +
                '}';
    }
}
