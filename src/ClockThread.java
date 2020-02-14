import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockThread extends Thread {
	
	private DigitalClock clock;
	private LocalDate today;
	private ArrayList<Student> sameDay;
	
	public ClockThread(DigitalClock clock) {
		this.clock = clock;
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
			sameDay = new ArrayList<Student>();
			
			checkDay(clock.data);
			
			clock.date.setText(formatDateTime);
			clock.military.setText(formatMilitaryTime);
		}

	}
	
	private void checkDay(ArrayList<Student> s) {

		ArrayList<Student> nextBday = new ArrayList<Student>();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).getMonthOfYear() == today.getMonthValue() && s.get(i).getDayOfMonth() == today.getDayOfMonth()) sameDay.add(s.get(i));
			if(s.get(i).getDayOfYear() > today.getDayOfYear()) nextBday.add(s.get(i));
		}
		
		Student temp = nextBday.get(0);
		if(nextBday.size() > 1) {	
			for(int i = 1; i < nextBday.size(); i++) {
				if(nextBday.get(i).getDayOfYear() < temp.getDayOfYear()){
					temp = nextBday.get(i);
				}
			}
		}
		
		if(sameDay.size() == 1) {
			clock.bdays.setText(sameDay.get(0).getName());
			clock.now.setText("TODAY");
		}else if(sameDay.size() > 1) {
			sameBday();
		}else displayNextBday(temp, temp.getName());
	}
	
	private void sameBday() {

		String names = "";
		for(int i = 0; i < sameDay.size(); i++) {
			if(i < sameDay.size() - 1) names += sameDay.get(i).getName() + ", ";
			else names += sameDay.get(i).getName();
		}
		clock.bdays.setText(names);
	}
	
	private void displayNextBday(Student s, String name) {

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
			
		clock.bdays.setText(name);
		clock.next.setText("On: " + compare);
		clock.countDown.setText("In: " + until);
	}
	
}