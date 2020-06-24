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

public class AdminStudentsInCourse extends JFrame {

	private JPanel contentPane;
	private JButton btnReturnToReports;
	private JButton btnView;
	static JScrollPane scrollPane;
	private  JList jlist;
	static DefaultListModel list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStudentsInCourse frame = new AdminStudentsInCourse();
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
	public AdminStudentsInCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewRosters = new JLabel("View Rosters");
		lblViewRosters.setForeground(Color.WHITE);
		lblViewRosters.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblViewRosters.setBounds(186, 58, 289, 79);
		contentPane.add(lblViewRosters);
		
		btnReturnToReports = new JButton("Return to reports menu");
		btnReturnToReports.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturnToReports.setBounds(423, 29, 200, 29);
		contentPane.add(btnReturnToReports);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a course below to view its roster.");
		lblPleaseSelectA.setForeground(Color.WHITE);
		lblPleaseSelectA.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPleaseSelectA.setBounds(97, 148, 404, 16);
		contentPane.add(lblPleaseSelectA);
		
		btnView = new JButton("View");
		btnView.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnView.setBounds(439, 374, 80, 29);
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
