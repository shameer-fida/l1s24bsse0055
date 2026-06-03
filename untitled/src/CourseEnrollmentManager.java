import java.util.TreeMap;
import java.util.TreeSet;

public class CourseEnrollmentManager {

    private TreeMap<String, TreeSet<String>> courses;

    public CourseEnrollmentManager() {
        courses = new TreeMap<>();
    }

    public void addStudentToCourse(String course, String studentName) {
        courses.putIfAbsent(course, new TreeSet<>());
        courses.get(course).add(studentName);
    }

    public void removeStudentFromCourse(String course, String studentName) {
        if (courses.containsKey(course)) {
            courses.get(course).remove(studentName);

            if (courses.get(course).isEmpty()) {
                courses.remove(course);
            }
        }
    }

    public boolean isStudentEnrolled(String course, String studentName) {
        return courses.containsKey(course)
                && courses.get(course).contains(studentName);
    }

    public void displayCourseRoster(String course) {
        if (!courses.containsKey(course)) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Students enrolled in " + course + ":");

        for (String student : courses.get(course)) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        CourseEnrollmentManager manager = new CourseEnrollmentManager();

        manager.addStudentToCourse("DSA", "Ali");
        manager.addStudentToCourse("DSA", "Ahmed");
        manager.addStudentToCourse("DSA", "Bilal");
        manager.addStudentToCourse("OOP", "Usman");
        manager.addStudentToCourse("OOP", "Zain");

        manager.displayCourseRoster("DSA");

        System.out.println(
                manager.isStudentEnrolled("DSA", "Ahmed"));

        manager.removeStudentFromCourse("DSA", "Ahmed");

        System.out.println(
                manager.isStudentEnrolled("DSA", "Ahmed"));

        manager.displayCourseRoster("DSA");
    }
}