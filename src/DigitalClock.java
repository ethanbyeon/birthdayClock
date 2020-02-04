import java.util.*;
import java.awt.*;
import javax.swing.*;

public class DigitalClock extends JFrame {
	
	private JFrame frame;
	public JLabel pic;
	private ClockThread ct;
	
	public ArrayList<Student> data;
	public JLabel heading;
	public JLabel bdays;
	public JLabel now;
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
		
		frame.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("bobross.jpg"))));
		frame.setBackground(Color.BLACK);

		Font f = new Font("Arial",Font.BOLD,80);
		Font d = new Font("Arial",Font.BOLD,60);
		Font t = new Font("AppleGothic",Font.BOLD,125);
		
		//HEADING
		heading = new JLabel("Happy Birthday!");
		heading.setBounds(0,300,1000,170);
		heading.setFont(f);
		heading.setForeground(Color.RED);
		frame.add(heading);
		
		//BDAY NAMES
		bdays = new JLabel("JOE SMITH");
		bdays.setBounds(0,420,5000,170);
		bdays.setFont(t);
		bdays.setForeground(Color.BLUE);
		frame.add(bdays);
		
		//BDAY TODAY
		now = new JLabel("");
		now.setBounds(0,530,800,200);
		now.setFont(f);
		now.setForeground(Color.GREEN);
		frame.add(now);
		
		//TIME UNTIL NEXT BDAY
		countDown = new JLabel("");
		countDown.setBounds(0,510,1500,200);
		countDown.setFont(d);
		countDown.setForeground(Color.RED);
		frame.add(countDown);
		
		//NEXT BDAY DATE
		next = new JLabel("");
		next.setBounds(0,580,800,200);
		next.setFont(d);
		next.setForeground(Color.RED);
		frame.add(next);
		
		//TODAY'S DATE
		date = new JLabel("TODAY'S DATE");
		date.setBounds(865,70,700,300);
		date.setFont(f);
		date.setForeground(Color.RED);
		frame.add(date);
		
		//CURRENT TIME
		military = new JLabel("CURRENT TIME");
		military.setBounds(910,160,700,300);
		military.setFont(f);
		military.setForeground(Color.BLUE);
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
