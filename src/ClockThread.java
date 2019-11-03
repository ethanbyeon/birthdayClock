import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ClockThread extends Thread {
	
	private DigitalClock dc;
	private LocalDate today;
	private ArrayList<Student> sameDay;
	
	public ClockThread(DigitalClock dc) {
		this.dc = dc;
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
			
			checkBday(dc.data);
			
			dc.date.setText(formatDateTime);
			dc.military.setText(formatMilitaryTime);
		}
	}
	
	private void sameBday() {
		String names = "";
		for(int i = 0; i < sameDay.size(); i++){
			if(i < sameDay.size() - 1){
				names += sameDay.get(i).getName() + ", ";
			}else {
				names += sameDay.get(i).getName();
			}
		}
		dc.bdays.setText(names);
	}
	
	private void checkBday(ArrayList<Student> s) {
		ArrayList<Student> nextBday = new ArrayList<Student>();
		for(int i = 0; i < s.size(); i++){
			if(s.get(i).getDayOfYear() == today.getDayOfYear()){
				sameDay.add(s.get(i));
			}
			if(s.get(i).getDayOfYear() > today.getDayOfYear()){
				nextBday.add(s.get(i));
			}
		}
		
		Student temp = nextBday.get(0);
		for(int i = 1; i < nextBday.size(); i++){
			if(nextBday.get(i).getDayOfYear() < temp.getDayOfYear()){
				temp = nextBday.get(i);
			}
		}
		
		if(sameDay.size() > 1) {
			sameBday();
		}else {
			displayNextBday(temp, temp.getName());
		}	
	}
	
	//fix date between and set it to same year but different date
	private void displayNextBday(Student s, String name) {
		long weeksBetween = 0L;
		long daysBetween = 0L;
		String until = "";
		
		LocalDate compare = LocalDate.of(today.getYear(), s.getMonthOfYear(), s.getDayOfMonth());
		
		weeksBetween = ChronoUnit.WEEKS.between(LocalDate.now(), compare);
		daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), compare);
		until = weeksBetween + " Week(s) " + daysBetween + " Day(s)"; 
		
		dc.bdays.setText(name);
		dc.next.setText("On: " + compare);
		dc.countDown.setText("In: " + until);
	}
}