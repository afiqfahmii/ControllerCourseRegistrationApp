import java.util.ArrayList;

public class LecturerView {

    public void lecturerOption() {
        System.out.println("1. Check student list");
        System.out.println("2. Check course information");
        System.out.println("3. Exit");
        System.out.print("Enter option: ");
    }

    public void checkCourseInfo(ArrayList<Lecturer> lList, int i) {
        System.out.println(lList.get(i).getCourse().toString());
        System.out.println();
    }

    public void printStudList(ArrayList<Lecturer> lList, int i) {
        for (int j = 0; j < lList.get(i)
                .getCourse()
                .getStudentNum(); j++) {
            System.out.println((j + 1)
                    + ") "
                    + lList.get(i).getCourse()
                            .getStudent(j)
                            .getName());
            System.out.println();
        }

    }
}
