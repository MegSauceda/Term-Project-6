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
 public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice = -1;

        while (choice != 0)
        {
            printMenu();
            choice = readInt(keyboard, "Choose an option: ");

            switch (choice)
            {
                case 1:
                    addStudent(keyboard, sms);
                    break;
                case 2:
                    removeStudent(keyboard, sms);
                    break;
                case 3:
                    updateStudent(keyboard, sms);
                    break;
                case 4:
                    viewStudent(keyboard, sms);
                    break;
                case 5:
                    listStudents(sms);
                    break;
                case 6:
                    addGrade(keyboard, sms);
                    break;
                case 7:
                    System.out.println(">> Reports are not available yet.");
                    break;
                case 8:
                    System.out.println(">> Save is not available yet.");
                    break;
                case 9:
                    System.out.println(">> Load is not available yet.");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Displays the main of options
    public static void printMenu()
    {
        System.out.println();
        System.out.println("=== Student Management System ===");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. Update student name");
        System.out.println("4. View student details");
        System.out.println("5. List all students");
        System.out.println("6. Add grade for a student");
        System.out.println("7. Reports");
        System.out.println("8. Save to file");
        System.out.println("9. Load from file");
        System.out.println("0. Exit");
    }

    // Adds a new undergraduate or graduate student
    public static void addStudent(Scanner keyboard, StudentManagementSystem sms)
    {
        String name = readText(keyboard, "Student name: ");
        int id = readInt(keyboard, "Student ID: ");
        String type = readText(keyboard,
                "Type (U = Undergraduate, G = Graduate): ");

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

    // Removes a student by ID
    public static void removeStudent(Scanner keyboard, StudentManagementSystem sms)
    {
        int id = readInt(keyboard, "ID to remove: ");
        if (sms.removeStudent(id))
        {
            System.out.println("Student removed.");
        }
        else
        {
            System.out.println("Student not found.");
        }
    }

    // Changes a student's name
    public static void updateStudent(Scanner keyboard, StudentManagementSystem sms)
    {
        int id = readInt(keyboard, "ID to update: ");
        Student s = sms.findStudent(id);

        if (s == null)
        {
            System.out.println("Student not found.");
        }
        else
        {
            String newName = readText(keyboard, "New name: ");
            s.setName(newName);
            System.out.println("Student updated.");
        }
    }

    // Shows one student's subjects, grades, and average
    public static void viewStudent(Scanner keyboard, StudentManagementSystem sms)
    {
        int id = readInt(keyboard, "Student ID: ");
        Student s = sms.findStudent(id);

        if (s == null)
        {
            System.out.println("Student not found.");
        }
        else
        {
            System.out.println(s.getName() + " (" + s.getStudentType() + ")");
            for (int i = 0; i < s.getSubjects().size(); i++)
            {
                Subject sub = s.getSubjects().get(i);
                System.out.println("  " + sub.getSubjectName()
                        + ": " + sub.getGrade());
            }
            System.out.printf("  Average: %.2f\n", s.calculateAverage());
        }
    }

    // Lists every student in the system
    public static void listStudents(StudentManagementSystem sms)
    {
        if (sms.getStudents().size() == 0)
        {
            System.out.println("No students yet.");
        }
        else
        {
            for (int i = 0; i < sms.getStudents().size(); i++)
            {
                Student s = sms.getStudents().get(i);
                System.out.println(s.getStudentID() + " - " + s.getName()
                        + " (" + s.getStudentType() + ")");
            }
        }
    }

    // Adds a subject and grade to a student
    public static void addGrade(Scanner keyboard, StudentManagementSystem sms)
    {
        int id = readInt(keyboard, "Student ID: ");
        Student s = sms.findStudent(id);

        if (s == null)
        {
            System.out.println("Student not found.");
        }
        else
        {
            String subjectName = readText(keyboard, "Subject name: ");
            boolean done = false;

            while (!done)
            {
                double grade = readDouble(keyboard, "Grade (0-100): ");
                try
                {
                    s.addSubject(new Subject(subjectName, grade));
                    System.out.println("Grade added.");
                    done = true;
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    // Reads a whole number, asking again until the input is valid
    public static int readInt(Scanner keyboard, String prompt)
    {
        int number = 0;
        boolean valid = false;

        while (!valid)
        {
            System.out.print(prompt);
            String text = keyboard.nextLine();
            try
            {
                number = Integer.parseInt(text);
                valid = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a whole number.");
            }
        }
        return number;
    }

    // Reads a decimal number, asking again until the input is valid
    public static double readDouble(Scanner keyboard, String prompt)
    {
        double number = 0;
        boolean valid = false;

        while (!valid)
        {
            System.out.print(prompt);
            String text = keyboard.nextLine();
            try
            {
                number = Double.parseDouble(text);
                valid = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a number.");
            }
        }
        return number;
    }

    // Reads a line of text, asking again if it is empty
    public static String readText(Scanner keyboard, String prompt)
    {
        String text = "";

        while (text.length() == 0)
        {
            System.out.print(prompt);
            text = keyboard.nextLine();
            if (text.length() == 0)
            {
                System.out.println("Input cannot be empty.");
            }
        }
        return text;
    }
}