import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        // A few sample students so the app is not empty at start
        manager.addStudent(new Student(1, "Asha", "Java", 88));
        manager.addStudent(new Student(2, "Ravi", "Python", 72.5));
        manager.addStudent(new Student(3, "Meena", "Java", 95));

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Find student by ID");
            System.out.println("4. Update marks");
            System.out.println("5. Remove student");
            System.out.println("6. Rank list (highest marks first)");
            System.out.println("7. Search by course");
            System.out.println("8. Class average");
            System.out.println("0. Exit");
            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: printList(manager.getAllSortedById()); break;
                case 3: findStudent(); break;
                case 4: updateMarks(); break;
                case 5: removeStudent(); break;
                case 6: printList(manager.getRankList()); break;
                case 7: searchCourse(); break;
                case 8: System.out.printf("Average marks of %d students: %.2f%n",
                        manager.getCount(), manager.getAverageMarks()); break;
                case 0: System.out.println("Bye!"); return;
                default: System.out.println("Invalid choice, try again.");
            }
        }
    }

    static void addStudent() {
        int id = readInt("ID: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();
        double marks = readDouble("Marks (0-100): ");
        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }
        if (manager.addStudent(new Student(id, name, course, marks))) {
            System.out.println("Student added.");
        } else {
            System.out.println("A student with this ID already exists.");
        }
    }

    static void findStudent() {
        Student s = manager.findStudent(readInt("ID: "));
        System.out.println(s == null ? "Student not found." : s);
    }

    static void updateMarks() {
        int id = readInt("ID: ");
        double marks = readDouble("New marks: ");
        System.out.println(manager.updateMarks(id, marks) ? "Marks updated." : "Student not found.");
    }

    static void removeStudent() {
        System.out.println(manager.removeStudent(readInt("ID: ")) ? "Removed." : "Student not found.");
    }

    static void searchCourse() {
        System.out.print("Course: ");
        printList(manager.searchByCourse(sc.nextLine()));
    }

    static void printList(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("No students to show.");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    // Helpers: keep asking until the user types a valid number
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a whole number."); }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a number."); }
        }
    }
}
