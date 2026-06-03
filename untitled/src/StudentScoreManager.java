import java.util.Map;
import java.util.TreeMap;

public class StudentScoreManager {

    private TreeMap<String, Integer> studentScores;

    public StudentScoreManager() {
        studentScores = new TreeMap<>();
    }

    public void addOrUpdateScore(String name, int score) {
        studentScores.put(name, score);
    }

    public void removeStudent(String name) {
        studentScores.remove(name);
    }

    public Integer getScore(String name) {
        return studentScores.get(name);
    }

    public void displayAllStudents() {
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void displayStudentsInRange(String start, String end) {
        for (Map.Entry<String, Integer> entry :
                studentScores.subMap(start, true, end, true).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StudentScoreManager manager = new StudentScoreManager();

        manager.addOrUpdateScore("Ali", 85);
        manager.addOrUpdateScore("Ahmed", 92);
        manager.addOrUpdateScore("Bilal", 78);
        manager.addOrUpdateScore("Zain", 88);
        manager.addOrUpdateScore("Usman", 95);

        System.out.println("All Students:");
        manager.displayAllStudents();

        System.out.println("\nScore of Ahmed:");
        System.out.println(manager.getScore("Ahmed"));

        System.out.println("\nStudents from A to U:");
        manager.displayStudentsInRange("A", "U");

        manager.removeStudent("Bilal");

        System.out.println("\nAfter Removing Bilal:");
        manager.displayAllStudents();
    }
}