import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class AdminReports extends JFrame {

	private JPanel contentPane;
	public JButton btnReturn;
	public JButton btnViewAllCourses;
	private JButton btnSortCourses;
	private JButton btnViewAStudents;
	private JButton btnViewFullCourses;
	private JButton btnWriteFull;
	private JButton btnViewRoster;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminReports frame = new AdminReports();
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
	public AdminReports() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReturn = new JButton("Return to main menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(460, 16, 180, 29);
		contentPane.add(btnReturn);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setForeground(Color.WHITE);
		lblReports.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblReports.setBounds(238, 44, 180, 79);
		contentPane.add(lblReports);
		
		JLabel label_1 = new JLabel("Please select an option from the menu below.");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label_1.setBounds(44, 135, 596, 45);
		contentPane.add(label_1);
		
		btnWriteFull = new JButton("Write full courses to a file");
		btnWriteFull.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnWriteFull.setBounds(24, 381, 209, 79);
		contentPane.add(btnWriteFull);
		
		btnViewRoster = new JButton("View students in a course");
		btnViewRoster.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnViewRoster.setBounds(234, 381, 209, 79);
		contentPane.add(btnViewRoster);
		
		btnSortCourses = new JButton("Sort courses");
		btnSortCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSortCourses.setBounds(444, 381, 209, 79);
		contentPane.add(btnSortCourses);
		
		btnViewAllCourses = new JButton("View all courses");
		btnViewAllCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnViewAllCourses.setBounds(104, 290, 209, 79);
		contentPane.add(btnViewAllCourses);
		
		btnViewFullCourses = new JButton("View full courses");
		btnViewFullCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnViewFullCourses.setBounds(314, 290, 209, 79);
		contentPane.add(btnViewFullCourses);
		
		btnViewAStudents = new JButton("View a student's registered courses");
		btnViewAStudents.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnViewAStudents.setBounds(169, 202, 274, 79);
		contentPane.add(btnViewAStudents);
	}

	/**
	 * @return the btnSortCourses
	 */
	public JButton getBtnSortCourses() {
		return btnSortCourses;
	}
	
	/**
	 * @return the btnViewAStudents
	 */
	public JButton getBtnViewAStudents() {
		return btnViewAStudents;
	}
	
	/**
	 * @return the btnViewFullCourses
	 */
	public JButton getBtnViewFullCourses() {
		return btnViewFullCourses;
	}
	
	/**
	 * @return the btnWriteFull
	 */
	public JButton getBtnWriteFull() {
		return btnWriteFull;
	}
	
	/**
	 * @return the btnViewRoster
	 */
	public JButton getBtnViewRoster() {
		return btnViewRoster;
	}
	
}
