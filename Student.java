/**
 * A Student object holds the data of ONE student.
 * OOP idea: ENCAPSULATION -> fields are private, accessed only via getters/setters.
 */
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String course;
    private double marks;

    // Constructor: runs when we write  new Student(...)
    public Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    // Grade is calculated from marks
    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    // Default sorting order for Collections.sort(): by ID
    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }

    // Controls how a Student prints with System.out.println(student)
    @Override
    public String toString() {
        return String.format("ID: %-4d Name: %-12s Course: %-8s Marks: %-6.1f Grade: %s",
                id, name, course, marks, getGrade());
    }
}
