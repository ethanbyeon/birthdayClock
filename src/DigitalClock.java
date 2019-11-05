import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalClock extends JFrame {
	
	private JFrame frame;
	public JLabel pic;
	private ClockThread ct;
	
	public ArrayList<Student> data;
	public JLabel bdays;
	public JLabel next;
	public JLabel countDown;
	public JLabel date;
	public JLabel military;
	
	private ArrayList<ImageIcon> pics = new ArrayList<ImageIcon>();
	private int counter = 0;
	
	public DigitalClock(ArrayList<Student> s) {
		frame = new JFrame("Birthday Clock");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		frame.setBackground(Color.BLACK);
		
		
		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new JLabel(pics.get(counter)));
				counter++;
				if(counter >= pics.size()) {
					counter = 0;
				}
			}
		});
		

		Font f = new Font("Arial",Font.BOLD,90);
		Font t = new Font("AppleGothic",Font.BOLD,125);
		
		bdays = new JLabel("JOE SMITH");
		bdays.setBounds(0,260,5000,170);
		bdays.setFont(t);
		bdays.setForeground(Color.BLUE);
		frame.add(bdays);
		
		next = new JLabel("NEXT BDAY DATE");
		next.setBounds(0,350,800,200);
		next.setFont(f);
		next.setForeground(Color.RED);
		frame.add(next);
		
		countDown = new JLabel("TIME UNTIL NEXT BDAY");
		countDown.setBounds(0,440,1500,200);
		countDown.setFont(f);
		countDown.setForeground(Color.RED);
		frame.add(countDown);
		
		date = new JLabel("TODAY'S DATE");
		date.setBounds(530,500,700,300);
		date.setFont(f);
		date.setForeground(Color.BLACK);
		frame.add(date);
		
		military = new JLabel("CURRENT TIME");
		military.setBounds(580,600,700,300);
		military.setFont(f);
		military.setForeground(Color.BLACK);
		frame.add(military);
		
		data = new ArrayList<Student>();
		for(int i = 0; i < s.size(); i++) {
			data.add(s.get(i));
		}
		
		//frame.setContentPane(new Jlabel(new ImageIcon()));
		
		frame.pack();
		timer.start();
		ct = new ClockThread(this);
		frame.setVisible(true);
	}
}