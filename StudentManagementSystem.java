import java.util.*;

class Student {
    private String name;
    private int age;
    private double grade;
    private String studentId;
    private String contact;

    // Constructor
    public Student(String name, int age, double grade, String studentId, String contact) {
        this.name = name;
        setAge(age);
        setGrade(grade);
        this.studentId = studentId;
        this.contact = contact;
    }

    // Validation for Age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Setting default age = 18");
            this.age = 18;
        }
    }

    // Validation for Grade
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade! Setting default grade = 0");
            this.grade = 0;
        }
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }

    // Update Method
    public void updateDetails(String name, int age, double grade, String contact) {
        this.name = name;
        setAge(age);
        setGrade(grade);
        this.contact = contact;
    }

    // Display Method (Formatted Output)
    public void display() {
        System.out.printf("%-10s %-15s %-5d %-7.2f %-15s\n",
                studentId, name, age, grade, contact);
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: searchStudent(); break;
                case 6: 
                    System.out.println("Exiting... Thank You!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        students.add(new Student(name, age, grade, id, contact));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.printf("%-10s %-15s %-5s %-7s %-15s\n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("------------------------------------------------------");

        for (Student s : students) {
            s.display();
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getStudentId().equals(id)) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                int age = sc.nextInt();

                System.out.print("Enter New Grade: ");
                double grade = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter New Contact: ");
                String contact = sc.nextLine();

                s.updateDetails(name, age, grade, contact);
                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getStudentId().equals(id)) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    static void searchStudent() {
        System.out.print("Search by (1) ID or (2) Name: ");
        int option = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (option == 1) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            for (Student s : students) {
                if (s.getStudentId().equals(id)) {
                    s.display();
                    found = true;
                }
            }
        } else if (option == 2) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            for (Student s : students) {
                if (s.getName().equalsIgnoreCase(name)) {
                    s.display();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }
}
