package termproject6;
import java.util.ArrayList;

public class Student
{
    private String name;
    private int studentID;
    private ArrayList<Subject> subjects;

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
    public void addSubject(Subject s)
    {
    subjects.add(s);
    }
    public void removeSubject(Subject s)
    {
    subjects.remove(s);
    }
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



