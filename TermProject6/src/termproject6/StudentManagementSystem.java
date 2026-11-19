/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package termproject6;
import java.util.ArrayList;
/**
 *
 * @author Moises
 */
public class StudentManagementSystem 
{
    private ArrayList<Student> students;

    public StudentManagementSystem()
    {
        students = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudents()
    {
        return students;
    }

    // Replaces list 
    public void setStudents(ArrayList<Student> list)
    {
        students = list;
    }

    // Returns the student with this ID OR null if not found 
    public Student findStudent(int id)
    {
        for (Student s : students)
        {
            if (s.getStudentID() == id)
            {
                return s;
            }
        }
        return null;
    }

    // Adds a student or returns false if the ID already exists
    public boolean addStudent(Student s)
    {
        if (findStudent(s.getStudentID()) != null)
        {
            return false;
        }
        students.add(s);
        return true;
    }

    // Removes a student by ID or returns true if removed
    public boolean removeStudent(int id)
    {
        Student s = findStudent(id);
        if (s == null)
        {
            return false;
        }
        students.remove(s);
        return true;
    }   
}
