package termproject6;

/**
 * Represents an undergraduate student and identifies
 * the student type.
 */
public class UndergraduateStudent extends Student
{
    public UndergraduateStudent(String n, int i)
    {
        super(n, i);
    }
    @Override
    public String getStudentType()
    {
        return "Undergraduate";
    }
}
