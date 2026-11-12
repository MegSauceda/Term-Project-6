package termproject6;

/**
* Stores the name of the subject and student's grade
* for that subject. 
 */
public class Subject
{
    private String subjectName;
    private double grade;

    public Subject(String s, double g)
    {
        subjectName = s;
        if (g < 0 || g > 100)
        {
            throw new IllegalArgumentException
                    ("Grade must be between 0 and 100.");
        }
        grade = g;
    }
    public void setGrade(double g)
    {
        if (g < 0 || g > 100)
        {
            throw new IllegalArgumentException
                    ("Grade must be between 0 and 100.");
        }
        grade = g;
    }
    public String getSubjectName()
    {
        return subjectName;
    }
    public double getGrade()
    {
        return grade;
    }
}