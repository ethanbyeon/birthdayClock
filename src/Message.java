import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message extends Thread {
	
	private Birthday bkg;
	private LocalDate today;
	private ArrayList<Student> sameDOB;
	
	public Message(Birthday c) {
		bkg = c;
		start();
	}
	
	public void run() {

		while(true) {
			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter formatCurrent = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter formatMilitary = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatDateTime = currentTime.format(formatCurrent);
			String formatMilitaryTime = currentTime.format(formatMilitary);
			
			today = LocalDate.now();
			sameDOB = new ArrayList<Student>();
			
			checkDay(bkg.data);
			
			bkg.date.setText(formatDateTime);
			bkg.military.setText(formatMilitaryTime);
		}

	}
	
	private void checkDay(ArrayList<Student> s) {

		ArrayList<Student> nextDOB = new ArrayList<Student>();
		for(Student student: s) {
			if(student.getMonthOfYear() == today.getMonthValue() && student.getDayOfMonth() == today.getDayOfMonth()) sameDOB.add(student);
			if(student.getDayOfYear() > today.getDayOfYear()) nextDOB.add(student);
		}
		
		Student temp = nextDOB.get(0);
		if(nextDOB.size() > 1) {	
			for(int i = 1; i < nextDOB.size(); i++) {
				if(nextDOB.get(i).getDayOfYear() < temp.getDayOfYear()) temp = nextDOB.get(i);
			}
		}
		
		if(sameDOB.size() == 1) {
			bkg.bdays.setText(sameDOB.get(0).getName());
			bkg.now.setText("TODAY");
		}else if(sameDOB.size() > 1) {
			sameDay();
		}else displayNext(temp, temp.getName());
	}
	
	private void sameDay() {

		String names = "";
		for(int i = 0; i < sameDOB.size(); i++) {
			if(i < sameDOB.size() - 1) names += sameDOB.get(i).getName() + ", ";
			else names += sameDOB.get(i).getName();
		}
		bkg.bdays.setText(names);
	}
	
	private void displayNext(Student s, String name) {

		long weeksBetween = 0L;
		long daysBetween = 0L;
		String until = "";
		
		LocalDate compare = LocalDate.of(today.getYear(), s.getMonthOfYear(), s.getDayOfMonth());
		
		weeksBetween = ChronoUnit.WEEKS.between(LocalDate.now(), compare);
		daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), compare);
		
		if(weeksBetween == 0) {
			if(daysBetween == 1) {
				until = weeksBetween + " Weeks " + daysBetween + " Day"; 
			}else if(daysBetween > 1) {
				until = weeksBetween + " Weeks " + daysBetween + " Days"; 
			}
		}else if(weeksBetween == 1) {
			if(daysBetween == 1) {
				until = weeksBetween + " Week " + daysBetween + " Day"; 
			}else if(daysBetween > 1) {
				until = weeksBetween + " Week " + daysBetween + " Days"; 
			}	
		}else if(weeksBetween > 1) {
			if(daysBetween == 1) {
				until = weeksBetween + " Weeks " + daysBetween + " Day"; 
			}else if(daysBetween > 1) {
				until = weeksBetween + " Weeks " + daysBetween + " Days"; 
			}
		}
			
		bkg.bdays.setText(name);
		bkg.next.setText("On: " + compare);
		bkg.countDown.setText("In: " + until);
	}
	
}