import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * The main function of the program, which serves as the entry point. It sets up the logger, prints welcome
     * messages, and provides a list of available commands. It then enters a loop where it prompts the user for
     * commands and executes them accordingly. The program continues to run until the user enters "exit". The
     * available commands are:
     * - add_classroom <class_name>: Adds a new classroom with the specified name.
     * - add_student <student_id> <class_name>: Adds a new student to the specified classroom.
     * - schedule_assignment <class_name> <assignment_details>: Schedules a new assignment for the specified
     *   classroom.
     * - submit_assignment <student_id> <class_name> <assignment_details>: Submits an assignment for the specified
     *   student and classroom.
     * - exit: Exits the program.
     *
     * @param  args  the command-line arguments passed to the program
     */
    
    public static void main(String[] args) {
        setupLogger();
        LOGGER.info("Virtual Classroom Manager started");

        System.out.println("Welcome to Virtual Classroom Manager!");
        System.out.println("Available commands:");
        System.out.println("add_classroom <class_name>");
        System.out.println("add_student <student_id> <class_name>");
        System.out.println("schedule_assignment <class_name> <assignment_details>");
        System.out.println("submit_assignment <student_id> <class_name> <assignment_details>");
        System.out.println("exit");

        while (true) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+", 4);

            try {
                switch (parts[0].toLowerCase()) {
                    case "add_classroom":
                        if (parts.length < 2) {
                            LOGGER.warning("Classroom Manager requires at least 2 arguments");
                            System.out.println("Invalid command. Usage: add_classroom <class_name>");
                            break;
                        }
                        addClassroom(parts[1]);
                        break;
                    case "add_student":
                        if (parts.length < 3) {
                            LOGGER.warning(" Add Student requires at least 3 arguments");
                            System.out.println("Invalid command. Usage: add_student <student_id> <class_name>");
                            break;
                        }
                        addStudent(parts[1], parts[2]);
                        break;
                    case "schedule_assignment":
                        if (parts.length < 3) {
                            LOGGER.warning("Schedule Assignment requires at least 3 arguments");
                            System.out.println("Invalid command. Usage: schedule_assignment <class_name> <assignment_details>");
                            break;
                        }
                        scheduleAssignment(parts[1], parts[2]);
                        break;
                    case "submit_assignment":
                        if (parts.length < 4) {
                            LOGGER.warning("Submit Assignment requires at least 4 arguments");
                            System.out.println("Invalid command. Usage: submit_assignment <student_id> <class_name> <assignment_details>");
                            break;
                        }
                        submitAssignment(parts[1], parts[2], parts[3]);
                        break;
                    case "exit":
                        System.out.println("Exiting Virtual Classroom Manager. Goodbye!");
                        LOGGER.info("Virtual Classroom Manager stopped");
                        return;
                    default:
                        System.out.println("Unknown command. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                LOGGER.warning(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                LOGGER.severe("Unexpected error: " + e.getMessage());
            }
        }
    }

    /**
     * Sets up the logger for the application.
     *
     * This function creates a FileHandler to log messages to a file named "virtual_classroom.log".
     * It also sets up a SimpleFormatter to format the log messages.
     * The logger is then added to the FileHandler and the log level is set to Level.ALL.
     *
     * @throws Exception if there is an error setting up the logger
     */
    
    
    private static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("virtual_classroom.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (Exception e) {
            System.err.println("Error setting up logger: " + e.getMessage());
        }
    }

    /**
     * Adds a classroom with the given name.
     *
     * @param  name  the name of the classroom to be added
     * @return       void
     */
    
    private static void addClassroom(String name) {
        ClassroomManager.getInstance().addClassroom(name);
        System.out.println("Classroom " + name + " has been created.");
        LOGGER.info("Classroom added: " + name);
    }

    /**
     * Adds a student to a classroom.
     *
     * @param  studentId  the ID of the student to be enrolled
     * @param  className  the name of the classroom to enroll the student in
     */
    private static void addStudent(String studentId, String className) {
        ClassroomManager.getInstance().enrollStudent(studentId, "Student " + studentId, className);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        LOGGER.info("Student " + studentId + " enrolled in " + className);
    }

    /**
     * Schedules an assignment for a given classroom.
     *
     * @param  className          the name of the classroom to schedule the assignment for
     * @param  assignmentDetails the details of the assignment to be scheduled
     */
    private static void scheduleAssignment(String className, String assignmentDetails) {
        ClassroomManager.getInstance().scheduleAssignment(className, "Assignment", assignmentDetails);
        System.out.println("Assignment for " + className + " has been scheduled.");
        LOGGER.info("Assignment scheduled for " + className);
    }
    
    
    /**
     * Submits an assignment for a student in a given classroom.
     *
     * @param  studentId         the ID of the student submitting the assignment
     * @param  className         the name of the classroom the assignment is for
     * @param  assignmentDetails the details of the assignment being submitted
     */
    private static void submitAssignment(String studentId, String className, String assignmentDetails) {
        ClassroomManager.getInstance().submitAssignment(studentId, className, "Assignment");
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        LOGGER.info("Assignment submitted by Student " + studentId + " in " + className);
    }
}