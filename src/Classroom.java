import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Classroom {
    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());
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

    /**
     * Adds a student to the classroom.
     *
     * @param  student  the student to be added
     * @throws IllegalArgumentException if the student with the same ID is already enrolled in the classroom
     */
    public void addStudent(Student student) {
        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            LOGGER.warning("Attempt to add already existing student");
            throw new IllegalArgumentException("Student with ID " + student.getId() + " is already enrolled in this classroom.");
        }
        students.add(student);
        LOGGER.info("Student " + student.getId() + " added to classroom " + name);
    }

    public List<Student> listStudents() {
        return Collections.unmodifiableList(students);
    }

    /**
     * Adds an assignment to the classroom if it does not already exist.
     *
     * @param  assignment  the assignment to be added
     * @throws IllegalArgumentException if the assignment already exists in the classroom
     */
    public void addAssignment(Assignment assignment) {
        if (assignments.stream().anyMatch(a -> a.getName().equals(assignment.getName()))) {
            LOGGER.warning("Attempt to add already existing assignment " + assignment.getName());
            throw new IllegalArgumentException("Assignment '" + assignment.getName() + "' already exists in this classroom.");
        }
        assignments.add(assignment);
        LOGGER.info("Assignment " + assignment.getName() + " added to classroom " + name);
    }

    /**
     * Returns an unmodifiable list of all assignments in this classroom.
     *
     * @return an unmodifiable list of assignments
     */
    public List<Assignment> listAssignments() {
        return Collections.unmodifiableList(assignments);
    }
}