import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentRecordManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting the system!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nStudent Record Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        Student student = new Student(nextId++, name, marks);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the record.");
            return;
        }
        
        System.out.println("\nStudent Records:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("No students in the record to update.");
            return;
        }
        
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToUpdate = student;
                break;
            }
        }
        
        if (studentToUpdate == null) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }
        
        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            studentToUpdate.setName(newName);
        }
        
        System.out.print("Enter new marks (enter -1 to keep current): ");
        double newMarks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (newMarks != -1) {
            studentToUpdate.setMarks(newMarks);
        }
        
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students in the record to delete.");
            return;
        }
        
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                removed = true;
                break;
            }
        }
        
        if (removed) {
            System.out.println("Student with ID " + id + " deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}