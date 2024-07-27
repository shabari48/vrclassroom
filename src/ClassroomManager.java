import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassroomManager {
    private static final ClassroomManager instance = new ClassroomManager();
    private final Map<String, Classroom> classrooms;

    private ClassroomManager() {
        classrooms = new HashMap<>();
    }

    public static ClassroomManager getInstance() {
        return instance;
    }

    public void addClassroom(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be empty.");
        }

        String upperCaseName = name.toUpperCase();

        if (classrooms.containsKey(upperCaseName)) {
            throw new IllegalArgumentException("Classroom '" + name + "' already exists.");
        }

        classrooms.put(upperCaseName, new Classroom(upperCaseName));
    }

    public void removeClassroom(String name) {
        String upperCaseName = name.toUpperCase();
        if (!classrooms.containsKey(upperCaseName)) {
            throw new IllegalArgumentException("Classroom '" + name + "' does not exist.");
        }

        classrooms.remove(upperCaseName);
    }

    public List<String> listClassrooms() {
        return new ArrayList<>(classrooms.keySet());
    }

    public void enrollStudent(String studentId, String studentName, String classroomName) {
        String upperCaseClassroomName = classroomName.toUpperCase();
        Classroom classroom = classrooms.get(upperCaseClassroomName);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom '" + classroomName + "' does not exist.");
        }

        Student student = new Student(studentId, studentName);
        classroom.addStudent(student);
    }

    public List<Student> listStudentsInClassroom(String classroomName) {
        String upperCaseClassroomName = classroomName.toUpperCase();
        Classroom classroom = classrooms.get(upperCaseClassroomName);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom '" + classroomName + "' does not exist.");
        }

        return classroom.listStudents();
    }

    public void scheduleAssignment(String classroomName, String assignmentName, String assignmentDetails) {
        String upperCaseClassroomName = classroomName.toUpperCase();
        Classroom classroom = classrooms.get(upperCaseClassroomName);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom '" + classroomName + "' does not exist.");
        }

        Assignment assignment = new Assignment(assignmentName, assignmentDetails);
        classroom.addAssignment(assignment);
    }

    public void submitAssignment(String studentId, String classroomName, String assignmentName) {
        String upperCaseClassroomName = classroomName.toUpperCase();
        Classroom classroom = classrooms.get(upperCaseClassroomName);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom '" + classroomName + "' does not exist.");
        }

        boolean studentExists = classroom.listStudents().stream().anyMatch(s -> s.getId().equals(studentId));
        if (!studentExists) {
            throw new IllegalArgumentException("Student with ID '" + studentId + "' is not enrolled in classroom '" + classroomName + "'.");
        }

        boolean assignmentExists = classroom.listAssignments().stream().anyMatch(a -> a.getName().equals(assignmentName));
        if (!assignmentExists) {
            throw new IllegalArgumentException("Assignment '" + assignmentName + "' does not exist in classroom '" + classroomName + "'.");
        }

        // Here you would typically update the assignment status for the student
        System.out.println("Assignment '" + assignmentName + "' submitted by Student " + studentId + " in " + classroomName + ".");
    }
}