package termproject6;
import java.util.ArrayList;
/**
 * Stores the identifying information for a student
 * along with the student's subjects
 */
public class Student
{
    private String name;
    private int studentID;
    private ArrayList<Subject> subjects;
    
/* Creates a Student object. */
    public Student (String n, int i)
    {
	name = n;
	studentID = i;
	subjects = new ArrayList<Subject>();
    }
    public void setName(String n)
    {
	name = n;
    }
    public void setStudentID(int i)
    {
	studentID = i;
    }

    public String getName()
    {
	return name;
    }
    public int getStudentID()
    {
	return studentID;
    }
    public ArrayList<Subject> getSubjects()
    {
	return subjects;
    }
    public String getStudentType() 
    {
	return "Student";
    }
/**
 * Adds a subject for the student.
 * @param s the subject being added.
 */
    public void addSubject(Subject s)
    {
    subjects.add(s);
    }
/**
 * Removes a subject from the student's list. 
 * @param s the subject being removed.
 */
    public void removeSubject(Subject s)
    {
    subjects.remove(s);
    }
/**
 * Calculates the average grade for all subjects.
 * @return the student's average grade
 */
    public double calculateAverage() 
    {
        double total = 0;
        for (Subject s : subjects)
        {
            total += s.getGrade();
        }
        if (subjects.size() == 0)
        {
            return 0;
        }
        return total / subjects.size();
    }
}



