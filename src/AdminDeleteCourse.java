import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AdminDeleteCourse extends JFrame {

	private static JPanel contentPane;
	private JButton btnReturn;
	private JButton btnDelete;
	static JScrollPane scrollPane;
	private  JList jlist;
	DefaultListModel list;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDeleteCourse frame = new AdminDeleteCourse();
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
	public AdminDeleteCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteACourse = new JLabel("Delete a Course");
		lblDeleteACourse.setForeground(Color.WHITE);
		lblDeleteACourse.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblDeleteACourse.setBounds(146, 57, 359, 79);
		contentPane.add(lblDeleteACourse);
		
		btnReturn = new JButton("Return to course management menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnReturn.setBounds(299, 30, 330, 29);
		contentPane.add(btnReturn);
		
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnDelete.setBounds(421, 351, 104, 29);
		contentPane.add(btnDelete);
		
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
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}
	
}
