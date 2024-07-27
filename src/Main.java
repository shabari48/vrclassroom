import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        setupLogger();
        LOGGER.info("Virtual Classroom Manager started");

        boolean running = true;

        // Application's Main Menu which contains all the functionalities.
        // Users can choose from the available functionalities

        while (running) {
            System.out.println("\nVirtual Classroom Manager");
            System.out.println("1. Add Classroom");
            System.out.println("2. Remove Classroom");
            System.out.println("3. List Classrooms");
            System.out.println("4. Enroll Student");
            System.out.println("5. List Students in Classroom");
            System.out.println("6. Schedule Assignment");
            System.out.println("7. Submit Assignment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addClassroom();
                        break;
                    case 2:
                        removeClassroom();
                        break;
                    case 3:
                        listClassrooms();
                        break;
                    case 4:
                        enrollStudent();
                        break;
                    case 5:
                        listStudentsInClassroom();
                        break;
                    case 6:
                        scheduleAssignment();
                        break;
                    case 7:
                        submitAssignment();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        running=false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
             // Handling errors that may arise during getting user input
            catch (NumberFormatException e) {
                LOGGER.warning("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                LOGGER.warning("Error: " + e.getMessage());
            } catch (Exception e) {
                LOGGER.warning("An unexpected error occurred: " + e.getMessage());
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
        LOGGER.info("Virtual Classroom Manager stopped");
    }

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

    //  ClassroomManager.getInstance()  -> returns the only Classroom Manager Object
    //  Handles all functionalities in the application

    //  addClassroom,removeClassroom,listClassrooms,
    //  enrollStudent,listStudentsInClassroom.
    //  scheduleAssignment,submitAssignment


    private static void addClassroom() {
        System.out.print("Enter classroom name: ");
        String name = scanner.nextLine();
        try {
            ClassroomManager.getInstance().addClassroom(name);
        } catch (IllegalArgumentException e) {
            LOGGER.warning("Failed to add classroom: " + e.getMessage());
        }
    }

    private static void removeClassroom() {
        System.out.print("Enter classroom name to remove: ");
        String name = scanner.nextLine();
        ClassroomManager.getInstance().removeClassroom(name);
        LOGGER.info("Classroom removed: " + name);
    }

    private static void listClassrooms() {
        List<String> classrooms = ClassroomManager.getInstance().listClassrooms();
        if (!classrooms.isEmpty()) {
            System.out.println("Classrooms:");
            for (String classroom : classrooms) {
                System.out.println("- " + classroom);
            }
        } else {
            LOGGER.warning("No classrooms available.");
        }
    }

    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter classroom name: ");
        String classroom = scanner.nextLine();

        ClassroomManager.getInstance().enrollStudent(id, name, classroom);
        LOGGER.info("Student '" + name + "' successfully enrolled in '" + classroom + "'.");
    }

    private static void listStudentsInClassroom() {
        System.out.print("Enter classroom name: ");
        String classroom = scanner.nextLine();

        List<Student> students = ClassroomManager.getInstance().listStudentsInClassroom(classroom);
        if (!students.isEmpty()) {
            System.out.println("Students in " + classroom + ":");
            for (Student student : students) {
                System.out.println("- ID: " + student.getId() + ", Name: " + student.getName());
            }
        } else {
            LOGGER.warning("No students enrolled in " + classroom + ".");
        }
    }

    private static void scheduleAssignment() {
        System.out.print("Enter classroom name: ");
        String classroom = scanner.nextLine();
        System.out.print("Enter assignment name: ");
        String name = scanner.nextLine();
        System.out.print("Enter assignment details: ");
        String details = scanner.nextLine();

        ClassroomManager.getInstance().scheduleAssignment(classroom, name, details);
        LOGGER.info("Assignment '" + name + "' scheduled for '" + classroom + "' successfully.");
    }

    private static void submitAssignment() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter classroom name: ");
        String classroom = scanner.nextLine();
        System.out.print("Enter assignment name: ");
        String assignment = scanner.nextLine();

        try {
            ClassroomManager.getInstance().submitAssignment(studentId, classroom, assignment);
            LOGGER.info("Assignment submitted: Student " + studentId + ", Classroom " + classroom + ", Assignment " + assignment);
        } catch (IllegalArgumentException e) {
            LOGGER.warning("Failed to submit assignment: " + e.getMessage());
        }
    }
}