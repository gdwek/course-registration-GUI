import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class StudentViewMyCourses extends JFrame {

	public static JPanel contentPane;
	private static TextArea textArea;
	static JScrollPane scrollPane;
	private JLabel label;
	private static JLabel lblNoCourses;
	private JButton btnReturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentViewMyCourses frame = new StudentViewMyCourses();
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
	public StudentViewMyCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 659, 707);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeading = new JLabel("Here is your course list:");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblHeading.setBounds(144, 68, 365, 41);
		contentPane.add(lblHeading);
		
		btnReturn = new JButton("Return to main menu");
		btnReturn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnReturn.setBounds(431, 27, 194, 29);
		contentPane.add(btnReturn);
		
		label = new JLabel("________________________________________________________________________________");
		label.setForeground(Color.WHITE);
		label.setBounds(47, 114, 627, 16);
		contentPane.add(label);
		
		lblNoCourses = new JLabel("You are not registered in any courses.");
		lblNoCourses.setForeground(Color.RED);
		lblNoCourses.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNoCourses.setBounds(150, 307, 511, 34);
		
		textArea = new TextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
     	textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
     	textArea.setBounds(0, 124, 659, 561);
		textArea.setEditable(false);
	}
	
	/**
	 * @return the btnReturn
	 */
	public JButton getBtnReturn() {
		return btnReturn;
	}
	
	/**
	 * @return the textArea
	 */
	public static TextArea getTextArea() {
		return textArea;
	}
	
	/**
	 * @return the lblNoCourses
	 */
	public static JLabel getLblNoCourses() {
		return lblNoCourses;
	}
}
