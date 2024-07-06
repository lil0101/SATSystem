import java.util.Date; 

public class Test {

	private String idNumber;
	private String date;
	private boolean[] answers= new boolean [20] ;  // True for correct, false for incorrect
	private int grade;
	private int gradeAfterFactor;
	private int finalGrade;
	private int status;  // Signed by proctor, checked, approved by lecturer, factor given

	public Test(String idNumber, String date, boolean[] answers) {
		this.idNumber = idNumber;
		this.date = date;
		this.answers = answers;
		this.grade = calculateGrade();
		this.gradeAfterFactor = 0;
		this.finalGrade = 0;
		this.status = 0;
	}
	
	public Test(String idNumber, String date)
	{
		this.idNumber=idNumber;
		this.date= date;
		this.answers = new boolean [20];
		this.grade = 0;
		this.gradeAfterFactor = 0;
		this.finalGrade = 0;
		this.status = 0;
	}

	// Method to calculate raw score based on answers
	private int calculateGrade() {
		int garde = 0;
		for (int i=0; i<this.answers.length;i++) {
			if (this.answers[i]==true) {
				garde += 5;  // Each correct answer gives 5 points
			}
		}
		return garde;
	}

	// Getters and setters
	public String getIdNumber() {
		return idNumber;
	}

	public Date getDate() {
		return date;
	}

	public boolean[] getAnswers() {
		return answers;
	}

	public int getGrade() {
		return grade;
	}

	public int getGradeAfterFactor() {
		return gradeAfterFactor;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public void SetAnswer(boolean ans, int i)
	{
		this.answers[i]=ans;
	}



}

