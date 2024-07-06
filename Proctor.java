
import java.util.Vector;

public class Proctor implements Runnable {
	private String name;
	private int age;
	private SATSystem SATSystem;
	private static int checkedTests;	
	private static int numOfStudents; 

	public Proctor(String name, int age,SATSystem SATSystem) {
		this.name = name;
		this.age = age;
		this.SATSystem=SATSystem;
		this.checkedTests=0;

	}

	public void run()
	{
		while(checkedTests<numOfStudents)
		{
			double num=(Math.random()*2)+1;
			try {
				Thread.sleep((long)num*1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			Student S = SATSystem.getStudent();
			SATSystem.
			SATSystem.getFinishTestStudents().remove(0);
			Vector<Student> vector = new Vector<Student>();
			vector.add(0);
		}


	}







	public static void main(String[] args) {


	}

}
