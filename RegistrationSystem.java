
import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    private List<Student> students;
    private List<Course> courses;

    public RegistrationSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(student.getId())) {
                return false;
            }
        }

        students.add(student);
        return true;
    }

    public boolean addCourse(Course course) {
        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(course.getId())) {
                return false;
            }
        }

        courses.add(course);
        return true;
    }

    public void displayAvailableCourses() {
        boolean found = false;

        System.out.println("\n--- Available Courses ---");

        for (Course course : courses) {
            if (course.isAvailable()) {
                System.out.println(
                    course.getId() + " - " + course.getName()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available courses.");
        }
    }

    public String registerStudent(String studentId, String courseId) {
        Student selectedStudent = null;
        Course selectedCourse = null;

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(studentId)) {
                selectedStudent = student;
                break;
            }
        }

        for (Course course : courses) {
            if (course.getId().equalsIgnoreCase(courseId)) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedStudent == null) {
            return "Error: Student not found.";
        }

        if (selectedCourse == null) {
            return "Error: Course not found.";
        }

        if (!selectedCourse.isAvailable()) {
            return "Error: Course is unavailable.";
        }

        for (Course course : selectedStudent.getRegisteredCourses()) {
            if (course.getId().equalsIgnoreCase(courseId)) {
                return "Error: Student is already registered in this course.";
            }
        }

        selectedStudent.addCourse(selectedCourse);

        return "Registration successful!";
    }

    public void displayRegisteredCourses(String studentId) {
        Student selectedStudent = null;

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(studentId)) {
                selectedStudent = student;
                break;
            }
        }

        if (selectedStudent == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        System.out.println(
            "\nRegistered courses for " + selectedStudent.getName() + ":"
        );

        List<Course> registeredCourses =
            selectedStudent.getRegisteredCourses();

        if (registeredCourses.isEmpty()) {
            System.out.println("This student has no registered courses.");
            return;
        }

        for (Course course : registeredCourses) {
            System.out.println(
                course.getId() + " - " + course.getName()
            );
        }
    }
}
