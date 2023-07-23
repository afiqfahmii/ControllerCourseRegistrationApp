import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    StudentView sv = new StudentView();

    public int studentOption(ArrayList<Student> sList, int i, Scanner s) {
        App.greeting(sList.get(i));
        sv.option();
        int option = s.nextInt();
        s.nextLine();
        System.out.println();
        return option;
    }

    public void addCourse(ArrayList<Course> cList, ArrayList<Student> sList, Scanner s, int i) {
        if (cList.isEmpty())
            System.out.println("No course");
        else {
            for (int j = 0; j < cList.size(); j++) {
                System.out.println((j + 1)
                        + ". "
                        + cList.get(j).getCourseName());
            }
            
            int coursePosition = s.nextInt() - 1;
            s.nextLine();
            System.out.println();
            sList.get(i).StudRegCourse(cList
                    .get(coursePosition));
            cList.get(coursePosition).addStudent(
                    sList.get(i));
        }
    }

    public void removeCourse(ArrayList<Student> sList, ArrayList<Course> cList, int i, Scanner s) {
        sList.get(i).displayAllCourses();
        if (sList.get(i).getcList().isEmpty()) {
        } else {
            int removeCoursePosition = s.nextInt()
                    - 1;
            s.nextLine();

            cList.get(cList.indexOf(sList.get(i)
                    .getCourse(removeCoursePosition)))
                    .removeStudent(sList
                            .get(i));
            sList.get(i).StudRemoveCourse(
                    removeCoursePosition);
        }
    }

    public void displayAllCourses(ArrayList<Student> sList, int i) {
        sList.get(i).displayAllCourses();
    }

}
