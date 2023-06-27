import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcademicStaffController {
    private AcademicStaff model;
    private AcademicStaffView view;
    private List<Course> courseList;
    private List<Student> studentList;
    private List<Lecturer> lecturerList;

    public AcademicStaffController(AcademicStaff model, AcademicStaffView view, List<Course> courseList,
            List<Student> studentList, List<Lecturer> lecturerList) {
        this.model = model;
        this.view = view;
        this.courseList = courseList;
        this.studentList = studentList;
        this.lecturerList = lecturerList;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            view.displayMenu();
            System.out.print("Enter Your Option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    createCourse(scanner);
                    break;
                case 2:
                    removeCourse(scanner);
                    break;
                case 3:
                    viewCourseDetail();
                    break;
                case 4:
                    System.out.println("Exiting.....");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println();
        } while (option != 4);
    }

    private void createCourse(Scanner scanner) {
        System.out.println("Enter course code: ");
        String code = scanner.nextLine();
        System.out.println("Enter course name: ");
        String name = scanner.nextLine();
        System.out.println("Enter credit hours: ");
        int credit = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Course course = new Course(name, code, credit);
        courseList.add(course);

        System.out.println("Course created successfully.");
    }

    private void removeCourse(Scanner scanner) {
        if (courseList.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\nAvailable courses:");
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println((i + 1) + ". " + courseList.get(i).toString());
        }

        System.out.print("Please input the number of the course to delete: ");
        int removeCourseIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume the newline character

        if (removeCourseIndex >= 0 && removeCourseIndex < courseList.size()) {
            Course courseToRemove = courseList.get(removeCourseIndex);
            String courseCodeToRemove = courseToRemove.getCourseCode();

            // Remove the course from the students' list of courses
            for (Student student : studentList) {
                student.StudRemoveCourse(courseCodeToRemove);
            }
            for (Lecturer lecturer : lecturerList) {
                // Check if the lecturer's course matches the one to remove
                if (lecturer.getCourse() != null && lecturer.getCourse().equals(courseList.get(removeCourseIndex))) {
        // If it matches, remove the course from the lecturer's assignment
                    lecturer.setCourse(null);
                    break; // Exit the loop since we found the matching lecturer
                }
            }
            // Remove the course from the course list
            courseList.remove(removeCourseIndex);
            System.out.println("\nCourse removed successfully.");
        } else {
            System.out.println("Invalid course number.");
        }
    }

    private void viewCourseDetail() {
        if (courseList.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\nAvailable courses:");
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println((i + 1) + ". " + courseList.get(i).toString());
        }
    }
}
