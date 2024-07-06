import java.util.Vector;

public class WaitingListStudent {
	private Vector<Student> finishTest;
	
	public WaitingListStudent()
	{
		this.finishTest= new Vector<Student>();
	}
	
	public void addFinishStudent(Student S)
	{
		finishTest.add(S);
	}

	
	public static void main(String[] args) {
	

	}

}
