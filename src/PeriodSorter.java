import java.util.Comparator;

public class PeriodSorter implements Comparator<Student> {

	public int compare(Student o1, Student o2) {
		return o1.getPeriod().compareTo(o2.getPeriod());
	}
	
}