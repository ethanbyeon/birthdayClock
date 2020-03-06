import java.util.*;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
	
	Display bday;
	LocalDate today;
	ArrayList<Student> sameDOB;
	
	public Message(Display c) {

		bday = c;
		today = LocalDate.now();
		sameDOB = new ArrayList<Student>();

		// TIME & DATE
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatCurrent = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatMilitary = DateTimeFormatter.ofPattern("HH:mm:ss");

		String formatDateTime = currentTime.format(formatCurrent);
		String formatMilitaryTime = currentTime.format(formatMilitary);

		checkDay(bday.data);

		// SETS BDAY OF STUDENT ONTO DISPLAY
		bday.date.setText(formatDateTime);
		bday.military.setText(formatMilitaryTime);
		
	}
	
	// CHECKS WHETHER STUDENT HAS THE SAME BDAY OR THE CLOSEST BDAY
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
			
			bday.bdays.setText(sameDOB.get(0).getName());
			bday.now.setText("TODAY");
			
		}else if(sameDOB.size() > 1) {
			sameDay();
		}else {
			displayNext(temp, temp.getName());
		}

	}
	
	// CHECKS FOR STUDENTS WITH THE SAME BDAY
	private void sameDay() {

//		String names = "";
//		for(int i = 0; i < sameDOB.size(); i++) {
//			
//			if(i < sameDOB.size() - 1) names += sameDOB.get(i).getName() + ", ";
//			else names += sameDOB.get(i).getName();
//			
//		}
//		
//		bday.bdays.setText(names);
		
		bday.samebday.setText(sameDOB.get(1).getName());

	}
	
	// CHECKS FOR THE NEXT BDAY
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
			
		bday.bdays.setText(name);
		bday.next.setText("On: " + compare);
		bday.countDown.setText("In: " + until);
	}
}
