import java.util.Vector;
public class SATSystem {

	private Vector<Student> newStudents;	
	private Vector<Student> finishTestStudents;
		private Vector<Test> tests;
		private Vector<Proctor> proctors;
		private Vector<TeachingAssistant> TeachingAssistants;
		private Vector<Test> testsFromProctors;


		public SATSystem()
		{
			this.setFinishTestStudents(finishTestStudents);
			this.tests=tests;
			this.proctors=proctors;
		}

	public void importStudents(String import_questions) throws IOException{
		String file = import_questions;
		BufferedReader reader = null;
		String line;
		try {
			reader = new BufferedReader(new FileReader(file));
			// Skip the header row
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] row = line.split("\t");
				String id = row[0];
				String name = row [1];
				int testRoom = Integer.parseInt(row[2]); 
				double questionAnswerTime = Double.parseDouble(row[3]);
				double probabilityCorrect = Double.parseDouble(row[4]);
				newStudents.addStudent(new Student(id,name,testRoom,questionAnswerTime,probabilityCorrect));
			}
		} catch (IOException e) {//make sure valid txt
			throw new RuntimeException(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void SATCheck()
	{
		
		
	}

		public synchronized Student getStudent()
		{
			while(getFinishTestStudents().isEmpty())			
			{
				try {
					wait();
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			int index=0;
			for (int i=0; i<tests.size();i++)
			{
				if(getFinishTestStudents().elementAt(0).getIdNumber()==tests.elementAt(i).getIdNumber());
				{
					index=i;
					break;
				}
			}	
			tests.elementAt(index).setStatus(1);
			return getFinishTestStudents().elementAt(0);
		}

		public static void main(String[] args) {


		}
		public Vector<Student> getFinishTestStudents() {
			return finishTestStudents;
		}
		public void setFinishTestStudents(Vector<Student> finishTestStudents) {
			this.finishTestStudents = finishTestStudents;
		}

	}

