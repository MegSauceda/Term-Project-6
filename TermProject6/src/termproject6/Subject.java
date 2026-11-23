package termproject6;

/**
* Stores the name of the subject and student's grade
* for that subject. 
 */
public class Subject
{
    private String subjectName;
    private double grade;

/**
 * Creates a Subject object with a name and grade.
 * @param s the Subject name
 * @param g the grade in that subject
 */
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
/** Sets the grade for the subject.
 * Must be between 0 and 100
 * @param g the grade to set
 */
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