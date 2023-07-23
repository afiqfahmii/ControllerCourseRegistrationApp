public class Course {

    private String courseName;
    private String courseCode;
    private int credits;
    private Student sList[] = new Student[30];
    private int studNum = 0;
    private final int MAX = 30;

    public Course(String courseName, String courseCode, int credits) {
        // course num 0
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Student getStudent(int i) {
        return sList[i];
    }

    public void addStudent(Student s) {

        if (studNum < MAX) {
            sList[studNum] = s;
            studNum++;
        } else {
            System.out.println("Full");
        }

    }

    public void removeStudent(Student s) {
        int indexToRemove = -1;

        // Find the index of the student to be removed
        for (int i = 0; i < sList.length; i++) {
            if (sList[i] == s) {
                indexToRemove = i;
                break;
            }
        }
    
        // If the student was found, remove them and shift the elements
        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < sList.length - 1; i++) {
                sList[i] = sList[i + 1];
            }
            sList[sList.length - 1] = null;
        }

        studNum--;
    }

    public int getStudentNum() {
        return studNum;
    }

    @Override
    public String toString() {
        
        return "Course{" + "Course Name =" + courseName + ", Course Code=" + courseCode + ", Number Of Credit=" + credits + "}";
    }

    public void printStudent(){
        System.out.println("STUDENTS:");
        for(int i = 0 ; i < studNum ; i++){
            System.out.println(sList[i].toString());
            System.out.println();
        }
    }

    public int getCapacity(){
        return MAX;
    }

}
