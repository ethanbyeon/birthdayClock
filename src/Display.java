import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;

import java.io.File;

public class Display extends JFrame {

	private static final long serialVersionUID = 1L;

	ArrayList<Student> data;
	
	JFrame frame;
	JFrame bkg;
	
	// TEXT OBJECTS
	JLabel heading;
	JLabel bdays;
	JLabel samebday;
	JLabel now;
	JLabel next;
	JLabel countDown;
	JLabel date;
	JLabel military;
	
	// BACKGROUND IMAGE
	File folder = new File("res/pics");
	File[] pictures = folder.listFiles();
	JLabel pic;
	ImageIcon p;
	
	// BACKGROUND
	File tv = new File("res/simpsonstv.png");
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	
	// FONTS
	Font h = new Font("Courier", Font.BOLD, 70);	//HAPPY BDAY
	Font c = new Font("Courier", Font.PLAIN, 100);	//NAMES
	Font t = new Font("Courier", Font.BOLD, 110);	//TIME
	Font d = new Font("Courier", Font.BOLD, 50);	//DUE DATE

	// TIMERS
	Timer timer;
	Timer timer2;
	
	// COUNTER VARIABLES FOR TIMER
	int count = 1;
	int picx = 0;
	
	// REFRESH OBJECTS ON FRAME
	private ActionListener action = new ActionListener() {
		
		public void actionPerformed(ActionEvent ae) {

			msg();
			
			remove(heading);
			remove(bdays);
			remove(samebday);
			remove(now);
			remove(next);
			remove(countDown);
			remove(date);
			remove(military);
			
			revalidate();
			repaint();
			
			count++;
		}
	};
	
	//SLIDESHOW OF IMAGES
	private ActionListener action2 = new ActionListener() {
			
		public void actionPerformed(ActionEvent ae) {
			
			if(picx == pictures.length) picx = 0; 
			
			if(count <= 2) {
				
				p = new ImageIcon(new ImageIcon("res/static.gif").getImage().getScaledInstance(1200, 660, Image.SCALE_DEFAULT));
				pic.setBounds(330, 175, p.getIconWidth(), p.getIconHeight());
				pic.setIcon(p);
				
			}else if(count == 3) {
				
				p = new ImageIcon(new ImageIcon(pictures[picx].getPath()).getImage().getScaledInstance(1200, 660, Image.SCALE_DEFAULT));
				pic.setBounds(330, 175, p.getIconWidth(), p.getIconHeight());
				pic.setIcon(p);
				
			}else if(count == 18) {
				count = 1;
				picx++;
			}
			
			remove(pic);
			
			revalidate();
			repaint();
		}
	};
	
	public void msg() {
		new Message(this);
	}
	
	//DISPLAYS GUI
	public void createAndDisplayGUI(ArrayList<Student> s) {
		
		// INPUT
		data = new ArrayList<Student>();
		for (Student student : s) {
			data.add(student);
		}
		
		// SET UP
		frame = new JFrame("HAPPY BIRTHDAY!");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setUndecorated(true);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
		frame.setContentPane(new JLabel(new ImageIcon(((new ImageIcon(tv.getPath())).getImage()).getScaledInstance((int) size.getWidth(), (int) size.getHeight(), Image.SCALE_SMOOTH))));
		
		// EXIT BUTTON
		JButton exit = new JButton("EXIT");
		exit.setBounds(frame.getWidth() - 90, frame.getHeight() - 50, 90, 50);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.add(exit);

		// HAPPY BIRTHDAY!
		heading = new JLabel("Happy Birthday!");
		heading.setBounds(350, 120, 1000, 170);
		heading.setFont(h);
		heading.setForeground(Color.RED);
		frame.add(heading);

		// BDAY NAMES
		bdays = new JLabel("JOE SMITH");
		bdays.setBounds(350, 200, 5000, 170);
		bdays.setFont(c);
		bdays.setForeground(Color.PINK);
		frame.add(bdays);
		
		// SAME BDAY
		samebday = new JLabel("");
		samebday.setBounds(350, 280, 5000, 170);
		samebday.setFont(c);
		samebday.setForeground(Color.PINK);
		frame.add(samebday);

		// BDAY TODAY
		now = new JLabel("");
		now.setBounds(350, 600, 800, 200);
		now.setFont(h);
		now.setForeground(Color.GREEN);
		frame.add(now);

		// NEXT BDAY DATE
		next = new JLabel("");
		next.setBounds(350, 600, 800, 200);
		next.setFont(d);
		next.setForeground(Color.RED);
		frame.add(next);

		// TIME UNTIL NEXT BDAY
		countDown = new JLabel("");
		countDown.setBounds(350, 700, 1500, 200);
		countDown.setFont(d);
		countDown.setForeground(Color.GREEN);
		frame.add(countDown);

		// TODAY'S DATE
		date = new JLabel("TODAY'S DATE");
		date.setBounds(590, 300, 2000, 300);
		date.setFont(t);
		date.setForeground(Color.ORANGE);
		frame.add(date);

		// CURRENT TIME
		military = new JLabel("CURRENT TIME");
		military.setBounds(660, 450, 1000, 300);
		military.setFont(t);
		military.setForeground(Color.ORANGE);
		frame.add(military);
		
		// BACKGROUND IMAGES
		pic = new JLabel();
		frame.add(pic);
		
		timer = new Timer(1000, action);
		timer2 = new Timer(1000, action2);
		
		timer.start();
		timer2.start();
	}
}
