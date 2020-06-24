import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class AdminStudentCourses extends JFrame {

	private JPanel contentPane;
	private JButton btnReturnToReports;
	private JButton btnView;
	static JScrollPane scrollPane;
	private JList jlist;
	static DefaultListModel list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStudentCourses frame = new AdminStudentCourses();
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
	public AdminStudentCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentCourseLists = new JLabel("Student Course Lists");
		lblStudentCourseLists.setForeground(Color.WHITE);
		lblStudentCourseLists.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblStudentCourseLists.setBounds(95, 58, 512, 54);
		contentPane.add(lblStudentCourseLists);
		
		btnReturnToReports = new JButton("Return to reports menu");
		btnReturnToReports.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToReports.setBounds(407, 25, 200, 29);
		contentPane.add(btnReturnToReports);
		
		JLabel lblSelectAStudent = new JLabel("Select a student from the menu below.");
		lblSelectAStudent.setForeground(Color.WHITE);
		lblSelectAStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSelectAStudent.setBounds(156, 124, 345, 22);
		contentPane.add(lblSelectAStudent);
		
		btnView = new JButton("View");
		btnView.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnView.setBounds(404, 367, 104, 29);
		contentPane.add(btnView);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 196, 279, 434);
		contentPane.add(scrollPane);
		
		jlist = new JList();
		list = new DefaultListModel();
		jlist.setFont(new Font("Lucinda Grande",Font.PLAIN, 14));
		for(int i= 0; i<AdminClass.allStudents.size(); i++) {
			list.add(i, ((Student) AdminClass.allStudents.get(i)).getFullName());
		}
		jlist.setModel(list);
		scrollPane.setViewportView(jlist);
		jlist.setLayoutOrientation(JList.VERTICAL);
		contentPane.add(scrollPane);
	}
	/**
	 * @return the btnReturnToReports
	 */
	public JButton getBtnReturnToReports() {
		return btnReturnToReports;
	}
	
	/**
	 * @return the btnView
	 */
	public JButton getBtnView() {
		return btnView;
	}

	/**
	 * @return the jlist
	 */
	public JList getJlist() {
		return jlist;
	}
}
