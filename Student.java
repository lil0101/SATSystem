import java.util.Scanner;


public class Student implements Runnable{
	// Instance variables
	private String name;                // שם הסטודנט
	private String idNumber;            // תעודת זהות
	private int examClass;              // כיתת הבחינה (מספר שלם)
	private double probabilityCorrect;  // רמת הסתברות לענות נכון על שאלה בודדת P
	private int answerTime;             // קצב מענה על שאלות בשניות X
	private WaitingListStudent waitingListStudent ;

	public static Scanner sc = new Scanner (System.in);

	// Constructor
	public Student(String name, String idNumber, int examClass, double probabilityCorrect, int answerTime, WaitingListStudent waitingListStudent) {
		this.name = name;
		this.idNumber = idNumber;
		this.examClass = examClass;
		this.probabilityCorrect = probabilityCorrect;
		this.answerTime = answerTime;
		this.waitingListStudent=waitingListStudent;
	}

	public void run()
	{
		System.out.println("please enter date: 00.00.0000");
		String date=sc.next();
		Test currentTes = new Test(this.idNumber,date);
		for (int i=0;i<20;i++)
		{
			double num=Math.random();
			if(num<=probabilityCorrect)
			{
				currentTes.SetAnswer(true, i);
			}
			else
				currentTes.SetAnswer(false, i);
			try {
				Thread.sleep((long)answerTime*1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.waitingListStudent.addFinishStudent(this);
	}

	// Getters and setters (optional depending on your needs)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public int getExamClass() {
		return examClass;
	}

	public void setExamClass(int examClass) {
		this.examClass = examClass;
	}

	public double getProbabilityCorrect() {
		return probabilityCorrect;
	}

	public void setProbabilityCorrect(double probabilityCorrect) {
		this.probabilityCorrect = probabilityCorrect;
	}

	public int getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(int answerTime) {
		this.answerTime = answerTime;
	}


	// Example usage
	public static void main(String[] args) {
		// Creating instances of Student
		Student student1 = new Student("John Doe", "12345", 1, 0.75, 30);
		Student student2 = new Student("Jane Smith", "67890", 2, 0.85, 25);

		// Printing out the details of the students
		System.out.println(student1);
		System.out.println(student2);
	}


}

