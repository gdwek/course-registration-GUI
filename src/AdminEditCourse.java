 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class AdminEditCourse extends JFrame {

	public JPanel contentPane;
	private JButton btnReturn;
	private JButton btnEdit;
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
					AdminEditCourse frame = new AdminEditCourse();
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
	public AdminEditCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditACourse = new JLabel("Edit A Course");
		lblEditACourse.setForeground(Color.WHITE);
		lblEditACourse.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblEditACourse.setBounds(175, 49, 319, 79);
		contentPane.add(lblEditACourse);
		
		JLabel lblSelectTheCourse = new JLabel("Select the course you would like to edit.");
		lblSelectTheCourse.setForeground(Color.WHITE);
		lblSelectTheCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSelectTheCourse.setBounds(140, 140, 360, 22);
		contentPane.add(lblSelectTheCourse);
		
		btnReturn = new JButton("Return to course management menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(328, 26, 307, 29);
		contentPane.add(btnReturn);
		
		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnEdit.setBounds(441, 380, 85, 29);
		contentPane.add(btnEdit);
		
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
	 * @return the btnEdit
	 */
	public JButton getBtnEdit() {
		return btnEdit;
	}

	/**
	 * @return the jlist
	 */
	public  JList getJlist() {
		return jlist;
	}

	/**
	 * @return the list
	 */
	public static DefaultListModel getList() {
		return list;
	}
	
	
}
