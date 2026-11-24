
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RegistrationSystem system = new RegistrationSystem();

        int choice;

        do {
            System.out.println("\n===== Student Course Registration System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Display Available Courses");
            System.out.println("4. Register Student in a Course");
            System.out.println("5. Display Student's Registered Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt(input);

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = input.nextLine();

                    System.out.print("Enter student name: ");
                    String studentName = input.nextLine();

                    System.out.print("Enter student email: ");
                    String email = input.nextLine();

                    Student student =
                        new Student(studentId, studentName, email);

                    if (system.addStudent(student)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Error: Student ID already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter course ID: ");
                    String courseId = input.nextLine();

                    System.out.print("Enter course name: ");
                    String courseName = input.nextLine();

                    Course course = new Course(courseId, courseName);

                    if (system.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Error: Course ID already exists.");
                    }
                    break;

                case 3:
                    system.displayAvailableCourses();
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    String registerStudentId = input.nextLine();

                    System.out.print("Enter course ID: ");
                    String registerCourseId = input.nextLine();

                    System.out.println(
                        system.registerStudent(
                            registerStudentId,
                            registerCourseId
                        )
                    );
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    String searchStudentId = input.nextLine();

                    system.displayRegisteredCourses(searchStudentId);
                    break;

                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        input.close();
    }

    private static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a number: ");
            input.nextLine();
        }

        int number = input.nextInt();
        input.nextLine();

        return number;
    }
}
