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

public class AdminViewCourse extends JFrame {

	private JPanel contentPane;
	private JButton btnReturn;
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
					AdminViewCourse frame = new AdminViewCourse();
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
	public AdminViewCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseInformation = new JLabel("Course Search");
		lblCourseInformation.setBounds(164, 81, 310, 54);
		lblCourseInformation.setForeground(Color.WHITE);
		lblCourseInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		contentPane.add(lblCourseInformation);
		
		btnReturn = new JButton("Return to course management menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(321, 37, 307, 29);
		contentPane.add(btnReturn);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a course below to view its information.");
		lblPleaseSelectA.setForeground(Color.WHITE);
		lblPleaseSelectA.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPleaseSelectA.setBounds(97, 148, 464, 16);
		contentPane.add(lblPleaseSelectA);
		
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
