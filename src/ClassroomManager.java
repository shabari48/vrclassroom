import java.util.HashMap;
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

    /**
     * Returns the singleton instance of the ClassroomManager class.
     *
     * @return the singleton instance of ClassroomManager
     */
    public static ClassroomManager getInstance() {
        return instance;
    }

    /**
     * Adds a new classroom to the classroom manager.
     *
     * @param  name  the name of the classroom to be added
     * @throws IllegalArgumentException if the classroom name is empty or already exists
     */
    
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

    /**
     * Enrolls a student in a classroom.
     *
     * @param  studentId     the ID of the student to be enrolled
     * @param  studentName   the name of the student to be enrolled
     * @param  classroomName the name of the classroom to enroll the student in
     * @throws IllegalArgumentException if the classroom does not exist
     */

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

    /**
     * Schedules an assignment for a given classroom.
     *
     * @param  classroomName    the name of the classroom to schedule the assignment for
     * @param  assignmentName   the name of the assignment to be scheduled
     * @param  assignmentDetails the details of the assignment to be scheduled
     * @throws IllegalArgumentException if the classroom does not exist
     */
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

    /**
     * Submits an assignment for a student in a given classroom.
     *
     * @param  studentId         the ID of the student submitting the assignment
     * @param  classroomName     the name of the classroom the assignment is for
     * @param  assignmentName    the name of the assignment being submitted
     * @throws IllegalArgumentException if the classroom or assignment does not exist, or if the student is not enrolled in the classroom
     */
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