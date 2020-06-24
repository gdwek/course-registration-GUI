import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class StudentRegister extends JFrame {

	public static JPanel contentPane;
	private JButton btnReturn;
	private JButton btnRegister;
	static JScrollPane scrollPane;
	private  JList jlist;
	DefaultListModel list;
	private static JLabel lblFull;
	private static JLabel lblDouble;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegister frame = new StudentRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterInCourse = new JLabel("Register in a Course");
		lblRegisterInCourse.setForeground(Color.WHITE);
		lblRegisterInCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblRegisterInCourse.setBounds(105, 64, 479, 79);
		contentPane.add(lblRegisterInCourse);
		
		lblFull = new JLabel("Sorry, that course is full.");
		lblFull.setForeground(Color.RED);
		lblFull.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblFull.setBounds(68, 640, 500, 20);
		
		lblDouble = new JLabel("You are already registered in that course.");
		lblDouble.setForeground(Color.RED);
		lblDouble.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDouble.setBounds(68, 640, 500, 20);
		
		btnReturn = new JButton("Return to main menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnReturn.setBounds(419, 30, 210, 29);
		contentPane.add(btnReturn);
		
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegister.setBounds(421, 351, 104, 29);
		contentPane.add(btnRegister);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 176, 279, 434);
		contentPane.add(scrollPane);
		
		jlist = new JList();
		list = new DefaultListModel();
		for(int i= 0; i<User.CourseMenu.size(); i++) {
			list.add(i, User.CourseMenu.get(i).getCourseName() + " (Section: " + User.CourseMenu.get(i).getSection() + ")");
		}
		jlist.setModel(list);
		scrollPane.setViewportView(jlist);
		jlist.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(scrollPane);

	}
	

	/**
	 * @return the btnReturn
	 */
	public JButton getBtnReturn() {
		return btnReturn;
	}

	/**
	 * @return the jlist
	 */
	public JList getJlist() {
		return jlist;
	}
	
	/**
	 * @return the btnRegister
	 */
	public JButton getBtnRegister() {
		return btnRegister;
	}
	
	
	/**
	 * @return the lblFull
	 */
	public static JLabel getLblFull() {
		return lblFull;
	}

	/**
	 * @return the lblDouble
	 */
	public static JLabel getLblDouble() {
		return lblDouble;
	}

	
	
	
}
