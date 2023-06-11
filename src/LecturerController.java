import java.util.ArrayList;
import java.util.Scanner;

public class LecturerController {

    public void mainController(ArrayList<Lecturer> lList, Scanner s) {
        String tempStaffNum;
        int index = -1;
        int option = 4;

        // Lecturer can
        /*
         * 1. Check student list
         * 2. Update profile
         */

        App.printLogIn();
        System.out.print("Enter your staff number: ");
        tempStaffNum = s.nextLine();
        for (int i = 0; i < lList.size(); i++) {
            if (tempStaffNum.equals(lList.get(i).getStaffId())) {
                do {
                    option = lecturerOption(lList, i, s);
                    switch (option) {
                        case 1:
                            printStudList(lList, i);
                            break;
                        case 2:
                            checkCourseInfo(lList, i);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("WRONG INPUT ");
                            break;
                    }

                } while (option != 3);
            }
        }
        if (index == -1)
            System.out.println("SALAH BODOH");
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

    public void checkCourseInfo(ArrayList<Lecturer> lList, int i) {
        System.out.println(lList.get(i).getCourse().toString());
        System.out.println();
    }

    public int lecturerOption(ArrayList<Lecturer> lList, int i, Scanner s) {
        App.greeting(lList.get(i));
        System.out.println("1. Check student list");
        System.out.println("2. Check course information");
        System.out.println("3. Exit");
        System.out.print("Enter option: ");
        int option = s.nextInt();
        s.nextLine();
        System.out.println();
        return option;
    }


}