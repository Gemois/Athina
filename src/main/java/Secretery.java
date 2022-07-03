import java.lang.*;

public class Secretery extends User {
    private int Secr_id;


    public Secretery(String name, String surname, String username, String password, int Secr_id) {
        super(name, surname, username, password);
        this.Secr_id = Secr_id;
    }


    public int getSecr_id() {
        return Secr_id;
    }

    public void setSecr_id(int secr_id) {
        Secr_id = secr_id;
    }


    public  void addDegreeToStudent(Student student, Course course, Integer degree) {
        student.addDegree(course, degree);
    }


    @Override
    public String toString() {
        return "Secretery{" +
                "Secr_id=" + Secr_id +
                '}';
    }
}
