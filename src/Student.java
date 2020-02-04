import java.time.*;

public class Student {  

    private String name;
	public LocalDate dob;
	private String period;
		
	public Student() {

		name = "FIRST LAST";
		dob = LocalDate.now();
		period = "0";

    }
        
	public Student(String name, String dob, String period) {

		this.name = name;
		this.dob = LocalDate.parse(dob);
		this.period = period;
		
    }

    //STUDENT DATA  
	public String getName() {
        return name;
    }

    public int getYear() {    
		return dob.getYear();
    }
	
	//1-12 
	public int getMonthOfYear() {
		return dob.getMonthValue();
	}
	
	//JAN. - DEC.
    public Month getMonth() {
        return dob.getMonth();
    }
	
	//1-365
	public int getDayOfYear() {
		return dob.getDayOfYear();
	}
	
	//1-31
	public int getDayOfMonth(){
		return dob.getDayOfMonth();
	}
	
	//MON. - FRI.
	public DayOfWeek getDayOfWeek() {
		DayOfWeek dow = dob.getDayOfWeek();
		return dow;
    }
	
	public LocalDate getDOB() {
		return dob;
	}
	
	public String getPeriod() {
		return period;
	}
	
    //TEST DATA
    public String toString() {
		return "Student: " + name + " DOB: " + dob + " PER: " + period + " |";
	}
	
}
