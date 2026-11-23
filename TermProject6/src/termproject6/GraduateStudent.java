package termproject6;

/**
 * Represents a graduate student and identifies
 * the student type.
 */
public class GraduateStudent extends Student
{
    public GraduateStudent(String n, int i)
    {
        super(n, i);
    }
    @Override
    public String getStudentType()
    {
        return "Graduate";
    }
}