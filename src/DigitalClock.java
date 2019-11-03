import java.util.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class DigitalClock extends JFrame {
	
	private JFrame frame;
	private JLabel bkg;
	private JLabel title;
	private ClockThread ct;
	
	public ArrayList<Student> data;
	public JLabel bdays;
	public JLabel next;
	public JLabel countDown;
	public JLabel date;
	public JLabel military;
	
	public DigitalClock(ArrayList<Student> s) {
		frame = new JFrame("Birthday Clock");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		frame.setBackground(Color.BLACK);
		frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ethan\\OneDrive\\Desktop\\BDayRUS\\src\\img\\bobross.jpg")));
		
		Font f = new Font("Arial",Font.BOLD,100);
		Font t = new Font("Arial",Font.BOLD,125);
		Font b = new Font("Arial",Font.BOLD,150);
		
		title = new JLabel("Happy Birthday!");
		title.setBounds(0,0,1500,170);
		title.setFont(t);
		frame.add(title);
		
		bdays = new JLabel("JOE SMITH");
		bdays.setBounds(0,150,5000,170);
		bdays.setFont(t);
		frame.add(bdays);
		
		next = new JLabel("NEXT BDAY DATE");
		next.setBounds(350,350,800,200);
		next.setFont(f);
		frame.add(next);
		
		countDown = new JLabel("TIME UNTIL NEXT BDAY");
		countDown.setBounds(250,450,1500,200);
		countDown.setFont(f);
		frame.add(countDown);
		
		date = new JLabel("TODAY'S DATE");
		date.setBounds(480,500,700,300);
		date.setFont(f);
		frame.add(date);
		
		military = new JLabel("CURRENT TIME");
		military.setBounds(537,600,700,300);
		military.setFont(f);
		frame.add(military);
		
		data = new ArrayList<Student>();
		for(int i = 0; i < s.size(); i++) {
			data.add(s.get(i));
		}
		
		frame.pack();
		ct = new ClockThread(this);
		frame.setVisible(true);
	}
}