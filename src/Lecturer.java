public class Lecturer extends Person {

    private String department;
    private String LecturerId;
    private Course course;

    public Lecturer() {
    }

    public Lecturer(String name, int age, String address, String department, String LecturerId, Course course) {
        super(name, age, address);
        this.department = department;
        this.LecturerId = LecturerId;
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public String getLecturerId() {
        return LecturerId;
    }

    public void setLecturerId(String lecturerId) {
        LecturerId = lecturerId;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStaffId() {
        return LecturerId;
    }

    public void setStaffId(String staffId) {
        this.LecturerId = staffId;
    }

    public Course getCourse() {
        return course;
    }

    @Override

    public String toString() {
        if (getCourse() == null)
            return "Not assigned yet";
        else
            return "Course{" + ", department=" + department + ", staffId=" + LecturerId + "}";
    }
}
