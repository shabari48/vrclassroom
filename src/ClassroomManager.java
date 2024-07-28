import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ClassroomManager {
    private static final Logger LOGGER = Logger.getLogger(ClassroomManager.class.getName());
    private static final ClassroomManager instance = new ClassroomManager();
    private final Map<String, Classroom> classrooms;

    private ClassroomManager() {
        classrooms = new HashMap<>();
        LOGGER.info("ClassroomManager initialized");
    }

    public static ClassroomManager getInstance() {
        return instance;
    }

    public void addClassroom(String name) {
        if (name == null || name.trim().isEmpty()) {
            LOGGER.warning("Attempt to add classroom with empty name");
            throw new IllegalArgumentException("Classroom name cannot be empty.");
        }

        String upperCaseName = name.toUpperCase();

        if (classrooms.containsKey(upperCaseName)) {
            LOGGER.warning("Attempt to add duplicate classroom: " + name);
            throw new IllegalArgumentException("Classroom '" + name + "' already exists.");
        }

        classrooms.put(upperCaseName, new Classroom(upperCaseName));
        LOGGER.info("Classroom added: " + name);
    }

    public void enrollStudent(String studentId, String studentName, String classroomName) {
        String upperCaseClassroomName = classroomName.toUpperCase();
        Classroom classroom = classrooms.get(upperCaseClassroomName);
        if (classroom == null) {
            LOGGER.warning("Attempt to enroll in non-existent classroom: " + classroomName);
            throw new IllegalArgumentException("Classroom '" + classroomName + "' does not exist.");
        }

        Student student = new Student(studentId, studentName);
        classroom.addStudent(student);
        LOGGER.info("Student " + studentId + " enrolled in " + classroomName);
    }

    public void scheduleAssignment(String classroomName, String assignmentName, String assignmentDetails) {
        String upperCaseClassroomName = classroomName.toUpperCase();
        Classroom classroom = classrooms.get(upperCaseClassroomName);
        if (classroom == null) {
            LOGGER.warning("Attempt to schedule assignment in non-existent classroom: " + classroomName);
            throw new IllegalArgumentException("Classroom '" + classroomName + "' does not exist.");
        }

        Assignment assignment = new Assignment(assignmentName, assignmentDetails);
        classroom.addAssignment(assignment);
        LOGGER.info("Assignment scheduled for " + classroomName);
    }

    public void submitAssignment(String studentId, String classroomName, String assignmentName) {
        String upperCaseClassroomName = classroomName.toUpperCase();
        Classroom classroom = classrooms.get(upperCaseClassroomName);
        if (classroom == null) {
            LOGGER.warning("Attempt to submit assignment to non-existent classroom: " + classroomName);
            throw new IllegalArgumentException("Classroom '" + classroomName + "' does not exist.");
        }

        boolean studentExists = classroom.listStudents().stream().anyMatch(s -> s.getId().equals(studentId));
        if (!studentExists) {
            LOGGER.warning("Attempt to submit assignment for non-enrolled student: " + studentId + " in classroom " + classroomName);
            throw new IllegalArgumentException("Student with ID '" + studentId + "' is not enrolled in classroom '" + classroomName + "'.");
        }

        boolean assignmentExists = classroom.listAssignments().stream().anyMatch(a -> a.getName().equals(assignmentName));
        if (!assignmentExists) {
            LOGGER.warning("Attempt to submit non-existent assignment: " + assignmentName + " in classroom " + classroomName);
            throw new IllegalArgumentException("Assignment '" + assignmentName + "' does not exist in classroom '" + classroomName + "'.");
        }

        LOGGER.info("Assignment '" + assignmentName + "' submitted by Student " + studentId + " in " + classroomName);
    }
}