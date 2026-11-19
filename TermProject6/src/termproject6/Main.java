/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package termproject6;
import java.util.Scanner;
/**
 *
 * @author Moises
 */
public class Main 
{
 private static Scanner input = new Scanner(System.in);
    private static StudentManagementSystem sms = new StudentManagementSystem();

    public static void main(String[] args)
    {
        int choice = -1;
        while (choice != 0)
        {
            printMenu();
            choice = readInt("Choose an option: ");
            switch (choice)
            {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: updateStudent(); break;
                case 4: viewStudent(); break;
                case 5: listStudents(); break;
                case 6: addGrade(); break;
                case 7: System.out.println("Reports - coming from Derick"); break;
                case 8: System.out.println("Save - coming from Derick"); break;
                case 9: System.out.println("Load - coming from Derick"); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. Update student");
        System.out.println("4. View student details");
        System.out.println("5. List all students");
        System.out.println("6. Add grade for a student");
        System.out.println("7. Reports");
        System.out.println("8. Save to file");
        System.out.println("9. Load from file");
        System.out.println("0. Exit");
    }

    private static void addStudent()
    {
        String name = readText("Student name: ");
        int id = readInt("Student ID: ");
        String type = readText("Type (U = Undergraduate, G = Graduate): ");
        Student s;
        if (type.equalsIgnoreCase("G"))
        {
            s = new GraduateStudent(name, id);
        }
        else
        {
            s = new UndergraduateStudent(name, id);
        }
        if (sms.addStudent(s))
        {
            System.out.println("Student added.");
        }
        else
        {
            System.out.println("That ID already exists.");
        }
    }

    private static void removeStudent()
    {
        int id = readInt("ID to remove: ");
        System.out.println(sms.removeStudent(id) ? "Removed." : "Student not found.");
    }

    private static void updateStudent()
    {
        Student s = sms.findStudent(readInt("ID to update: "));
        if (s == null)
        {
            System.out.println("Student not found.");
            return;
        }
        s.setName(readText("New name: "));
        System.out.println("Updated.");
    }

    private static void viewStudent()
    {
        Student s = sms.findStudent(readInt("Student ID: "));
        if (s == null)
        {
            System.out.println("Student not found.");
            return;
        }
        System.out.println(s.getName() + " (" + s.getStudentType() + ")");
        for (Subject sub : s.getSubjects())
        {
            System.out.println("  " + sub.getSubjectName() + ": " + sub.getGrade());
        }
        System.out.printf("  Average: %.2f%n", s.calculateAverage());
    }

    private static void listStudents()
    {
        if (sms.getStudents().isEmpty())
        {
            System.out.println("No students yet.");
        }
        for (Student s : sms.getStudents())
        {
            System.out.println(s.getStudentID() + " - " + s.getName()
                    + " (" + s.getStudentType() + ")");
        }
    }

    private static void addGrade()
    {
        Student s = sms.findStudent(readInt("Student ID: "));
        if (s == null)
        {
            System.out.println("Student not found.");
            return;
        }
        String subject = readText("Subject name: ");
        while (true)
        {
            double grade = readDouble("Grade (0-100): ");
            try
            {
                s.addSubject(new Subject(subject, grade));
                System.out.println("Grade added.");
                return;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    // ---------- input helpers ----------
    private static int readInt(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            try
            {
                return Integer.parseInt(input.nextLine().trim());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            try
            {
                return Double.parseDouble(input.nextLine().trim());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static String readText(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String text = input.nextLine().trim();
            if (!text.isEmpty())
            {
                return text;
            }
            System.out.println("Input cannot be empty.");
        }
    }
}   