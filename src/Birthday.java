import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Birthday extends JFrame {

	private static final long serialVersionUID = 1L;
	public JFrame frame;

	public ArrayList<Student> data;
	private JLabel heading;
	public JLabel bdays;
	public JLabel now;
	public JLabel next;
	public JLabel countDown;
	public JLabel date;
	public JLabel military;

	public Birthday() {

		// SET UP
		frame = new JFrame("Birthday Clock");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setUndecorated(true);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);

		// BACKGROUND
		//frame.setBackground(Color.BLACK);
		//frame.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("simpsonloop.gif"))));
		
		// EXIT BUTTON
		JButton exit = new JButton("EXIT");
		exit.setBounds(frame.getWidth() - 90, frame.getHeight() - 50, 90, 50);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.add(exit);

		// FONTS (add pixel font for time)
		Font h = new Font("Helvetica", Font.PLAIN, 80);
		Font c = new Font("Courier", Font.PLAIN, 125);
		Font t = new Font("Courier", Font.PLAIN, 150);
		Font d = new Font("Arial", Font.PLAIN, 60);

		// HEADING
		heading = new JLabel("Happy Birthday!");
		heading.setBounds(0, 0, 1000, 170);
		heading.setFont(h);
		heading.setForeground(Color.RED);
		frame.add(heading);

		// BDAY NAMES
		bdays = new JLabel("JOE SMITH");
		bdays.setBounds(0, 100, 5000, 170);
		bdays.setFont(c);
		bdays.setForeground(Color.PINK);
		frame.add(bdays);

		// BDAY TODAY
		now = new JLabel("");
		now.setBounds(0, 800, 800, 200);
		now.setFont(h);
		now.setForeground(Color.GREEN);
		frame.add(now);

		// NEXT BDAY DATE
		next = new JLabel("");
		next.setBounds(0, 800, 800, 200);
		next.setFont(d);
		next.setForeground(Color.RED);
		frame.add(next);

		// TIME UNTIL NEXT BDAY
		countDown = new JLabel("");
		countDown.setBounds(0, 900, 1500, 200);
		countDown.setFont(d);
		countDown.setForeground(Color.GREEN);
		frame.add(countDown);

		// TODAY'S DATE
		date = new JLabel("TODAY'S DATE");
		date.setBounds(570, 300, 2000, 300);
		date.setFont(t);
		date.setForeground(Color.ORANGE);
		frame.add(date);

		// CURRENT TIME
		military = new JLabel("CURRENT TIME");
		military.setBounds(670, 450, 1000, 300);
		military.setFont(t);
		military.setForeground(Color.ORANGE);
		frame.add(military);

	}

	public Birthday(ArrayList<Student> s) {

		this();

		// INPUT
		data = new ArrayList<Student>();
		for (Student student : s) {
			data.add(student);
		}
	}

	public void display() {
		new Message(this);
	}

}