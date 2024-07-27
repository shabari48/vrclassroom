import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Classroom {
    private final String name;
    private final List<Student> students;
    private final List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " is already enrolled in this classroom.");
        }
        students.add(student);
    }

    public void removeStudent(String studentId) {
        if (!students.removeIf(s -> s.getId().equals(studentId))) {
            throw new IllegalArgumentException("Student with ID " + studentId + " is not enrolled in this classroom.");
        }
    }

    public List<Student> listStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addAssignment(Assignment assignment) {
        if (assignments.stream().anyMatch(a -> a.getName().equals(assignment.getName()))) {
            throw new IllegalArgumentException("Assignment '" + assignment.getName() + "' already exists in this classroom.");
        }
        assignments.add(assignment);
    }

    public List<Assignment> listAssignments() {
        return Collections.unmodifiableList(assignments);
    }
}