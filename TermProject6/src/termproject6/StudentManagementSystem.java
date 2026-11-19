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

    //Creates an empty system
    public StudentManagementSystem()
    {
        students = new ArrayList<Student>();
    }

    // Returns the list of students
    public ArrayList<Student> getStudents()
    {
        return students;
    }

    // Replaces the list of students
    public void setStudents(ArrayList<Student> list)
    {
        students = list;
    }
     //Searches for a student by ID.

    public Student findStudent(int id)
    {
        Student found = null;
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getStudentID() == id)
            {
                found = students.get(i);
            }
        }
        return found;
    }

    //Adds a student if the ID is not already used.
   
    public boolean addStudent(Student s)
    {
        boolean added = false;
        if (findStudent(s.getStudentID()) == null)
        {
            students.add(s);
            added = true;
        }
        return added;
    }

     //Removes a student by ID.
    
    public boolean removeStudent(int id)
    {
        boolean removed = false;
        Student s = findStudent(id);
        if (s != null)
        {
            students.remove(s);
            removed = true;
        }
        return removed;
    }
}
