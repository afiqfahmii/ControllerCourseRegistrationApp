import java.util.Scanner;
import java.util.ArrayList;

public class App {
        public static void main(String[] args) throws Exception {
                Scanner s = new Scanner(System.in);
                int choice = 0;

                ArrayList<Course> cList = new ArrayList<Course>();
                Course c1 = new Course("Object Oriented Programming", "SECJ2154", 3);
                Course c2 = new Course("Operating System", "SECR2043", 3);
                Course c3 = new Course("Human Computer Interaction", "SECJ2200", 4);
                Course c4 = new Course("Calculus for Civil", "SEWH2423", 2);
                cList.add(c1);
                cList.add(c2);
                cList.add(c3);
                cList.add(c4);

                ArrayList<Student> sList = new ArrayList<>();
                Student s1 = new Student("Muhammad Taufiq bin Jurimi", 21, "No 7, Jalan Makmur 52 81300 Skudai",
                                "taufiq02@graduate.utm.my", "A21EC0095");
                Student s2 = new Student("Afiq Fahmi Bin Roslan", 23, "Ipoh,Kuantan", "afqifahmi9858@gmail.com",
                                "A21EC0153");
                Student s3 = new Student("Muhammad Najwan Hazim Bin Khairi", 24,
                                "Putrajaya, Wilayah Persekutuan Putrajaya",
                                "najwanhazim@gmail.com", "A21EC0087");
                Student s4 = new Student("Zehan Anep Bin Zeni", 22, "Alam Damai, Kuala Lumpur", "azhanam@yahoo.com",
                                "A21EC0017");
                Student s5 = new Student("Amir Abu Bin Bakar", 21, "Skudai, Johor", "abubakar@gmai.com", "A20EC0010");
                sList.add(s1);
                sList.add(s2);
                sList.add(s3);
                sList.add(s4);
                sList.add(s5);
                s1.StudRegCourse(c1);
                c1.addStudent(s1);
                s2.StudRegCourse(c2);
                c2.addStudent(s2);
                s3.StudRegCourse(c3);
                c3.addStudent(s3);
                s4.StudRegCourse(c4);
                c4.addStudent(s4);

                ArrayList<Lecturer> lList = new ArrayList<Lecturer>();
                Lecturer l1 = new Lecturer("Dr Hamizan bin Kamal", 44, "258, KTDI UTM", "Faculty of Computing", "12345",
                                c1);
                Lecturer l2 = new Lecturer("Dr. Amarul Akmal", 44, "Kulai", "Faculty of Computing", "11111", c2);
                Lecturer l3 = new Lecturer("Dr. Waffi", 56, "Kulai", "Faculty of Computing", "22222", c3);
                Lecturer l4 = new Lecturer("Prof Madya Dr Kamilah binti Havisan Ahmad Mustafa", 24,
                                "No 5, Jalan Mutiara Universiti, 81300, Skudai", "Faculty of Civil Engineering",
                                "66666", c4);
                lList.add(l1);
                lList.add(l2);
                lList.add(l3);
                lList.add(l4);

                ArrayList<AcademicStaff> acList = new ArrayList<>();
                AcademicStaff as1 = new AcademicStaff("Siti Haziqah", 32, "No 5, Jalan Kelalang 3", "20490",
                                "UTMDigital - Faculty Of Computing");
                AcademicStaff as2 = new AcademicStaff("Tuan Amarul", 75, "Putrajaya,Kuala Lumpur, Seremban", "44444",
                                "UTM Digital - Faculty Of Computing");

                acList.add(as1);
                acList.add(as2);

                do {
                        printMenu();
                        choice = s.nextInt();
                        s.nextLine();
                        switch (choice) {
                                case 1: {
                                        String tempStaffNum;
                                        int index = -1;
                                        int option = 4;

                                        // Lecturer can
                                        /*
                                         * 1. Check student list
                                         * 2. Update profile
                                         */
                                        printLogIn();
                                        System.out.print("Enter your staff number: ");
                                        tempStaffNum = s.nextLine();
                                        for (int i = 0; i < lList.size(); i++) {
                                                if (tempStaffNum.equals(lList.get(i).getStaffId())) {

                                                        do {
                                                                greeting(lList.get(i));
                                                                System.out.println("1. Check student list");
                                                                System.out.println("2. Check course information");
                                                                System.out.println("3. Exit");
                                                                System.out.print("Enter option: ");
                                                                option = s.nextInt();
                                                                s.nextLine();
                                                                System.out.println();
                                                                switch (option) {
                                                                        case 1:
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

                                                                                break;
                                                                        case 2:
                                                                                System.out.println(lList.get(i)
                                                                                                .getCourse()
                                                                                                .toString());
                                                                                System.out.println();
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
                                        break;
                                }
                                case 2: {
                                        String tempMatricNumber;
                                        int index = -1;
                                        int option = 0;
                                        boolean logged = false;

                                        printLogIn();
                                        System.out.print("Enter your matric number: ");
                                        // student
                                        /*
                                         * 1. Add course
                                         * 2. Drop course
                                         * 3. Tengok detail course dia
                                         * 4. Update profile
                                         */
                                        tempMatricNumber = s.nextLine();
                                        for (int i = 0; i < sList.size(); i++) {
                                                if (tempMatricNumber.equals(sList.get(i).getMatricNumber())) {

                                                        do {
                                                                greeting(sList.get(i));
                                                                System.out.println("1. Add Course");
                                                                System.out.println("2. Drop Course");
                                                                System.out.println("3. View Course Detail");
                                                                System.out.println("4. Exit");
                                                                System.out.print("Enter Your Option: ");
                                                                option = s.nextInt();
                                                                s.nextLine();
                                                                System.out.println();

                                                                switch (option) {
                                                                        case 1:
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

                                                                                break;
                                                                        case 2:
                                                                                // kena + method remove course dekat
                                                                                // class student

                                                                                // kena + method remove student dekat
                                                                                // class course

                                                                                // same implementation as add course
                                                                                sList.get(i).displayAllCourses();
                                                                                int removeCoursePosition = s.nextInt()
                                                                                                - 1;
                                                                                s.nextLine();

                                                                                cList.get(cList.indexOf(sList.get(i)
                                                                                                .getCourse(removeCoursePosition)))
                                                                                                .removeStudent(sList
                                                                                                                .get(i));
                                                                                sList.get(i).StudRemoveCourse(
                                                                                                removeCoursePosition);

                                                                                break;
                                                                        case 3:
                                                                                sList.get(i).displayAllCourses();

                                                                                break;
                                                                        case 4:
                                                                                System.out.println("Exiting.....");
                                                                                break;

                                                                        default:
                                                                                System.out.println("WRONG INPUT ");
                                                                                break;
                                                                }

                                                        } while (option != 4);
                                                }

                                        }

                                }
                                case 3: {
                                        String tempACStaffNum;
                                        int index = 0;
                                        int option = 0;

                                        // ACADstaff
                                        /*
                                         * 1. Create course
                                         * 2. Remove course
                                         * 3. Tengok detail all course
                                         * 4. Update profile
                                         */
                                        printLogIn();
                                        System.out.print("Enter your staff number: ");
                                        tempACStaffNum = s.nextLine();
                                        for (int i = 0; i < acList.size(); i++) {
                                                if (tempACStaffNum.equals(acList.get(i).getStaffNum())) {
                                                        // index = i;
                                                        do {
                                                                greeting(acList.get(i));
                                                                System.out.println("1. Create Course");
                                                                System.out.println("2. Remove Course");
                                                                System.out.println("3. View Course Detail");
                                                                System.out.println("4. Exit");
                                                                System.out.print("Enter Your Option: ");
                                                                option = s.nextInt();
                                                                s.nextLine();
                                                                System.out.println();

                                                                switch (option) {
                                                                        case 1:
                                                                                String code;
                                                                                String nameCourse;
                                                                                int credit;
                                                                                System.out.println(
                                                                                                "Enter course code: ");
                                                                                code = s.nextLine();
                                                                                System.out.println(
                                                                                                "Enter course name: ");
                                                                                nameCourse = s.nextLine();
                                                                                System.out.println(
                                                                                                "Enter Credit hours: ");
                                                                                credit = s.nextInt();

                                                                                Course c = new Course(nameCourse, code,
                                                                                                credit);

                                                                                cList.add(c);

                                                                                break;
                                                                        case 2:
                                                                                // delete course dari system
                                                                                // delete c1;
                                                                                for (int j = 0; j < cList.size(); j++) {
                                                                                        System.out.println((j + 1)
                                                                                                        + ". " + cList.get(j).toString());
                                                                                }
                                                                                System.out.print(
                                                                                                "Please input the number of course to delete: ");

                                                                                int removeCourse = s.nextInt() - 1;
                                                                                s.nextLine();
                                                                                System.out.println();
                                                                                cList.remove(removeCourse);
                                                                                break;
                                                                        case 3:
                                                                                for (int j = 0; j < cList.size(); j++) {
                                                                                        System.out.println((j + 1)+". "
                                                                                                        + cList.get(j).toString());
                                                                                        cList.get(j).printStudent();
                                                                                }

                                                                                break;
                                                                        case 4:
                                                                                System.out.println("Exiting.....");
                                                                                break;

                                                                        default:
                                                                                System.out.println("WRONG INPUT ");
                                                                                break;

                                                                }
                                                        } while (option != 4);
                                                }

                                        }

                                        break;
                                }
                                case 4:
                                        System.exit(0);

                                default:
                                        System.out.println("WRONG INPUT ");
                                        break;
                        }

                } while (choice != 4);

        }

        public static void printMenu() {
                // Print menu details here
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+--------------- UNIVERSITI TEKNOLOGI MALAYSIA ----------------+");
                System.out.println("+-------------------- COURSE REGISTRATION ---------------------+");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("                        1. Lecturer");
                System.out.println("                        2. Student");
                System.out.println("                        3. ACADStaff");
                System.out.println("                        4. Exit");
        }

        public static void printLogIn() {
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+--------------- UNIVERSITI TEKNOLOGI MALAYSIA ----------------+");
                System.out.println("+------------------------- LOG IN -----------------------------+");
                System.out.println("+--------------------------------------------------------------+");
        }

        public static void greeting(Person p) {
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+--------------- UNIVERSITI TEKNOLOGI MALAYSIA ----------------+");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+ HELLO " + p.getName() + "!");
                System.out.println();
        }
}

/*
 * Course c1 = new Course("OOP", "SECJ2020", 3);
 * 
 * System.out.println("Enter student details:");
 * System.out.print("Name: ");
 * String name = s.nextLine();
 * 
 * System.out.print("Age: ");
 * int age = s.nextInt();
 * s.nextLine();
 * 
 * System.out.print("Email: ");
 * String email = s.nextLine();
 * 
 * System.out.print("Address: ");
 * String address = s.nextLine();
 * 
 * System.out.print("MatricNumber: ");
 * String matricNumber = s.nextLine();
 * 
 * Student student = new Student(name, age, address, email, matricNumber);
 * c1.addStudent(student);
 * 
 * s.close();
 */