import java.util.*;

import javax.swing.SwingUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.*;

public class starter {
	
	static Scanner in;
	static ArrayList<Student> students;
	static Scanner excel;
	
    public static void main(String args[]) {
		
		try {
			
			URL url = new URL("http://drneato.com/Bday/Data.txt");
			in = new Scanner(url.openStream());
			
			collect();
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new Display().createAndDisplayGUI(students);
				}
			});
			
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
		boolean valid = false;
		
		for(int i = 0; i < data.size(); i+=7) {

			String name = "";
			String per = "";
			
			for(int j = 0; j <= 7 && count < data.size(); j++) {
				
				String info = data.get(count);
				
				if(j == 0 && checkStudent(info.toLowerCase())) {
					name = info;
					valid = true;
				}
				
				if(j == 1 && valid) per = info;
				
				if(j == 2 && info.length() <= 10 && valid) {
					students.add(new Student(name, info, per));
					valid = false;
				}				

				count++;
			}
		}
		
	}
	
	private static boolean checkStudent(String student) {
		
		try {
			
			excel = new Scanner(new File("INSERT CSV FILE HERE"));
			
			if(verify(student)) return true;
			
			excel.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private static boolean verify(String student) {
		
		excel.nextLine();
		
		while(excel.hasNext()) {
			
			String row = excel.nextLine();
			String[] rowcell = row.split(",");
			
			String nameupper = rowcell[2] + " " + rowcell[1];
			String name = nameupper.toLowerCase();
			
			if(name.equals(student)) return true;
			
		}
		
		return false;
	}
}
