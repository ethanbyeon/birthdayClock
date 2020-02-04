import java.util.Comparator;

public class AgeSorter implements Comparator<Student> {

		public int compare(Student o1, Student o2) {
			return o1.getDOB().compareTo(o2.getDOB());
		}
		
}