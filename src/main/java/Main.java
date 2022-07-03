import java.lang.*;

public class Main {


    public static void main(String[] args) {

        // calls setData who is responsible for data initialization
        setData();


        //terminal app


        // menu control variables
        boolean shutdown = true;
        boolean logout = true;


        login:
        while (shutdown) {
            TerminalMenus.mainMenu();

            int index = -1;
            boolean login = false;

            String username;
            String password;
            System.out.println("-------------Login page-------------\n");
            System.out.println("Input your Credensials\n\n");
            System.out.print("Username: ");
            username = UserInput.getString();
            System.out.print("Password: ");
            password = UserInput.getString();


            for (int i = 0; i < User.getSize(); i++) {
                if (User.getUsers().get(i).getUsername().equals(username) && User.getUsers().get(i).getPassword().equals(password)) {
                    index = i;
                    login = true;
                }
            }
            if (!login) {
                break login;
            }


            if (User.getUsers().get(index).getUsername().equals(username) && User.getUsers().get(index).getPassword().equals(password)) {


                if (User.getUsers().get(index) instanceof Student) {
                    do {
                        logout=true;
                        int choice;

                        do {
                            TerminalMenus.StudentMenu();
                            choice = UserInput.getInteger();
                        } while (choice < 1 || choice > 5);

                        switch (choice) {
                            case 1:
                                System.out.println("Student Info \n");
                                System.out.println(User.getUsers().get(index).toString()+"\n\n");
                                break;

                            case 2:
                                System.out.println("Student Courses  \n");
                                System.out.println(((Student) User.getUsers().get(index)).getCourses()+"\n\n");
                                break;
                            case 3:
                                System.out.println("Student Grades   \n");

                                for (Course course : ((Student) User.getUsers().get(index)).getCourses()) {
                                    String courseTitle = course.getTitle();
                                    Integer degree = ((Student) User.getUsers().get(index)).getDegree(course);
                                    System.out.println("\n\n");
                                    System.out.println(courseTitle + "   " + degree);
                                    System.out.println("\n\n");
                                }
                                break;
                            case 4:
                                logout = false;
                                break;
                            case 5:
                                logout = false;
                                shutdown = false;
                                break;
                            default:
                                break;
                        }
                    } while (logout);

                } else if (User.getUsers().get(index) instanceof Professor) {

                    do {
                        logout=true;
                        int choice;

                        do {
                            TerminalMenus.ProfessorMenu();
                            choice = UserInput.getInteger();
                        } while (choice < 1 || choice > 5);
                        switch (choice) {
                            case 1:
                                System.out.println("Professor Info \n");
                                System.out.println(User.getUsers().get(index).toString());
                                break;
                            case 2:
                                System.out.println("Professor Courses  \n");
                                System.out.println(((Professor) User.getUsers().get(index)).getCourses());
                                break;
                            case 3:
                                System.out.println("courses to be graded");
                                System.out.println(((Professor) User.getUsers().get(index)).getCourses());
                                System.out.println("select course id \n");
                                int id = UserInput.getInteger();
                                System.out.println("give am of a student ");
                                int am = UserInput.getInteger();
                                Student student = Student.getStudent(am);
                                System.out.println("Graded Student :"+student.toString());
                                Course course = Course.getCourse(id);
                                System.out.println("Previous grade on this course :");
                                System.out.println(student.getDegree(course));
                                System.out.println("give grade to course");
                                int degree = UserInput.getInteger();
                              //  student.addDegree(course, degree);
                                request degreeRequest = new request(am, course.getCourse_id(), degree);
                                request.addrequest(degreeRequest);
                                break;
                            case 4:
                                logout = false;
                                break;
                            case 5:
                                logout = false;
                                shutdown = false;
                                break;
                            default:
                                break;
                        }
                    } while (logout);

                } else if (User.getUsers().get(index) instanceof Secretery) {
                    do {
                        logout=true;
                        int choice;

                        do {
                            TerminalMenus.SecreteryMenu();
                            choice = UserInput.getInteger();
                        } while (choice < 1 || choice > 5);

                        switch (choice) {
                            case 1:
                                System.out.println("Secretery Info \n");
                                System.out.println(User.getUsers().get(index).toString());
                                break;
                            case 2:
                                System.out.println("Professor grade requests \n");
                                System.out.println(request.getSetdegreeRequests());
                                System.out.println("give request id ==>");
                                int request_id = UserInput.getInteger();
                                request req = request.getRequest(request_id);
                                Integer degree = req.getDegree();
                                int am = req.getAm();
                                Course course = Course.getCourse(req.getCourse_id());
                                System.out.println(course.toString());
                                Student student = User.getStudent(am);
                                System.out.println(student.toString());

                                ((Secretery) User.getUsers().get(index)).addDegreeToStudent( student,course,degree);
                                break;
                            case 4:
                                logout = false;
                                break;
                            case 5:
                                logout = false;
                                shutdown = false;
                                break;
                            default:
                                break;
                        }
                    } while (logout);
                }


            }

        }
    }


    public static void setData() {
        // make users

        //students
        Student s1 = new Student("Georgios", "Moisidis", "gmoisidis", "1234", 9, 174881);
        Student s2 = new Student("Periklis", "Gousios", "pgousios", "5678", 9, 175073);

        //professors
        Professor p1 = new Professor("Ignatios", "Deligiannis", "p", "1", 1);

        //Secretaries
        Secretery se1 = new Secretery("Maria", "Papadopoulou", "admin", "1", 1);


        // make courses

        Course c1 = new Course("mixaniki logismikou", 6, 5, 501);
        Course c2 = new Course("ADISE", 6, 5, 502);


        //adding users
        User.addUser(s1);
        User.addUser(s2);
        User.addUser(p1);
        User.addUser(se1);

        //add courses to university
        Course.addCourse(c1);
        Course.addCourse(c2);

        //add students to courses
        c1.addStudenttoCourse(s1);
        c1.addStudenttoCourse(s2);
        c2.addStudenttoCourse(s1);
        c2.addStudenttoCourse(s2);



        //add courses to students
        s1.addSCourse(c1);
        s1.addSCourse(c2);
        s2.addSCourse(c1);
        s2.addSCourse(c2);

        //add grades to student courses


        s1.addDegree(c1,3);
        s1.addDegree(c2,5);
        s2.addDegree(c1,6);
        s2.addDegree(c2,7);

        //add course to professor
        p1.addCourse(c1);
        p1.addCourse(c2);
    }

}
