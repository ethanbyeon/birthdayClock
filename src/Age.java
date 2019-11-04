import java.time.*;
import java.time.temporal.ChronoUnit;

public class Age {
	
	private int years;
	private int months;
	private int days;
	private LocalDateTime now;
	
	long diffHours;
	long diffMins;
	long diffSecs;
	long diffMillis;
	long diffNanos;
	
	public Age(Student s) {
		years = s.getYear();
		months = s.getMonthOfYear();
		days = s.getDayOfMonth();
	}
	
	public int getYears() {
		return this.years;
	}
	
	public int getMonths() {
		return this.months;
	}
	
	public int getDays() {
		return this.days;
	}
	
	//Calculates Student's Age in Years, Months, and Days
	public String calculateAge(Student s) {
		
		long diffYears;
		long diffMonths;
		long diffWeeks;
		long diffDays;
		
		LocalDateTime bday = LocalDateTime.of(s.getYear(), s.getMonthOfYear(), s.getDayOfMonth(), 0, 0);
		now = LocalDateTime.now();
		
		diffYears = ChronoUnit.YEARS.between(bday, now);
		diffMonths = ChronoUnit.MONTHS.between(bday, now);
		diffWeeks = ChronoUnit.WEEKS.between(bday, now);
		diffDays = ChronoUnit.DAYS.between(bday, now);
		
		return diffYears + " Years, " + diffMonths + " Months, " + diffWeeks + " Weeks " + diffDays + " Days";
	}
	
	//Calculates Student's Age in Hours, Minutes, Seconds, etc...
	public String calculateAgeTime(Student s) {
		
		LocalDateTime bday = LocalDateTime.of(s.getYear(), s.getMonthOfYear(), s.getDayOfMonth(), 0, 0);
		now = LocalDateTime.now();
			
		diffHours = ChronoUnit.HOURS.between(bday, now);
		diffMins = ChronoUnit.MINUTES.between(bday, now);
		diffSecs = ChronoUnit.SECONDS.between(bday, now);
		diffMillis = ChronoUnit.MILLIS.between(bday, now);
		diffNanos = ChronoUnit.NANOS.between(bday, now);
			
		return "" + diffHours + "h: " + diffMins + "min: " + diffSecs + "s: " + diffMillis + "ms: " + diffNanos + "ns";
	}
	
	public String toString() {
		return years + " Years, " + months + " Months, " + days + " Days";
	}
}