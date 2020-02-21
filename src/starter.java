import java.util.*;
import java.net.*;

public class starter {
	
	static Scanner in;
	static ArrayList<Student> students;
	static Birthday joe;
	
    public static void main(String args[]) {
		
		try {
			
			URL url = new URL("http://drneato.com/Bday/Data.txt");
			in = new Scanner(url.openStream());
			
			collect();
			
			joe = new Birthday(students);
			SlideShow image = new SlideShow();
			while(true) {
				joe.display();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	private static void collect() {
		
		students = new ArrayList<Student>();
		ArrayList<String> data = new ArrayList<String>();
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			data.add(line);
		}
		
		int count = 0;
		for(int i = 0; i < data.size(); i+=7) {

			String name = "";
			String per = "";

			for(int j = 0; j <= 7 && count < data.size(); j++) {
				String info = data.get(count);

				if(j == 0) name = info;
				if(j == 1) per = info;
				if(j == 2 && info.length() <= 10) students.add(new Student(name, info, per));

				count++;
			}
		}
	}
}