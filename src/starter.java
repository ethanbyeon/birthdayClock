import java.util.*;
import java.io.*;

public class starter {
	
	static Scanner in;
	static PrintWriter out;
	
	static ArrayList<Student> students;
	
    public static void main(String args[]) {
		
		try {
			in = new Scanner(new File("Data.txt"));
			out = new PrintWriter(new File("Data.out"));
			
			init();
			
			out.close();
			in.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}	
    }
	
	private static void init() {
		
		students = new ArrayList<Student>();
		ArrayList<String> data = new ArrayList<String>();
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			data.add(line);
		}
		
		int count = 0;
		for(int i = 0; i < data.size(); i+=7){
			String name = "";
			String per = "";
			for(int j = 0; j <= 7 && count < data.size(); j++){
				
				if(j == 0){
					name = data.get(count);
				}
				
				if(j == 1){
					per = data.get(count);
				}
				
				if(j == 2){
					students.add(new Student(name, data.get(count), per));
				}
				count++;
			}
		}
		
		DigitalClock joe = new DigitalClock(students);
	}
}