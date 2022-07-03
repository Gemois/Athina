import java.util.ArrayList;
import java.lang.*;

public class Professor extends User {
    private int prof_id;
    private ArrayList<Course> pcourses = new ArrayList<Course>();


    public Professor(String name, String surname, String username, String password, int prof_id) {
        super(name, surname, username, password);
        this.prof_id = prof_id;
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }


    public ArrayList<Course> getCourses() {
        return pcourses;
    }

    public void setdegree(Student student, Course course) {
        student.getCourses();


    }


    public void addCourse(Course course) {
        this.pcourses.add(course);
    }


    @Override
    public String toString() {
        return "Professor{" +
                "prof_id=" + prof_id +
                ", courses=" + pcourses +
                '}';
    }
}
