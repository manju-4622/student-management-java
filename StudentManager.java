import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Handles all the student operations.
 * COLLECTIONS used:
 *   HashMap<Integer, Student> -> find a student quickly by ID
 *   ArrayList<Student>        -> to show lists and sort them
 */
public class StudentManager {
    // key = student ID, value = the Student object
    private HashMap<Integer, Student> students = new HashMap<>();

    public boolean addStudent(Student s) {
        if (students.containsKey(s.getId())) {
            return false;                 // ID already used
        }
        students.put(s.getId(), s);
        return true;
    }

    public Student findStudent(int id) {
        return students.get(id);          // returns null if not found
    }

    public boolean removeStudent(int id) {
        return students.remove(id) != null;
    }

    public boolean updateMarks(int id, double newMarks) {
        Student s = students.get(id);
        if (s == null) return false;
        s.setMarks(newMarks);
        return true;
    }

    // All students sorted by ID (uses compareTo in Student)
    public ArrayList<Student> getAllSortedById() {
        ArrayList<Student> list = new ArrayList<>(students.values());
        Collections.sort(list);
        return list;
    }

    // All students sorted by marks, highest first
    public ArrayList<Student> getRankList() {
        ArrayList<Student> list = new ArrayList<>(students.values());
        list.sort((a, b) -> Double.compare(b.getMarks(), a.getMarks()));
        return list;
    }

    public ArrayList<Student> searchByCourse(String course) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students.values()) {
            if (s.getCourse().equalsIgnoreCase(course)) {
                result.add(s);
            }
        }
        return result;
    }

    public double getAverageMarks() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student s : students.values()) {
            total += s.getMarks();
        }
        return total / students.size();
    }

    public int getCount() { return students.size(); }
}
