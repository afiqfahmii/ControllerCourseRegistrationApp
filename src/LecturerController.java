import java.util.ArrayList;
import java.util.Scanner;

public class LecturerController {
    LecturerView lecturerview = new LecturerView();

    public LecturerController() {
    }

    public void mainController(ArrayList<Lecturer> lList, Scanner s) {
        String tempStaffNum;
        int option = 4;

        App.printLogIn();
        System.out.print("Enter your staff number: ");
        tempStaffNum = s.nextLine();
        for (int i = 0; i < lList.size(); i++) {
            if (tempStaffNum.equals(lList.get(i).getStaffId())) {
                do {
                    option = lecturerOption(lList, i, s);
                    switch (option) {
                        case 1:
                            lecturerview.printStudList(lList, i);
                            break;
                        case 2:
                            lecturerview.checkCourseInfo(lList, i);
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
    }

    public int lecturerOption(ArrayList<Lecturer> lList, int i, Scanner s) {
        App.greeting(lList.get(i));
        lecturerview.lecturerOption();
        int option = s.nextInt();
        s.nextLine();
        System.out.println();
        return option;
    }

}