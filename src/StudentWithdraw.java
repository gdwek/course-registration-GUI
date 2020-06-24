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

public class StudentWithdraw extends JFrame {

	private JPanel contentPane;
	private JButton btnReturn;
	private JButton btnWithdraw;
	static JScrollPane scrollPane;
	private  JList jlist;
	DefaultListModel list;

	
	/**
	 * Create the frame.
	 */
	public StudentWithdraw(StudentClass student) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteACourse = new JLabel("Withdraw from a Course");
		lblDeleteACourse.setForeground(Color.WHITE);
		lblDeleteACourse.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblDeleteACourse.setBounds(68, 57, 542, 79);
		contentPane.add(lblDeleteACourse);
		
		btnReturn = new JButton("Return to main menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnReturn.setBounds(299, 30, 330, 29);
		contentPane.add(btnReturn);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnWithdraw.setBounds(421, 351, 104, 29);
		contentPane.add(btnWithdraw);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 176, 279, 434);
		contentPane.add(scrollPane);
		
		jlist = new JList();
		list = new DefaultListModel();
		for(int i= 0; i<student.myCourses.size(); i++) {
			list.add(i, student.myCourses.get(i).getCourseName() + " (Section: " + student.myCourses.get(i).getSection() + ")");
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
	 * @return the btnWithdraw
	 */
	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}

	/**
	 * @return the list
	 */
	public DefaultListModel getList() {
		return list;
	}
	
	
}
