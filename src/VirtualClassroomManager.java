import java.util.List;
import java.util.Scanner;

public class VirtualClassroomManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void addClassroom() {
        System.out.print("Enter classroom name: ");
        String name = scanner.nextLine();
        ClassroomManager.getInstance().addClassroom(name);
        System.out.println("Classroom '" + name + "' added successfully.");
    }

    private static void removeClassroom() {
        System.out.print("Enter classroom name to remove: ");
        String name = scanner.nextLine();
        ClassroomManager.getInstance().removeClassroom(name);
        System.out.println("Classroom '" + name + "' removed successfully.");
    }

    private static void listClassrooms() {
        List<String> classrooms = ClassroomManager.getInstance().listClassrooms();
        if (!classrooms.isEmpty()) {
            System.out.println("Classrooms:");
            for (String classroom : classrooms) {
                System.out.println("- " + classroom);
            }
        } else {
            System.out.println("No classrooms available.");
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
        System.out.println("Student '" + name + "' (ID: " + id + ") enrolled in '" + classroom + "' successfully.");
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
            System.out.println("No students enrolled in " + classroom + ".");
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
        System.out.println("Assignment '" + name + "' scheduled for '" + classroom + "' successfully.");
    }

    private static void submitAssignment() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter classroom name: ");
        String classroom = scanner.nextLine();
        System.out.print("Enter assignment name: ");
        String assignment = scanner.nextLine();

        ClassroomManager.getInstance().submitAssignment(studentId, classroom, assignment);
        System.out.println("Assignment submitted successfully.");
    }
}