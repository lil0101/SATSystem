import java.util.Vector;

public class TeachingAssistant imlements comparable {

	private String name;
	private int salary; // Accumulated salary
	private static final double BASE_SALARY_PER_SECOND = 3.0; // Base salary rate per second
	private static final double SECONDS_TO_HOURS = 1.0 / 3600.0; // Conversion factor from seconds to hours
	private Vector<Test> testsFromProctors;


	public TeachingAssistant(String name) {
		this.name = name;
		this.salary = 0;
		this.testsFromProctors= testsFromProctors;
	}

	public void checkExam(Student student, int[] answers, double errorProbability) {
		// Simulate checking process
		int correctAnswers = 0;
		for (int i = 0; i < answers.length; i++) {
			double random = Math.random();
			if (random > errorProbability) { // Answer considered correct
				if (answers[i] == 1) {
					correctAnswers++;
				}
			} else { // Answer considered incorrect
				if (answers[i] == 0) {
					correctAnswers++;
				}
			}
		}

		// Update student's exam score
		student.setExamScore(correctAnswers * 5);

		// Calculate time spent and update salary
		int timeSpentInSeconds = (int) (1500 + Math.random() * 1000); // Random time between 1.5 to 2.5 seconds
		double earnedSalary = timeSpentInSeconds * BASE_SALARY_PER_SECOND * SECONDS_TO_HOURS;
		salary += earnedSalary;

		// Print checking information
		System.out.println("TA " + name + " checked exam of " + student.getName() + " in " + timeSpentInSeconds + " seconds.");
		System.out.println("Earned salary: " + earnedSalary + " NIS");
	}

	public int getSalary() {
		return salary;
	}

	public int compareTo(TeachingAssistant other) {
		if (this.testsFromProctors.size()>other.testsFromProctors.size())
			return 1;
		if (this.testsFromProctors.size()<other.testsFromProctors.size())
			return -1;
		return 0;

	} 
}
