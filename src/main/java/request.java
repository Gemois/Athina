import java.util.ArrayList;

public class request {
    public static ArrayList<request> setdegreeRequests = new ArrayList<request>();

    private final int id;
    private int am;
    private int course_id;
    private Integer degree;


    public request(int am, int course_id, Integer degree) {
        this.id = (int) (Math.random() ) +am;
        this.am = am;
        this.course_id = course_id;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }


    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public static boolean addrequest(request request) {
        request.setdegreeRequests.add(request);
        return true;
    }

    public static int getrequestSize() {
        return request.setdegreeRequests.size();
    }

    public static ArrayList<request> getSetdegreeRequests() {
        return setdegreeRequests;
    }

    public static request getRequest(int id) {
        for (request request : request.getSetdegreeRequests()) {
            if (id == request.getId()) {
                return request;
            }
        }
        return null;
    }


    public int getAm() {
        return am;
    }


    public Integer getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "request{" +
                "id=" + id +
                ", am='" + am + '\'' +
                ", course_id=" + course_id +
                ", degree=" + degree +
                '}';
    }
}
