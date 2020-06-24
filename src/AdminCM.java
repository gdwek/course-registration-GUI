import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminCM extends JFrame {

	private JPanel contentPane;
	public JButton btnReturn;
	public JButton btnAdd;
	private JButton btnDelete;
	private JButton btnRegisterAStudent;
	private JButton btnViewCourseInfo;
	private JButton btnEditACourse;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCM frame = new AdminCM();
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
	public AdminCM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReturn = new JButton("Return to main menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(447, 20, 180, 29);
		contentPane.add(btnReturn);
		
		btnAdd = new JButton("Add a course");
		btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAdd.setBounds(116, 254, 209, 79);
		contentPane.add(btnAdd);
		
		JLabel lblCourseManagement = new JLabel("Course Management");
		lblCourseManagement.setForeground(Color.WHITE);
		lblCourseManagement.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblCourseManagement.setBounds(95, 69, 532, 79);
		contentPane.add(lblCourseManagement);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an option from the menu below.");
		lblPleaseSelectAn.setForeground(Color.WHITE);
		lblPleaseSelectAn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblPleaseSelectAn.setBounds(43, 156, 596, 45);
		contentPane.add(lblPleaseSelectAn);
		
		btnDelete = new JButton("Delete a course");
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnDelete.setBounds(326, 254, 209, 79);
		contentPane.add(btnDelete);
		
		btnEditACourse = new JButton("Edit a course");
		btnEditACourse.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnEditACourse.setBounds(24, 381, 209, 79);
		contentPane.add(btnEditACourse);
		
		btnViewCourseInfo = new JButton("View a course's info");
		btnViewCourseInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnViewCourseInfo.setBounds(234, 381, 209, 79);
		contentPane.add(btnViewCourseInfo);
		
	    btnRegisterAStudent = new JButton("Register a student");
		btnRegisterAStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegisterAStudent.setBounds(444, 381, 209, 79);
		contentPane.add(btnRegisterAStudent);
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @return the btnRegisterAStudent
	 */
	public JButton getBtnRegisterAStudent() {
		return btnRegisterAStudent;
	}
	
	/**
	 * @return the btnViewCourseInfo
	 */
	public JButton getBtnViewCourseInfo() {
		return btnViewCourseInfo;
	}
	
	/**
	 * @return the btnEditACourse
	 */
	public JButton getBtnEditACourse() {
		return btnEditACourse;
	}
	
	
}
