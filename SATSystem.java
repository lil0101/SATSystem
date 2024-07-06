import java.util.Vector;
public class SATSystem {

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

