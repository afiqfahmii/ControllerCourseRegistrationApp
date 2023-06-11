import java.util.ArrayList;

public class Student extends Person {

    private String email;
    private String matricNumber;
    private ArrayList<Course> cList = new ArrayList<>();;
    private int totalCredit;
    final int MAXCRED = 18;

    public Student(String name, int age, String address, String email, String matricNumber) {
        super(name, age, address);
        this.email = email;
        this.matricNumber = matricNumber;

    }

    public Student(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public void StudRegCourse(Course c) {
        if ((totalCredit + c.getCredits()) <= MAXCRED) {
            cList.add(c);
            totalCredit += c.getCredits();
        }

    }
     public Course getCourse(int i){
        return cList.get(i);
     }

    public void StudRemoveCourse(int i) {
        totalCredit -= cList.get(i).getCredits();
        cList.remove(i);
        
    }

    public void displayAllCourses() {
        for (int i = 0; i < cList.size(); i++) {
            System.out.println(cList.get(i).getCourseName() + " " + cList.get(i).getCourseCode() + " "
                    + cList.get(i).getCredits());
        }
    }
    

    @Override

    public String toString() {
        return "Name{" + name + ", MatricNumber =" + matricNumber + "}";
    }

}
