public class AcademicStaffView {
    public void printAcademicStaffDetails(AcademicStaff academicStaff) {
        System.out.println("Name: " + academicStaff.getName());
        System.out.println("Age: " + academicStaff.getAge());
        System.out.println("Address: " + academicStaff.getAddress());
        System.out.println("Staff Number: " + academicStaff.getStaffNum());
        System.out.println("Department: " + academicStaff.getDepartment());
        System.out.println();
    }

    public void displayMenu() {
        System.out.println("1. Create Course");
        System.out.println("2. Remove Course");
        System.out.println("3. View Course Detail");
        System.out.println("4. Exit");
    }
}
