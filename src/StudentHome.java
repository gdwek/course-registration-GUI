import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StudentHome extends JFrame {

	public JPanel contentPane;
	private JButton btnLogout;
	private JButton btnViewAll;
	private JButton btnViewMyCourses;
	private JButton btnRegisterInA;
	private JButton btnEditProfile;
	private JButton btnWithdrawFromA;
	private JButton btnViewOpenCourses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome();
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
	public StudentHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLogout.setBounds(512, 25, 117, 29);
		contentPane.add(btnLogout);
		
		btnViewAll = new JButton("View all courses");
		btnViewAll.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnViewAll.setBounds(64, 255, 167, 75);
		contentPane.add(btnViewAll);
		
		btnViewMyCourses = new JButton("View my courses");
		btnViewMyCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnViewMyCourses.setBounds(422, 255, 167, 75);
		contentPane.add(btnViewMyCourses);
		
		btnRegisterInA = new JButton("Register in a course");
		btnRegisterInA.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegisterInA.setBounds(243, 352, 167, 75);
		contentPane.add(btnRegisterInA);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnEditProfile.setBounds(64, 352, 167, 75);
		contentPane.add(btnEditProfile);
		
		btnWithdrawFromA = new JButton("Withdraw from a course");
		btnWithdrawFromA.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnWithdrawFromA.setBounds(422, 352, 167, 75);
		contentPane.add(btnWithdrawFromA);
		
		btnViewOpenCourses = new JButton("View open courses");
		btnViewOpenCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnViewOpenCourses.setBounds(243, 255, 167, 75);
		contentPane.add(btnViewOpenCourses);
	}

	/**
	 * @return the btnLogout
	 */
	public JButton getBtnLogout() {
		return btnLogout;
	}

	/**
	 * @return the btnViewAll
	 */
	public JButton getBtnViewAll() {
		return btnViewAll;
	}

	/**
	 * @return the btnViewMyCourses
	 */
	public JButton getBtnViewMyCourses() {
		return btnViewMyCourses;
	}

	/**
	 * @return the btnRegisterInA
	 */
	public JButton getBtnRegisterInA() {
		return btnRegisterInA;
	}


	/**
	 * @return the btnWithdrawFromA
	 */
	public JButton getBtnWithdrawFromA() {
		return btnWithdrawFromA;
	}
	
	/**
	 * @return the btnEditProfile
	 */
	public JButton getBtnEditProfile() {
		return btnEditProfile;
	}

	/**
	 * @return the btnViewOpenCourses
	 */
	public JButton getBtnViewOpenCourses() {
		return btnViewOpenCourses;
	}
	
}
